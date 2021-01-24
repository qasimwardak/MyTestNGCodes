package TestNg.Class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Homework {
   /* TC 1: HRMS Add Employee:
    Open chrome browser
    Go to “http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    Login into the application
    Click on org.apache.commons.math3.analysis.function.Add Employee
    Verify labels: Full Name, Employee Id, Photograph are displayed
    Provide Employee First and Last Name
    Add a picture to the profile
    Verify Employee has been added successfully
    Close the browser*/

       @BeforeMethod
               public void Login(){
           System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
           WebDriver driver=new ChromeDriver();
           driver.get("http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
           driver.findElement(By.id("txtUsername")).sendKeys("Admin1");
           driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
           driver.findElement(By.id("btnLogin")).click();

       }


   }
