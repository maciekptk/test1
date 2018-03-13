import org.testng.Assert;
import org.testng.annotations.Test;

public class PageFactoryRegistrationTest extends MainTest {
    @Test
    public void shouldRegisterTwo() {
        username = username + randomInt; // initialize new value of username to avoid conflict with existingUsername test method
        indexPage.openIndexPage();
        indexPage.openRegistrationPage();
        registerTwoPage.fillInForm(firstName, lastName, street, city, state, zipCode, ssn, username, password);
        registerTwoPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getWelcomeMessage(), "Welcome " + username);
    }

    @Test
    public void missingUsernameTwo(){
        indexPage.openIndexPage();
        indexPage.openRegistrationPage();
        registerTwoPage.clickRegisterButton();

        Assert.assertTrue(registerTwoPage.isMissingUsernameErrorDisplayed());
    }

    @Test
    public void existingUsernameTwo(){
        shouldRegisterTwo(); // new registration first to make sure that the username provided below already exists
        registerTwoPage.clickLogoutButton();
        indexPage.openRegistrationPage();
        indexPage.openRegistrationPage();
        registerTwoPage.fillInForm(firstName, lastName, street, city, state, zipCode, ssn, username, password);
        registerTwoPage.clickRegisterButton();

        Assert.assertEquals(registerTwoPage.getExistingUsernameErrorText(), "This username already exists.");
    }

}
