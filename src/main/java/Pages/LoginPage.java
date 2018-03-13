package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends MainPage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public String getErrorText(){
        return driver.findElement(By.cssSelector(".error")).getText();
    }

    public String isNoCredentialsErrorDisplayed(){
        return getErrorText();
    }

    public String isWrongCredentialsErrorDisplayed(){
        return getErrorText();
    }
}
