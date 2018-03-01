package elmeniawy.eslam.mvp.login;

/**
 * LoginModel
 * <p>
 * Created by Eslam El-Meniawy on 28-Feb-2018.
 * CITC - Mansoura University
 */

public class LoginModel implements LoginActivityMVP.Model {
    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String firstName, String lastName) {
        repository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
