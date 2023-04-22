package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShoppingCart {
    protected static WebDriver driver;

    public static void main(String[] args) {

        // Open Chrome browser
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open https://demo.nopcommerce.com/ url
        driver.get("https://demo.nopcommerce.com/");

        // Click on Electronics menu
        driver.findElement(By.xpath("(//a[@href=\"/electronics\"])[1] ")).click();

        // Click on Camera & photo
        driver.findElement(By.xpath("(//a[@href=\"/camera-photo\"])[4]")).click();

        //Capture the name before adding to cart
        String beforeAdding=driver.findElement(By.xpath("(//a[@href=\"/leica-t-mirrorless-digital-camera\"])[2]")).getText();
        System.out.println("Product name before adding to shopping cart: " + beforeAdding);

        // Add product to cart
        driver.findElement(By.xpath("(//button[@class=\"button-2 product-box-add-to-cart-button\"])[2]")).click();

        // Click on shopping cart
      //  driver.findElement(By.id("flyout-cart")).click();
        driver.findElement(By.xpath("(//a[@href=\"/cart\"])[1]")).click();

        // Capture the name after adding to cart
        String afterAdding=driver.findElement(By.xpath("(//a[@href=\"/leica-t-mirrorless-digital-camera\"])[4]")).getText();
        System.out.println("Product name after adding to shopping cart: "+afterAdding);

        driver.close();
    }
}
