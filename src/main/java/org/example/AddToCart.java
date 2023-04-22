package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddToCart {

    protected static WebDriver driver;

    public static void main(String[] args) {
        // Open Chrome browser
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        // Click on add to cart
        driver.findElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]")).click();

        // click on email to friend
        driver.findElement(By.xpath("//div[@class=\"email-a-friend\"]")).click();

        // Type friends email
        driver.findElement(By.id("FriendEmail")).sendKeys("FriendTest@gmail.com");

        // Type your email
        driver.findElement(By.id("YourEmailAddress")).sendKeys("Test@gmail.com");

        // Type Personal message
        driver.findElement(By.id("PersonalMessage")).sendKeys("This product is really good, try it out");

        // Click on send email button
        driver.findElement(By.name("send-email")).click();

//        String actualMessage=driver.findElement(By.className("message-error validation-summary-errors")).getText();
//        System.out.println("Error message is:"+ actualMessage);

//        String actualMessage = String.valueOf(driver.findElement(By.xpath("//div[@class= \"message-error validation-summary-errors\"]")).getText());
//        System.out.println("Message is: " + actualMessage);

        String actualMessage = driver.findElement(By.xpath("//div[@class= \"message-error validation-summary-errors\"]")).getText();
        System.out.println("Message is: " + actualMessage);

        driver.close();
    }
}
