import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends RegistrationTest {

    @Test
    public void successfulLogin(){
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        register(); // new registration first because of frequent data refresh on Parabank site and to make sure that provided credentials exist

        driver.findElement(By.cssSelector("[href$='logout.htm']")).click();
        driver.findElement(By.cssSelector("[type=text]")).sendKeys(username);
        driver.findElement(By.cssSelector("[type=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[href$='logout.htm']")).isDisplayed());

        driver.close();
    }


    @Test
    public void missingCredentials(){
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        driver.findElement(By.cssSelector("[type=submit]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error")).getText(), "Please enter a username and password.");

        driver.close();
    }

    @Test
    public void wrongCredentials(){
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        driver.findElement(By.cssSelector("[type=text]")).sendKeys("fakeusername");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("fakepassword");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error")).getText(), "The username and password could not be verified.");

        driver.close();
    }
}
