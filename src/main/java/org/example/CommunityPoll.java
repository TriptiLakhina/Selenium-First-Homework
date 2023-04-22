package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommunityPoll {

    protected static WebDriver driver;

    public static void main(String[] args) {

        // Open Chrome browser
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        // Click on good button
        driver.findElement(By.id("pollanswers-2")).click();

        // Click on vote button
     //   driver.findElement(By.className("button-2 vote-poll-button")).click();
        driver.findElement(By.xpath("//button[@id=\"vote-poll-1\"]")).click();

       // String actualMessage=driver.findElement(By.xpath("//div[@id=\"block-poll-vote-error-1\"]")).getText();
        String actualMessage= String.valueOf(driver.findElement(By.xpath("//div[@class=\"poll-vote-error\"]")).getText());
        System.out.println("Error message is:" + actualMessage);


    }
}
