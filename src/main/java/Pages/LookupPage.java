package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LookupPage extends MainPage {

    public LookupPage(WebDriver driver){
        super(driver);
    }

    public void setLookupFirstName(String firstName) {
        driver.findElement(By.cssSelector("[name='firstName']")).sendKeys(firstName);
    }

    public void setLookupLastName(String lastName) {
        driver.findElement(By.cssSelector("[name='lastName']")).sendKeys(lastName);
    }

    public void setLookupStreet (String street) {
        driver.findElement(By.cssSelector("[name='address.street']")).sendKeys(street);
    }

    public void setLookupCity (String city) {
        driver.findElement(By.cssSelector("[name='address.city']")).sendKeys(city);
    }

    public void setLookupState(String state) {
        driver.findElement(By.cssSelector("[name='address.state']")).sendKeys(state);
    }

    public void setLookupZipCode(String zipCode) {
        driver.findElement(By.cssSelector("[name='address.zipCode']")).sendKeys(zipCode);
    }

    public void setLookupSsn (String ssn) {
        driver.findElement(By.cssSelector("[name='ssn']")).sendKeys(ssn);
    }

    public void clickFindButton(){
        driver.findElement(By.cssSelector("[value='Find My Login Info']")).click();
    }

    public String getLookupText(){
        return driver.findElement(By.cssSelector("#rightPanel p:first-of-type")).getText();
    }

    public boolean checkIfErrors(){
        return driver.findElements(By.cssSelector(".error")).isEmpty();
    }

    public String getErrorText(){
        return driver.findElement(By.cssSelector(".error")).getText();
    }
}
