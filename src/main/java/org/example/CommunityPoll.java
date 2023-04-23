package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommunityPoll {

    protected static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        // Open Chrome browser
        driver=new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        // Click on good button
        driver.findElement(By.id("pollanswers-2")).click();

        // Click on vote button
     //   driver.findElement(By.className("button-2 vote-poll-button")).click();
        driver.findElement(By.xpath("//button[@id=\"vote-poll-1\"]")).click();

       // String actualMessage=driver.findElement(By.xpath("//div[@id=\"block-poll-vote-error-1\"]")).getText();
//        String actualMessage= String.valueOf(driver.findElement(By.xpath("//div[@class=\"poll-vote-error\"]")).getText());
//        System.out.println("Error message is:" + actualMessage);

 //       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  //      Thread.sleep(3000);

      //  Wait wait(ExpectedConditions.elementToBeClickable(By.id("block-poll-vote-error-1")))

      wait.until(ExpectedConditions.elementToBeClickable(By.id("block-poll-vote-error-1")));



        String actualMessage=driver.findElement(By.id("block-poll-vote-error-1")).getText();


        System.out.println("Error message is: " +actualMessage);
    }
}
