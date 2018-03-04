package elmeniawy.eslam.mvp.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ApplicationModule
 * <p>
 * Created by Eslam El-Meniawy on 25-Feb-2018.
 * CITC - Mansoura University
 */

@Module
public class ApplicationModule {
    @Provides
    @Singleton
    public Context provideContext(App application) {
        return application.getApplicationContext();
    }
}
