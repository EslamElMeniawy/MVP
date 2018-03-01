package elmeniawy.eslam.mvp.login;

import dagger.Module;
import dagger.Provides;

/**
 * LoginModule
 * <p>
 * Created by Eslam El-Meniawy on 28-Feb-2018.
 * CITC - Mansoura University
 */

@Module
public class LoginModule {
    @Provides
    public LoginActivityMVP.Presenter providedLoginActivityPresenter(LoginActivityMVP.Model model) {
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }
}
