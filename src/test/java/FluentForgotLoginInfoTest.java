import org.testng.annotations.Test;

public class FluentForgotLoginInfoTest extends MainTest {

    @Test
    public void shouldRestoreLoginInfo(){
        indexPage.openIndexPage()
                .openFluentLookupPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStreet(street)
                .setCity(city)
                .setState(state)
                .setZipCode(zipCode)
                .setSsn(ssn)
                .clickFindButton();
    }
}
