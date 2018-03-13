package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterTwoPage extends MainPage {

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

    @FindBy(css = "[id='customer.firstName.errors']")
    private WebElement firstNameError;

    @FindBy(css = "[href$='logout.htm']")
    private WebElement logoutButton;

    @FindBy(css = "[id='customer.username.errors']")
    private WebElement usernameError;

    public RegisterTwoPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void setStreet(String street){
        streetInput.sendKeys(street);
    }

    public void setCity(String city){
        cityInput.sendKeys(city);
    }

    public void setState(String state){
        stateInput.sendKeys(state);
    }

    public void setZipCode(String zipCode){
        zipCodeInput.sendKeys(zipCode);
    }

    public void setSsn(String ssn){
        ssnInput.sendKeys(ssn);
    }

    public void setUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void setRepeatedPassword(String password){
        repeatedPasswordInput.sendKeys(password);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public void fillInForm(String firstName, String lastName, String street, String city, String state, String zipCode, String ssn, String username, String password){
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

    public boolean isMissingUsernameErrorDisplayed(){
        return firstNameError.isDisplayed();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public String getExistingUsernameErrorText(){
        return usernameError.getText();
    }
}
