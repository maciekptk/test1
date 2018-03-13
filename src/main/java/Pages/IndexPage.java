package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends MainPage {

    public IndexPage(WebDriver driver){
        super(driver);
    }

    public IndexPage openIndexPage(){
        driver.get("http://parabank.parasoft.com");
        waitForJStoLoad();
        return this;
    }

    public void setUsername(String username){
        driver.findElement(By.cssSelector("[name=username]")).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(By.cssSelector(".login .button")).click();
    }

    public RegisterThreePage openRegistrationPage() {
        driver.findElement(By.cssSelector("[href^='register.htm']")).click();
        waitForJStoLoad();
        return new RegisterThreePage(driver);
    }

    public void openLookupPage() {
        driver.findElement(By.cssSelector("[href^='lookup.htm']")).click();
    }

    public FluentLookupPage openFluentLookupPage(){
        driver.findElement(By.cssSelector("[href^='lookup.htm']")).click();
        return new FluentLookupPage(driver);
    }
}
