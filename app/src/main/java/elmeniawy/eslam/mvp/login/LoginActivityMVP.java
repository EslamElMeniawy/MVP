package elmeniawy.eslam.mvp.login;

/**
 * LoginActivityMVP
 * <p>
 * Created by Eslam El-Meniawy on 28-Feb-2018.
 * CITC - Mansoura University
 */

public interface LoginActivityMVP {
    interface View {
        String getFirstName();

        String getLastName();

        void showUserNotAvailable();

        void showInputError();

        void showUserSavedMessage();

        void setFirstName(String firstName);

        void setLastName(String lastName);
    }

    interface Presenter {
        void setView(LoginActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();
    }

    interface Model {
        void createUser(String firstName, String lastName);

        User getUser();
    }
}
