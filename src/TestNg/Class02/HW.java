package TestNg.Class02;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HW {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openAndNavigate() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qasim\\eclipse-workspace\\TestNg\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }

    //@Test(priority = 0, enabled = true, groups = "regression")
    public void logoValidation() {
        WebElement logo = driver.findElement(By.cssSelector("img[src$='syntax.png']"));
//        if(logo.isDisplayed()) {
//            System.out.println("Logo is displayed. Test Pass");
//        } else {
//            System.out.println("Logo is not displayed. Test Fail");
//        }

        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
    }

    @Test (priority = 1, groups = "smoke")
    public void invalidCredentials() {
        driver.findElement(By.id("txtUsername")).sendKeys("Admin1");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm1234");
        driver.findElement(By.id("btnLogin")).click();
        String errorMessageText = driver.findElement(By.id("spanMessage")).getText();
        String expectedErrorMessage="Invalid Credentials";

//        if(errorMessageText.equals(expectedErrorMessage)) {
//            System.out.println("Error message 'Invalid credentials' is displayed. Test Pass");
//        } else {
//            System.out.println("Error message is not present. Test Fail");
//        }
        System.out.println("My code before the assertion");
        Assert.assertEquals(errorMessageText, expectedErrorMessage, "Not correct error message is displayed" );
        System.out.println("My code after the assertion");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
