import org.testng.Assert;
import org.testng.annotations.Test;

public class PopRegistrationTest extends MainTest {

    @Test
    public void shouldRegister() {
        username = username + randomInt; // initialize new value of username to avoid conflict with existingUsername test method
        indexPage.openIndexPage();
        indexPage.openRegistrationPage();
        registerPage.fillInRegistrationForm(firstName, lastName, street, city, state, zipCode, ssn, username, password);
        registerPage.clickRegisterButton();
        Assert.assertEquals(registerPage.getWelcomeMessage(), "Welcome " + username);
    }

    @Test
    public void missingUsername() {
        indexPage.openIndexPage();
        indexPage.openRegistrationPage();
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.isMissingUsernameErrorDisplayed());
    }

    @Test
    public void existingUsername() {
        shouldRegister(); // new registration first to make sure that the username provided below already exists
        registerPage.clickLogoutButton();
        indexPage.openIndexPage();
        indexPage.openRegistrationPage();
        registerPage.fillInRegistrationForm(firstName, lastName, street, city, state, zipCode, ssn, username, password);
        registerPage.clickRegisterButton();
    }

    //Fluent Interface

    @Test
    public void shouldRegisterThree(){
        indexPage.openIndexPage()
                .openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStreet(street)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setSsn(ssn)
                .setUsername(username)
                .setPassword(password)
                .setRepeatedPassword(password)
                .clickRegisterButton()
                .registrationAssertion
                .isWelcomeMessageDisplayed();
    }
}
