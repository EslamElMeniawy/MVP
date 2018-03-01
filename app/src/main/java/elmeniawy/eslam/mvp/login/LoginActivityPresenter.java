package elmeniawy.eslam.mvp.login;

import android.support.annotation.Nullable;

/**
 * LoginActivityPresenter
 * <p>
 * Created by Eslam El-Meniawy on 28-Feb-2018.
 * CITC - Mansoura University
 */

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {
    @Nullable
    private LoginActivityMVP.View view;

    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getFirstName().trim().isEmpty() || view.getLastName().trim().isEmpty()) {
                view.showInputError();
            } else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }
}
