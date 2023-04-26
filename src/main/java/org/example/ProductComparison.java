package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductComparison {
    protected static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // Open Chrome browser
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        // Add HTC - product 1 to add to compare
        driver.findElement(By.xpath("(//button[@class=\"button-2 add-to-compare-list-button\"])[3]")).click();

  //      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class=\"button-2 add-to-compare-list-button\"])[4]")));

        // link text for notification bar
  //     driver.findElement(By.linkText("product comparison")).click();


        // link text from footer
  //     driver.findElement(By.linkText("Compare products list")).click();


        //xpath from footer when no notification tab is displayed
  //     driver.findElement(By.xpath("//a[@href=\"/compareproducts\"]")).click();

  //      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href=\"/compareproducts\"])[2]")));

        // Xpath from footer when notification bar is displayed
  //      driver.findElement(By.xpath("(//a[@href=\"/compareproducts\"])[2]")).click();

 //       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href=\"/compareproducts\"])[1]")));

        //Xpath from notification bar when it is displayed
       driver.findElement(By.xpath("(//a[@href=\"/compareproducts\"])[1]")).click();


        String item1 = driver.findElement(By.xpath("(//a[@href=\"/htc-one-m8-android-l-50-lollipop\"])[2]")).getText();
        System.out.println("Item 1 product name is: " + item1);

        driver.get("https://demo.nopcommerce.com/");

      //  Thread.sleep(3000);

        // Add gift card - product 2 to add to compare
        driver.findElement(By.xpath("(//button[@class=\"button-2 add-to-compare-list-button\"])[4]")).click();

        driver.findElement(By.xpath("(//a[@href=\"/compareproducts\"])[1]")).click();

        String item2 = driver.findElement(By.xpath("(//a[@href=\"/25-virtual-gift-card\"])[2]")).getText();
        System.out.println("Item 2 product name is: " + item2);

        // Click on clear list
        driver.findElement(By.className("clear-list")).click();


        // Print error message
        String noItemsToCompare = driver.findElement(By.className("no-data")).getText();
        System.out.println("Message displayed to user on clearing the compare list: " + noItemsToCompare);


 //       driver.close();



    }

}
