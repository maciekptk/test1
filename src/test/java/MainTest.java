import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;
    AccountPage accountPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    LookupPage lookupPage;
    RegisterTwoPage registerTwoPage;


    Random rg = new Random();
    int randomInt = rg.nextInt(1000);

    String firstName = "Mark";
    String lastName = "Spencer";
    String street = "Main Street 10";
    String city = "Los Angeles";
    String state = "California";
    String zipCode = "90002";
    String ssnTemplate = "AABB";
    String usernameTemplate = "markspencer";
    String password = "asdfzxcv";
    String username = usernameTemplate + randomInt;
    String ssn = ssnTemplate + randomInt;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        accountPage = new AccountPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        lookupPage = new LookupPage(driver);
        registerTwoPage = new RegisterTwoPage(driver);

    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
