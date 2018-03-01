package elmeniawy.eslam.mvp.login;

/**
 * LoginRepository
 * <p>
 * Created by Eslam El-Meniawy on 28-Feb-2018.
 * CITC - Mansoura University
 */

public interface LoginRepository {
    User getUser();

    void saveUser(User user);
}
