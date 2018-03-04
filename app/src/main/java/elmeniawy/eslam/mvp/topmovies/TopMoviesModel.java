package elmeniawy.eslam.mvp.topmovies;

import io.reactivex.Observable;

/**
 * TopMoviesModel
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

public class TopMoviesModel implements TopMoviesActivityMVP.Model {
    private TopMoviesRepositoryInterface repository;

    public TopMoviesModel(TopMoviesRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return Observable.zip(repository.getResultData(),
                repository.getCountryData(),
                (result, s) -> new ViewModel(result.getTitle(), s));
    }
}
