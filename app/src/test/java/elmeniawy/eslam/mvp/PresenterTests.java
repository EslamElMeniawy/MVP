package elmeniawy.eslam.mvp;

import org.junit.Before;
import org.junit.Test;

import elmeniawy.eslam.mvp.login.LoginActivityMVP;
import elmeniawy.eslam.mvp.login.LoginActivityPresenter;
import elmeniawy.eslam.mvp.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * PresenterTests
 * <p>
 * Created by Eslam El-Meniawy on 01-Mar-2018.
 * CITC - Mansoura University
 */

public class PresenterTests {
    private LoginActivityMVP.Model mockLoginModel;
    private LoginActivityMVP.View mockView;
    private LoginActivityPresenter presenter;
    private User user;
    private String firstName = "Test", lastName = "User", emptyString = "";

    @Before
    public void setup() {
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        user = new User(firstName, lastName);
        mockView = mock(LoginActivityMVP.View.class);
        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockView);
    }

    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent() {
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();

        // Verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        // Verify view interactions
        verify(mockView, times(1)).setFirstName(firstName);
        verify(mockView, times(1)).setLastName(lastName);
        verify(mockView, never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        when(mockLoginModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();

        // Verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        // Verify view interactions
        verify(mockView, never()).setFirstName(firstName);
        verify(mockView, never()).setLastName(lastName);
        verify(mockView, times(1)).showUserNotAvailable();
    }

    @Test
    public void shouldCreateErrorMessageIfFirstNameEmpty() {
        // Don't set first name
        when(mockView.getFirstName()).thenReturn(emptyString);

        presenter.loginButtonClicked();

        // Verify view interactions
        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();
    }

    @Test
    public void shouldCreateErrorMessageIfLastNameEmpty() {
        // Set first name but don't set last name
        when(mockView.getFirstName()).thenReturn(firstName);
        when(mockView.getLastName()).thenReturn(emptyString);

        presenter.loginButtonClicked();

        // Verify view interactions
        verify(mockView, times(1)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(1)).showInputError();
    }

    @Test
    public void shouldBeAbleToSaveValidUser() {
        // Set first & last names
        when(mockView.getFirstName()).thenReturn(firstName);
        when(mockView.getLastName()).thenReturn(lastName);

        presenter.loginButtonClicked();

        // Verify view interactions
        verify(mockView, times(2)).getFirstName(); // Called two more times in the loginButtonClicked call
        verify(mockView, times(2)).getLastName();

        // Make sure repository saved the user
        verify(mockLoginModel, times(1)).createUser(firstName, lastName);

        // Make sure that the view showed the user saved message
        verify(mockView, times(1)).showUserSavedMessage();
    }
}
