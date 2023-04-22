package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class Registration {

    protected static WebDriver driver;

    static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public static void main(String[] args) {

        // Open Chrome browser
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        // click on register button
        driver.findElement(By.className("ico-register")).click();

        // Type Firstname
        driver.findElement(By.id("FirstName")).sendKeys("TestFirstName");

        // Type Last name
        driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("TestLastName");

        // Type Email address
        driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("TestEmail"+timestamp.getTime()+"@gmail.com");

        //Type password
        driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys("test1234");

        // Type confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("test1234");

        // Click on register button
        driver.findElement(By.name("register-button")).click();

        // get text from webelement
        String actualMessage=driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();

        System.out.println("My message:" +actualMessage);

        // close the browser
        driver.close();

    }
}
