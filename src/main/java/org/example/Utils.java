package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Utils extends BasePage {

    // a.-----typeText or Send key method
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // b.----- clickOnElement method
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    // c.---- attribute
    public static void typeAttribute(By by, String text){
        driver.findElement(by).getAttribute(text);}
    // d. ----Random date and time stamp method
    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String format = formatter.format(date);
        return formatter.format(date);
    }

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    // e.-----implicit wait method
    public static void implicitWait(int second) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    // f.----- get text method
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // g. -----Sleep method
    public static void sleep (int time){
        try{
            Thread.sleep(1000*1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //i. -----explicit wait --
    // 1. to click element
    public static void driverWaitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    // 2. Element Selected
    public static void driverWaitElementToBeSelected(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    // 3. Url contains
    public static void driverWaitUrlContains(int time, By by, String urlName) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait1.until(ExpectedConditions.urlContains(urlName));
    }

    // 3.1. URL tobe
    public static void driverWaitsUntilContainsUrl(int time, String url) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait1.until(ExpectedConditions.urlToBe(url));
    }

    // 3.2. Url Fraction .urlContains (String fraction)
    public static void driverWaitsUrlFraction(int time, String UrlFraction) {
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait4.until(ExpectedConditions.urlContains(UrlFraction));
    }

    // 4. Attribute contains
    public static void driverWaitAttributeContains(By by, int time, String Attribute, String Value) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.attributeContains(by, Attribute, Value));
    }

    // 5. Title contains
    public static void driverWaitsTitleContains(int time, String text) {
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait3.until(ExpectedConditions.titleContains(text));
    }

    // 6. Title is
    public static void driverWaitsTitle(int time, By by, String title) {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait5.until(ExpectedConditions.titleIs(title));
    }

    // 7. Element Invisible
    public static void driverWaitsUntilElementInvisible(int time, By by, String url) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    // 8. Explicit wait -- to check element is visible
    public static void driverWaitsVisibilityOfElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // 9. Explicit wait -- to check element is found on web-page
    public static void driverWaitsPresenceOfElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(presenceOfElementLocated(By.id("")));
    }

    // 10. Alert is present
    public static void driverWaitsAlertIsPresent(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // 11. Checking WebElement with given locator has specific text
    public static void driverWaits(int time, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by, text));
    }

    // 12. Take a Screenshot Method....
    public static void takeSnapShot(String a){
        // Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        // Call getScreenshotsAs method to create image file

        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Copy file at destination

        try {
            FileUtils.copyFile(scrFile,new File("src\\test\\java\\Screenshots\\"+a+randomDate()+".png"));

        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
