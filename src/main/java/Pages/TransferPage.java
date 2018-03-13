package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferPage extends MainPage {

    @FindBy(css = "[name='amount']")
    private WebElement amountInput;

    @FindBy(css = "[name='fromAccountId'] [value='13566']")
    private WebElement fromAccountSelector;

    @FindBy(css = "[name='toAccountId'] [value='13566']")
    private WebElement toAccountSelector;

    @FindBy(css = "[value='Transfer']")
    private WebElement transferButton;

    public TransferPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TransferPage setAmount(String amount){
        amountInput.sendKeys(amount);
        return this;
    }

    public TransferPage setFromAccountId(String fromAccountId){
        fromAccountSelector.click();
        return this;
    }

    public TransferPage setToAccountId(String toAccountId){
        toAccountSelector.click();
        return this;
    }

    public TransferPage clickTransferButton(){
        transferButton.click();
        return this;
    }
}
