package elmeniawy.eslam.mvp.login;

/**
 * MemoryRepository
 * <p>
 * Created by Eslam El-Meniawy on 28-Feb-2018.
 * CITC - Mansoura University
 */

public class MemoryRepository implements LoginRepository {
    private User user;

    @Override
    public User getUser() {
        if (user == null) {
            User user = new User("Test", "User");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        }

        this.user = user;
    }
}
