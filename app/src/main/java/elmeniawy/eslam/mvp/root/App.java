package elmeniawy.eslam.mvp.root;

import android.app.Application;

import elmeniawy.eslam.mvp.login.LoginModule;

/**
 * App
 * <p>
 * Created by Eslam El-Meniawy on 25-Feb-2018.
 * CITC - Mansoura University
 */

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
