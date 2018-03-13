import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExample1 {
    WebDriver driver;

    @Test
    public void shouldLogin() {
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com");

        waitForJStoLoad();

        driver.findElement(By.cssSelector("[name=username]")).sendKeys("John");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("123123!$L");
        //driver.findElement(By.xpath("//input[@class='button']")).click(); // xpath
        driver.findElement(By.cssSelector(".login .button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[href$='logout.htm']")).isDisplayed());

        driver.close();
    }

    @Test
    public void shouldNotLogin() {

        driver = new ChromeDriver();

        driver.get("http://parabank.parasoft.com");

        waitForJStoLoad();

        driver.findElement(By.cssSelector("[name=username]")).sendKeys("Johnny"); // wrong username
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("123123!$L");
        driver.findElement(By.cssSelector(".login .button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".error")).isDisplayed());

        driver.close();
    }

    @Test
    public void noUserNoPassword() {

        driver = new ChromeDriver();

        driver.get("http://parabank.parasoft.com");

        waitForJStoLoad();

        driver.findElement(By.cssSelector(".login .button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error")).getText(), "Please enter a username and password.");

        driver.close();
    }

    @Test
    public void registration() {
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com");
        waitForJStoLoad();

        driver.findElement(By.cssSelector("[href^='register.htm']")).click();
        Assert.assertTrue(driver.findElement(By.id("customer.firstName")).isDisplayed());

        driver.close();
    }

    @Test
    public void testSelenium() { // metoda na test problemu z if gdy nie ma elementu na stronie
        driver = new ChromeDriver();
        driver.get("http://parabank.parasoft.com");
        waitForJStoLoad();

        if(driver.findElement(By.cssSelector("[href$='logout.htm']")).isDisplayed()){
            driver.findElement(By.cssSelector("[href$='logout.htm']")).click();
        }else {
            driver.findElement(By.cssSelector("[href^='register.htm']")).click();
        }

        //Assert.assertTrue(driver.findElement(By.id("customer.firstName")).isDisplayed());

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
