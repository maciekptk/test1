import org.testng.Assert;
import org.testng.annotations.Test;

public class PopLoginTest extends MainTest {

    @Test
    public void shouldLogin() {
        indexPage.openIndexPage();
        indexPage.openRegistrationPage(); // new registration first to make sure that credentials provided below already exists
        registerPage.fillInRegistrationForm(firstName, lastName, street, city, state, zipCode, ssn, username, password);
        registerPage.clickRegisterButton();
        registerPage.clickLogoutButton();

        indexPage.openIndexPage();
        indexPage.setUsername(username);
        indexPage.setPassword(password);
        indexPage.clickLoginButton();
        Assert.assertTrue(accountPage.isUserLoggedIn());
    }

    @Test
    public void noCredentials() {
        indexPage.openIndexPage();
        indexPage.clickLoginButton();
        Assert.assertEquals(loginPage.isNoCredentialsErrorDisplayed(), "Please enter a username and password.");
    }

    @Test
    public void wrongCredentials() {
        indexPage.openIndexPage();
        indexPage.setUsername("wrongUsername");
        indexPage.setPassword("wrongPassword");
        indexPage.clickLoginButton();
        Assert.assertEquals(loginPage.isWrongCredentialsErrorDisplayed(), "The username and password could not be verified.");
    }
}
