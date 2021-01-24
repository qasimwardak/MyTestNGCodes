package TestNg.Class01;

import org.testng.annotations.*;

public class Task2 {
    @Test
    public void myAge(){
        System.out.println("My age is 30 years old");
    }
    @Test
    public void marriageStatus(){
        System.out.println("I am a married man");
    }
    @BeforeClass
    public void firstName(){
        System.out.println("My first name is Ahmad");
    }
    @AfterClass
    public void programName(){
        System.out.println("I study JAVA Programming Language");
    }
    @BeforeMethod
    public void lastName(){
        System.out.println("My last name is Qasim");
    }
    @AfterMethod
    public void cityState(){
        System.out.println("I live in Woodbridge VA");
    }

}
