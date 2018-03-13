package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FluentLookupPage extends MainPage {

    @FindBy(css = "[name='firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "[name='lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "[name='address.street']")
    private WebElement streetInput;

    @FindBy(css = "[name='address.city']")
    private WebElement cityInput;

    @FindBy(css = "[name='address.state']")
    private WebElement stateInput;

    @FindBy(css = "[name='address.zipCode']")
    private WebElement zipCodeInput;

    @FindBy(css = "[name='ssn']")
    private WebElement ssnInput;

    @FindBy(css = "[value='Find My Login Info']")
    private WebElement findButton;

    public FluentLookupPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FluentLookupPage setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FluentLookupPage setLastName(String lastName){
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FluentLookupPage setStreet(String street){
        streetInput.sendKeys(street);
        return this;
    }

    public FluentLookupPage setCity(String city){
        cityInput.sendKeys(city);
        return this;
    }

    public FluentLookupPage setState(String state){
        stateInput.sendKeys(state);
        return this;
    }

    public FluentLookupPage setZipCode(String zipCode){
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public FluentLookupPage setSsn(String ssn){
        ssnInput.sendKeys(ssn);
        return this;
    }

    public FluentLookupPage clickFindButton(){
        findButton.click();
        return this;
    }

}
