import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotLoginInfoTest extends RegistrationTest {

    @Test
    public void successfulLoginRestore() {
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        register(); // new registration first because of frequent data refresh on Parabank site and to make sure that provided credentials exist

        driver.findElement(By.cssSelector("[href$='logout.htm']")).click();
        driver.findElement(By.cssSelector("[href^='lookup.htm']")).click();
        driver.findElement(By.cssSelector("[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[name='lastName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[name='address.street']")).sendKeys(street);
        driver.findElement(By.cssSelector("[name='address.city']")).sendKeys(city);
        driver.findElement(By.cssSelector("[name='address.state']")).sendKeys(state);
        driver.findElement(By.cssSelector("[name='address.zipCode']")).sendKeys(zipCode);
        driver.findElement(By.cssSelector("[name='ssn']")).sendKeys(ssn);
        driver.findElement(By.cssSelector("[value='Find My Login Info']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[href$='logout.htm']")).isDisplayed());

        driver.close();
    }

    @Test
    public void missingRequiredFields() {
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        driver.findElement(By.cssSelector("[href^='lookup.htm']")).click();
        driver.findElement(By.cssSelector("[value='Find My Login Info']")).click();
        Assert.assertFalse(driver.findElements(By.cssSelector(".error")).isEmpty());

        driver.close();
    }

    @Test
    public void customerNotFound() {
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        driver.findElement(By.cssSelector("[href^='lookup.htm']")).click();
        driver.findElement(By.cssSelector("[name='firstName']")).sendKeys("First");
        driver.findElement(By.cssSelector("[name='lastName']")).sendKeys("Last");
        driver.findElement(By.cssSelector("[name='address.street']")).sendKeys("Street");
        driver.findElement(By.cssSelector("[name='address.city']")).sendKeys("City");
        driver.findElement(By.cssSelector("[name='address.state']")).sendKeys("State");
        driver.findElement(By.cssSelector("[name='address.zipCode']")).sendKeys("Zip");
        driver.findElement(By.cssSelector("[name='ssn']")).sendKeys("SSN");
        driver.findElement(By.cssSelector("[value='Find My Login Info']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error")).getText(), "The customer information provided could not be found.");

        driver.close();
    }
}
