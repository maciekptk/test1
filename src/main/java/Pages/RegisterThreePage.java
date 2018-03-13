package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterThreePage extends MainPage {

    @FindBy(css = "[name='customer.firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "[name='customer.lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "[name='customer.address.street']")
    private WebElement streetInput;

    @FindBy(css = "[name='customer.address.city']")
    private WebElement cityInput;

    @FindBy(css = "[name='customer.address.state']")
    private WebElement stateInput;

    @FindBy(css = "[name='customer.address.zipCode']")
    private WebElement zipCodeInput;

    @FindBy(css = "[name='customer.ssn']")
    private WebElement ssnInput;

    @FindBy(css = "[name='customer.username']")
    private WebElement usernameInput;

    @FindBy(css = "[name='customer.password']")
    private WebElement passwordInput;

    @FindBy(css = "[name='repeatedPassword']")
    private WebElement repeatedPasswordInput;

    @FindBy(css = "[value='Register']")
    private WebElement registerButton;



    public RegisterThreePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public RegisterThreePage setFirstName (String firstName){
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterThreePage setLastName (String lastName){
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterThreePage setStreet (String street){
        streetInput.sendKeys(street);
        return this;
    }

    public RegisterThreePage setCity (String city){
        cityInput.sendKeys(city);
        return this;
    }

    public RegisterThreePage setState (String state){
        stateInput.sendKeys(state);
        return this;
    }

    public RegisterThreePage setZipCode (String zipCode){
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public RegisterThreePage setSsn (String ssn){
        ssnInput.sendKeys(ssn);
        return this;
    }

    public RegisterThreePage setUsername (String username){
        usernameInput.sendKeys(username);
        return this;
    }

    public RegisterThreePage setPassword (String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterThreePage setRepeatedPassword (String password){
        repeatedPasswordInput.sendKeys(password);
        return this;
    }

    public WelcomePage clickRegisterButton (){
        registerButton.click();
        return new WelcomePage(driver);
    }


}
