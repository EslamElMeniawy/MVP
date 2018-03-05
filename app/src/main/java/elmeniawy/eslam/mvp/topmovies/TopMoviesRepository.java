package elmeniawy.eslam.mvp.topmovies;

import java.util.ArrayList;
import java.util.List;

import elmeniawy.eslam.mvp.http.MoreInfoApiService;
import elmeniawy.eslam.mvp.http.MovieApiService;
import elmeniawy.eslam.mvp.http.apimodel.Result;
import elmeniawy.eslam.mvp.http.apimodel.TopRated;
import io.reactivex.Observable;

/**
 * TopMoviesRepository
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public class TopMoviesRepository implements TopMoviesRepositoryInterface {
    private MovieApiService movieApiService;
    private MoreInfoApiService moreInfoApiService;
    private List<String> countries;
    private List<Result> results;
    private long timestamp;

    private static final long STALE_MS = 20 * 1000; // Data is stale after 20 seconds

    TopMoviesRepository(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        this.moreInfoApiService = moreInfoApiService;
        this.timestamp = System.currentTimeMillis();
        this.movieApiService = movieApiService;
        countries = new ArrayList<>();
        results = new ArrayList<>();
    }

    private boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<Result> getResultsFromMemory() {
        if (isUpToDate()) {
            return Observable.fromIterable(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultsFromNetwork() {
        Observable<TopRated> topRatedObservable = movieApiService
                .getTopRatedMovies(1)
                .concatWith(movieApiService.getTopRatedMovies(2))
                .concatWith(movieApiService.getTopRatedMovies(3));

        return topRatedObservable
                .concatMap(topRated -> Observable.fromIterable(topRated.getResults()))
                .doOnNext(result -> results.add(result));
    }

    @Override
    public Observable<String> getCountriesFromMemory() {
        if (isUpToDate()) {
            return Observable.fromIterable(countries);
        } else {
            timestamp = System.currentTimeMillis();
            countries.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<String> getCountriesFromNetwork() {
        return getResultsFromNetwork()
                .concatMap(result -> moreInfoApiService.getCountry(result.getTitle()))
                .concatMap(omdbApi -> Observable.just(omdbApi.getCountry() == null ? "" : omdbApi.getCountry()))
                .doOnNext(s -> countries.add(s));
    }

    @Override
    public Observable<String> getCountryData() {
        return getCountriesFromMemory().switchIfEmpty(getCountriesFromNetwork());
    }

    @Override
    public Observable<Result> getResultData() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }
}
