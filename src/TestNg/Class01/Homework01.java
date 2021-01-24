package TestNg.Class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class Homework01 {
    /*HW
    US 17666 Syntax Logo should be present on the login page
    US 17667 Error message "
    Invalid credentials" should be displayed when user enters invalid credentials*/
    WebDriver driver;
    @BeforeMethod
    public void HrmTitle(){
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void syntaxLogo(){
        WebElement isLogoDisplayed = driver.findElement(By.xpath("//img[contains (@src , '/default/images/login/syntax.png')]"));
        System.out.println(isLogoDisplayed.isEnabled());
    }
    @Test
    public void invalidCredentials(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Humanhrm123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement IcText = driver.findElement(By.id("spanMessage"));
        if (IcText.isDisplayed()) {
            System.out.println(IcText.getText());
        }else {
            System.out.println("No Message");
        }
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}