package elmeniawy.eslam.mvp.root;

import javax.inject.Singleton;

import dagger.Component;
import elmeniawy.eslam.mvp.login.LoginActivity;
import elmeniawy.eslam.mvp.login.LoginModule;

/**
 * ApplicationComponent
 * <p>
 * Created by Eslam El-Meniawy on 25-Feb-2018.
 * CITC - Mansoura University
 */

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
