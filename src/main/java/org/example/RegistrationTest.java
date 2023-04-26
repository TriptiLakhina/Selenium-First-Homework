package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {

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
            public static void verifyUserShouldBeAbleToRegister() throws InterruptedException {


        // click on register button
        //  driver.findElement(By.className("ico-register")).click();
        clickTheElement(By.className("ico-register"));

        // Type Firstname
        //  driver.findElement(By.id("FirstName")).sendKeys("TestFirstName");
        typeText(By.id("FirstName"), "TestFirstName");

        // Type Last name
        //  driver.findElement(By.xpath("//input[@id=\"LastName\"]")).sendKeys("TestLastName");
        typeText(By.xpath("//input[@id=\"LastName\"]"), "TestLastName");

        // Type Email address
        //  driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("TestEmail"+timestamp.getTime()+"@gmail.com");
        typeText(By.xpath("//input[@id=\"Email\"]"), "TestEmail" + timestamp() + "@gmail.com");

        //Type password
        //  driver.findElement(By.xpath("//input[@name=\"Password\"]")).sendKeys("test1234");
        typeText(By.xpath("//input[@name=\"Password\"]"), "test1234");

        // Type confirm password
        //   driver.findElement(By.id("ConfirmPassword")).sendKeys("test1234");
        typeText(By.id("ConfirmPassword"), "test1234");

        // Click on register button
        //   driver.findElement(By.name("register-button")).click();
        clickTheElement(By.name("register-button"));

        // get text from webelement
        //   String actualMessage=driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        String actualMessage = getTextFromElement(By.xpath("//div[@class=\"result\"]"));


        //   System.out.println("My message:" +actualMessage);
        Assert.assertEquals(actualMessage, expectedRegistrationCompleteMsg, "Registration is not working");

    }
        @Test
        public static void verifyUserShouldBeAbleToCompareTwoProducts1(){

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            String expectedNoItemsIoCompareMessage = "No items in the list to compare";

            // Click on add to compare for Product 1 - HTC One M8 Android L 5.0 Lollipop
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/button[2]")));

            clickTheElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/button[2]"));

            // Wait until green bar disappears
//wait  - By.class("bar-notification success")

            //      Thread.sleep(3000);
            // Close the Green notification
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"bar-notification success\"]/span")));
            clickTheElement(By.xpath("//div[@class=\"bar-notification success\"]/span"));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/button[2]")));
            //       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("\"//div[@class=\\\"product-grid home-page-product-grid\\\"]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/button[2]\"")));
            //      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/button[2]")));
            // Click on add to compare for product 2 - $25 Virtual Gift Card
            //      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/button[2]")));
            //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/button[2]")));
            //      clickTheElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/button[2]"));

            // Click on Add to cart button for product 2 - $25 Virtual Gift Card
            clickTheElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]/div[2]/div[4]/div[1]/div[2]/div[3]/div[2]/button[1]"));
            // Click on Add to compare list button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]")));
            //      clickTheElement(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]"));
            clickTheElement(By.xpath("//div[@class=\"overview-buttons\"]/div[2]/button"));

            //        Thread.sleep(3000);
            // Click on Green notification bar
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"bar-notification success\"]/p/a")));
            clickTheElement(By.xpath("//div[@class=\"bar-notification success\"]/p/a"));

            //       Thread.sleep(3000);
            // Capture the name of product 1
            String productName1 = getTextFromElement(By.xpath("//table[@class=\"compare-products-table\"]/tbody/tr[3]/td[2]/a"));
            System.out.println("Product 1 name in comparison list is: " +productName1);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class=\"compare-products-table\"]/tbody/tr[3]/td[3]/a")));
            //      Thread.sleep(3000);
            // Capture the name of product 2
            String productName2 = getTextFromElement(By.xpath("//table[@class=\"compare-products-table\"]/tbody/tr[3]/td[3]/a"));
            System.out.println("Product 2 name in comparison list is: " +productName2);

            // Click on clear list
            //  Thread.sleep(3000);
            clickTheElement(By.xpath("//div[@class=\"page-body\"]/a"));

            // Capture the message when no products in product comparison
            String noItemsToCompare = getTextFromElement(By.className("no-data"));
            System.out.print("\nEmpty comparison list display message: ");

            // Verify the display message for empty product comparison
            Assert.assertEquals(noItemsToCompare,expectedNoItemsIoCompareMessage,"Wrong blank comparison display message");


        }

    @Test
    public static void verifyRegisteredUserShouldBeAbleToVoteSuccessfully() //throws InterruptedException
    {
        String expectedTotalVoteCountMessage = "Votes";
        String expectedGoodVoteMessage = "Good (2 votes - 20.7%)";
        //Implying Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        //Click on register button
        clickTheElement(By.className("ico-register"));

        // Type first name
        typeText(By.id("FirstName"),"TestFirstName");

        // Type last name
        typeText(By.xpath("//input[@id=\"LastName\"]"),"TestLastName");

        // Type email
        typeText(By.xpath("//input[@id=\"Email\"]"),"TestEmail5@gmail.com");

        // Type password
        typeText(By.xpath("//input[@name=\"Password\"]"),"test@5");

        // Type confirm password
        typeText(By.id("ConfirmPassword"),"test@5");

        // Click on register button
        clickTheElement(By.name("register-button"));

        // click on login link
        clickTheElement(By.xpath("//a[@href=\"/login?returnUrl=%2F\"]"));

        // Type Email in returning customer
        typeText(By.id("Email"),"TestEmail5@gmail.com");

        // Type password
        typeText(By.id("Password"),"test@5");

        // Click on log in button
        clickTheElement(By.xpath("//button[@class=\"button-1 login-button\"]"));


      //  Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("pollanswers-2")));
        // Click on Good radio button
        clickTheElement(By.id("pollanswers-2"));
        //  clickTheElement(By.id("pollanswers-2"));
        // Click on Vote button
        clickTheElement(By.xpath("//button[@id=\"vote-poll-1\"]"));

        Thread.sleep(3000);
        //  String actualVoteExcellentMessage = getTextFromElement(By.xpath("//ul[@class=\"poll-results\"]/li[1]"));
        String actualVoteGoodMessage = getTextFromElement(By.xpath("//ul[@class=\"poll-results\"]/li[2]"));
//        String actualVotePoorMessage = getTextFromElement(By.xpath("//ul[@class=\"poll-results\"]/li[3]"));
//        String actualVoteVeryBadMessage = getTextFromElement(By.xpath("//ul[@class=\"poll-results\"]/li[4]"));
//        String actualCountMessage = getTextFromElement(By.className("poll-total-votes"));
        //   System.out.println("Actual message for Excellent Vote: "+actualVoteExcellentMessage);
        System.out.println("Actual message for Good Vote: "+actualVoteGoodMessage);
//        System.out.println("Actual message for Poor Vote: "+actualVotePoorMessage);
//        System.out.println("Actual message for Very bad Vote: "+actualVoteVeryBadMessage);
//        System.out.println("Total no of votes: "+actualCountMessage);
//        Assert.assertEquals(actualCountMessage,expectedTotalVoteCountMessage,"Community poll is not giving the correct count for registered users vote");
        Assert.assertEquals(actualVoteGoodMessage,expectedGoodVoteMessage,"wrong");



//        // Explicit wait to capture the disappearing text
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("block-poll-vote-error-1")));
//        // Get Error message Text
//        String actualMessageForCommunityPoll = getTextFromElement(By.id("block-poll-vote-error-1"));
//        //      System.out.println(actualMessageForCommunityPoll);
//        // Assert to verify if the actual message is same as expected message
//        Assert.assertEquals(actualMessageForCommunityPoll,expectedMsg_CommunityPoll,"Community poll is not working");
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
