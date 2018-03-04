package elmeniawy.eslam.mvp.topmovies;

import java.util.List;

import elmeniawy.eslam.mvp.http.apimodel.Result;
import io.reactivex.Observable;

/**
 * TopMoviesRepositoryInterface
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public interface TopMoviesRepositoryInterface {
    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();
}
