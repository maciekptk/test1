package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends MainPage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

//    public void openRegistrationPage() {
//        driver.findElement(By.cssSelector("[href^='register.htm']")).click();
//        waitForJStoLoad();
//    }

    public void setFirstName(String firstName) {
        driver.findElement(By.cssSelector("[name='customer.firstName']")).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.cssSelector("[name='customer.lastName']")).sendKeys(lastName);
    }

    public void setStreet(String street) {
        driver.findElement(By.cssSelector("[name='customer.address.street']")).sendKeys(street);
    }

    public void setCity(String city) {
        driver.findElement(By.cssSelector("[name='customer.address.city']")).sendKeys(city);
    }

    public void setState(String state) {
        driver.findElement(By.cssSelector("[name='customer.address.state']")).sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        driver.findElement(By.cssSelector("[name='customer.address.zipCode']")).sendKeys(zipCode);
    }

    public void setSsn(String ssn) {
        driver.findElement(By.cssSelector("[name='customer.ssn']")).sendKeys(ssn);
    }

    public void setUsername(String username) {
        driver.findElement(By.cssSelector("[name='customer.username']")).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(By.cssSelector("[name='customer.password']")).sendKeys(password);
    }

    public void setRepeatedPassword(String password) {
        driver.findElement(By.cssSelector("[name='repeatedPassword']")).sendKeys(password);
    }

    public void clickRegisterButton() {
        driver.findElement(By.cssSelector("[value='Register']")).click();
        waitForJStoLoad();
    }

    public void fillInRegistrationForm(String firstName, String lastName, String street, String city, String state, String zipCode,
                                       String ssn, String username, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreet(street);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setSsn(ssn);
        setUsername(username);
        setPassword(password);
        setRepeatedPassword(password);
    }

    public String getWelcomeMessage() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public boolean isMissingUsernameErrorDisplayed() {
        return driver.findElement(By.cssSelector("[id='customer.username.errors']")).isDisplayed();
    }

    public String getExistingUsernameErrorText() {
        return driver.findElement(By.cssSelector("[id='customer.username.errors']")).getText();
    }
}
