package elmeniawy.eslam.mvp.topmovies;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import elmeniawy.eslam.mvp.http.ApiModuleForName;
import elmeniawy.eslam.mvp.http.MoreInfoApiService;
import elmeniawy.eslam.mvp.http.MovieApiService;

/**
 * TopMoviesModule
 * <p>
 * Created by Eslam El-Meniawy on 04-Mar-2018.
 * CITC - Mansoura University
 */

@Module
public class TopMoviesModule {
    @Provides
    TopMoviesActivityMVP.Presenter providedLoginActivityPresenter(TopMoviesActivityMVP.Model model) {
        return new TopMoviesActivityPresenter(model);
    }

    @Provides
    TopMoviesActivityMVP.Model provideLoginActivityModel(TopMoviesRepositoryInterface repository) {
        return new TopMoviesModel(repository);
    }

    @Provides
    @Singleton
    TopMoviesRepositoryInterface provideTopMoviesRepository(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        return new TopMoviesRepository(movieApiService, moreInfoApiService);
    }
}
