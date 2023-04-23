package org.example;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class Registration {

    String actualMessage;
    static String expectedRegistrationCompleteMsg = "Thanks for registration";


    @BeforeMethod
    public static void openBrowser(){
        // Open Chrome browser
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void closeBrowser(){
        // close the browser
        driver.close();

    }

    @Test
            public static void verifyUserShouldBeAbleToRegister(){


        // click on register button
        //  driver.findElement(By.className("ico-register")).click();
        clickTheElement(By.className("ico-register"));

        // Type Firstname
        //  driver.findElement(By.id("FirstName")).sendKeys("TestFirstName");
        typeText(By.id("FirstName"),"TestFirstName");

        // Type Last name
        //  driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("TestLastName");
        typeText(By.xpath("//input[@id=\"LastName\"]"),"TestLastName");

        // Type Email address
        //  driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("TestEmail"+timestamp.getTime()+"@gmail.com");
        typeText(By.xpath("//input[@id=\"Email\"]"),"TestEmail"+timestamp()+"@gmail.com");

        //Type password
        //  driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys("test1234");
        typeText(By.xpath("//input[@name=\"Password\"]"),"test1234");

        // Type confirm password
        //   driver.findElement(By.id("ConfirmPassword")).sendKeys("test1234");
        typeText(By.id("ConfirmPassword"),"test1234");

        // Click on register button
        //   driver.findElement(By.name("register-button")).click();
        clickTheElement(By.name("register-button"));

        // get text from webelement
        //   String actualMessage=driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        String actualMessage= getTextFromElement(By.xpath("//div[@class=\"result\"]"));


    //    System.out.println("My message:" +actualMessage);
        Assert.assertEquals(actualMessage,expectedRegistrationCompleteMsg,"Registration is not working" );


    }






    protected static WebDriver driver;

 //   static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public static void clickTheElement(By by){
        driver.findElement(by).click();

    }

    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }


//    public static String Timesstamp

    public static long timestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }



    public static void main(String[] args) {



    }
}
