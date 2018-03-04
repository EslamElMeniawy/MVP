package elmeniawy.eslam.mvp.root;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import elmeniawy.eslam.mvp.http.ApiModuleForInfo;
import elmeniawy.eslam.mvp.http.ApiModuleForName;
import elmeniawy.eslam.mvp.login.LoginActivity;
import elmeniawy.eslam.mvp.login.LoginModule;
import elmeniawy.eslam.mvp.topmovies.TopMoviesActivity;
import elmeniawy.eslam.mvp.topmovies.TopMoviesModule;

/**
 * ApplicationComponent
 * <p>
 * Created by Eslam El-Meniawy on 25-Feb-2018.
 * CITC - Mansoura University
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class,
        LoginModule.class, TopMoviesModule.class, ApiModuleForInfo.class, ApiModuleForName.class})
public interface ApplicationComponent extends AndroidInjector<App> {
    void inject(LoginActivity target);
    void inject(TopMoviesActivity target);
}
