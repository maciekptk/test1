package Pages;

import org.openqa.selenium.WebDriver;

public class WelcomePage extends MainPage {

    public Assertions.RegistrationAssertion registrationAssertion;

    public WelcomePage(WebDriver driver){
        super(driver);
        registrationAssertion = new Assertions.RegistrationAssertion(driver);
    }
}
