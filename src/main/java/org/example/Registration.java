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

   // String actualMessage;
    static String expectedRegistrationCompleteMsg = "Thanks for registration";
    protected static WebDriver driver;


    @BeforeMethod
    public static void openBrowser(){
        // Open Chrome browser
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open url
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
        clickTheElement(By.className("ico-register"));

        // Type Firstname
        typeText(By.id("FirstName"),"TestFirstName");

        // Type Last name
        typeText(By.xpath("//input[@id=\"LastName\"]"),"TestLastName");

        // Type Email address
        typeText(By.xpath("//input[@id=\"Email\"]"),"TestEmail"+timestamp()+"@gmail.com");

        //Type password
        typeText(By.xpath("//input[@name=\"Password\"]"),"test1234");

        // Type confirm password
        typeText(By.id("ConfirmPassword"),"test1234");

        // Click on register button
        clickTheElement(By.name("register-button"));

        // get text from webelement
        String actualMessage= getTextFromElement(By.xpath("//div[@class=\"result\"]"));


    //    System.out.println("My message:" +actualMessage);
        Assert.assertEquals(actualMessage,expectedRegistrationCompleteMsg,"Registration is not working" );


    }

     public static void clickTheElement(By by){
        driver.findElement(by).click();

    }

    public static void typeText(By by, String text){

        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by){

        return driver.findElement(by).getText();
    }



    public static long timestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }



    public static void main(String[] args) {

    }
}
