package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProductComparison {
    protected static WebDriver driver;

    public static void main(String[] args) {

        // Open Chrome browser
        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        // Add HTC - product 1 to add to compare
        driver.findElement(By.xpath("(//button[@class=\"button-2 add-to-compare-list-button\"])[3]")).click();

        // Add gift card - product 2 to add to compare
  //      driver.findElement(By.xpath("(//button[@class=\"button-2 add-to-compare-list-button\"])[4]")).click();

        // link text for notification bar
  //     driver.findElement(By.linkText("product comparison")).click();



        // link text from footer
  //     driver.findElement(By.linkText("Compare products list")).click();

        //
  //      driver.findElement(By.xpath("(//a[@href=\"/compareproducts\"])[2]")).click();

        driver.findElement(By.xpath("(//a[@href=\"/compareproducts\"])[1]")).click();

//

        //xpath from footer when no notification tab is displayed
  //      driver.findElement(By.xpath("//a[@href=\"/compareproducts\"]")).click();


        // Xpath from footer when notification bar is displayed
 //       driver.findElement(By.xpath("(//a[@href=\"/compareproducts\"])[2]")).click();

        //Xpath from notification bar is displayed
  //      driver.findElement(By.xpath("(//a[@href=\"/compareproducts\"])[1]")).click();

        String item2 = driver.findElement(By.linkText("$25 Virtual Gift Card")).getText();
        System.out.println("Item 2 product name is:" + item2);

        String item1 = driver.findElement(By.xpath("(//a[@href=\"/htc-one-m8-android-l-50-lollipop\"])[2]")).getText();
        System.out.println("Item 1 product name is:" + item1);




    }

}
