import org.testng.Assert;
import org.testng.annotations.Test;

public class PopForgotLoginInfoTest extends MainTest {

    @Test
    public void shouldRestoreLoginInfo() {
        indexPage.openIndexPage();
        indexPage.openRegistrationPage(); // new registration first to make sure that credentials provided below already exists
        registerPage.fillInRegistrationForm(firstName, lastName, street, city, state, zipCode, ssn, username, password);
        registerPage.clickRegisterButton();
        registerPage.clickLogoutButton();

        indexPage.openIndexPage();
        indexPage.openLookupPage();
        lookupPage.setLookupFirstName(firstName);
        lookupPage.setLookupLastName(lastName);
        lookupPage.setLookupStreet(street);
        lookupPage.setLookupCity(city);
        lookupPage.setLookupState(state);
        lookupPage.setLookupZipCode(zipCode);
        lookupPage.setLookupSsn(ssn);
        lookupPage.clickFindButton();
        Assert.assertEquals(lookupPage.getLookupText(), "Your login information was located successfully. You are now logged in.");
    }

    @Test
    public void missingRequiredFields() {
        indexPage.openIndexPage();
        indexPage.openLookupPage();
        lookupPage.clickFindButton();
        Assert.assertFalse(lookupPage.checkIfErrors());
    }

    @Test
    public void customerNotFound() {
        indexPage.openIndexPage();
        indexPage.openLookupPage();
        lookupPage.setLookupFirstName(firstName);
        lookupPage.setLookupLastName(lastName);
        lookupPage.setLookupStreet(street);
        lookupPage.setLookupCity(city);
        lookupPage.setLookupState(state);
        lookupPage.setLookupZipCode(zipCode);
        lookupPage.setLookupSsn("SSN");
        lookupPage.clickFindButton();
        Assert.assertEquals(lookupPage.getErrorText(), "The customer information provided could not be found.");
    }
}
