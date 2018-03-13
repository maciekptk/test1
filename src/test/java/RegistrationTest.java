import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class RegistrationTest {
    WebDriver driver;

    String firstName = "Mark";
    String lastName = "Spencer";
    String street = "Main Street 10";
    String city = "Los Angeles";
    String state = "California";
    String zipCode = "90002";
    String ssnTemplate = "AABB";
    String usernameTemplate = "markspencer";
    String password = "asdfzxcv";
    String username;
    String ssn;

    public void register(){
        driver.findElement(By.cssSelector("[href^='register.htm']")).click();
        driver.findElement(By.cssSelector("[name='customer.firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[name='customer.lastName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[name='customer.address.street']")).sendKeys(street);
        driver.findElement(By.cssSelector("[name='customer.address.city']")).sendKeys(city);
        driver.findElement(By.cssSelector("[name='customer.address.state']")).sendKeys(state);
        driver.findElement(By.cssSelector("[name='customer.address.zipCode']")).sendKeys(zipCode);

        Random rg = new Random();
        int randomInt = rg.nextInt(1000);

        ssn = ssnTemplate + randomInt;
        driver.findElement(By.cssSelector("[name='customer.ssn']")).sendKeys(ssn);

        username = usernameTemplate + randomInt;
        driver.findElement(By.cssSelector("[name='customer.username']")).sendKeys(username);

        driver.findElement(By.cssSelector("[name='customer.password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='repeatedPassword']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Register']")).click();
    }

    @Test
    public void successfullRegistration() {
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        register();
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Welcome " + username);

        driver.close();
    }

    @Test
    public void existingUsername(){
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        register(); // new registration first because of frequent data refresh on Parabank site and to make sure that provided credentials exist

        driver.findElement(By.cssSelector("[href$='logout.htm']")).click();

        driver.findElement(By.cssSelector("[href^='register.htm']")).click();
        driver.findElement(By.cssSelector("[name='customer.firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("[name='customer.lastName']")).sendKeys(lastName);
        driver.findElement(By.cssSelector("[name='customer.address.street']")).sendKeys(street);
        driver.findElement(By.cssSelector("[name='customer.address.city']")).sendKeys(city);
        driver.findElement(By.cssSelector("[name='customer.address.state']")).sendKeys(state);
        driver.findElement(By.cssSelector("[name='customer.address.zipCode']")).sendKeys(zipCode);
        driver.findElement(By.cssSelector("[name='customer.ssn']")).sendKeys(ssnTemplate);
        driver.findElement(By.cssSelector("[name='customer.username']")).sendKeys(username);
        driver.findElement(By.cssSelector("[name='customer.password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='repeatedPassword']")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("[id='customer.username.errors']")).getText(), "This username already exists.");

        driver.close();
    }

    @Test
    public void emptyUsername(){
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();

        driver.findElement(By.cssSelector("[href^='register.htm']")).click();
        driver.findElement(By.cssSelector("[value='Register']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("[id='customer.username.errors']")).getText(), "Username is required.");

        driver.close();
    }

    public boolean waitForJStoLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
