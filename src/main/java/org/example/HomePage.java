package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;


public class HomePage extends Utils {


    private By _registerButton =By.className("ico-register");
    private By _computerLink = By.xpath("//ul[1]/li/a[@href=\"/computers\"]");
    private By _findEuro  = By.id("customerCurrency");
    private By _priceInUSD = By.xpath("//span[.=\"$1,200.00\"]");
    private By _priceInEuro = By.xpath("//span[.='€1032.00']");
    private By _good = By.id("pollanswers-2");
    private By _vote = By.cssSelector("[id=\"vote-poll-1\"]");
    private By _actualVoteMessage = By.cssSelector("[class=\"poll-vote-error\"]");
    private By _registeredActualMessage = By.cssSelector("[class=\"poll-total-votes\"]");
    private By _featuredProductTitle = By.xpath("//div[contains(@class,'product-grid')]//div[@class='item-box']//h2");
    private By _facebookLink = By.cssSelector("[href=\"http://www.facebook.com/nopCommerce\"]");
    private By _search = By.cssSelector("[class=\"search-box-text ui-autocomplete-input\"]");
    private By _submit = By.cssSelector("[type=\"submit\"]");
    private By _newRelease = By.xpath("//a[@href=\"/nopcommerce-new-release\"and @class=\"read-more\"]");
    private By _computer = By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]");


    LoadProperty loadProperty = new LoadProperty();


    public void unregisteredUserCommunityPoll(){
        //In community poll section, click on good
        clickOnElement(_good);

        // click vote
        clickOnElement(_vote);

        // Wait for registration message to be visible
        driverWaitsVisibilityOfElement(_actualVoteMessage,2);

        // Expected message from requirement document
        String expectedMessage = "Only registered users can vote.";

        // Actual message

        String actualMessage = getTextFromElement(_actualVoteMessage);

        // Verify text
        Assert.assertEquals(actualMessage,expectedMessage,"You need to register to vote.");
    }

    public void registeredUserCommunityPoll(){

        //In community poll section, click on good
        clickOnElement(_good);

        // click vote
        clickOnElement(_vote);

        // Expected Message
        String expectedMessage = " vote(s)...";

        // Actual message

        String actualMessage = getTextFromElement(_registeredActualMessage).replaceAll("\\d","");

        // Verify text
       Assert.assertEquals(actualMessage,expectedMessage,"No result for vote.");


    }

    public void clickOnRegisterButton(){

        //Click on register button
        clickOnElement(_registerButton);

    }

    public void clickOnComputerLink(){
        //Click on computer
        clickOnElement(_computerLink);
    }

    public void productPriceInSelectedCurrency(){

        //User should be able to see product price in US dollar as US Dollar is selected currency

        //Expected price in USD for Build your own computer
        String expectedPriceInUSD = "$1,200.00";

        //Actual price in USD for Build your own computer
        String actualPriceInUSD = getTextFromElement(_priceInUSD);

        // Verify 'Build your own computer' - price in USD
        Assert.assertEquals(actualPriceInUSD,expectedPriceInUSD,"Product price is not in US Dollar");

        // Change currency to Euro or select currency as Euro
        Select euro = new Select(driver.findElement(_findEuro));
        euro.selectByVisibleText("Euro");

        // Expected price in Euro for - Build your own computer
        String expectedPriceInEuro = "€1032.00";

        // Actual price in Euro for Build your own computer
        String actualPriceInEuro = getTextFromElement(_priceInEuro);

        // Verify price in Euro for 'Build your own computer'
        Assert.assertEquals(actualPriceInEuro,expectedPriceInEuro,"Product price is not in Euro");

    }

    public void getProductTitles(){
        // get featured product Title
        List<WebElement> productTitles = driver.findElements(_featuredProductTitle);
        for (WebElement e: productTitles){
            System.out.println(e.getText());
        }

    }

    public void navigateFacebookLinkAndVerifyURL(){
        //click on facebook link
        clickOnElement(_facebookLink);
        // window handler command to direct that current window is main window
        String MainWindow=driver.getWindowHandle();

        // To handle all new opened window.
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                driverWaitsUntilContainsUrl(10,"https://www.facebook.com/nopCommerce");
                String actualURL = driver.getCurrentUrl();
                String expectedURL = "https://www.facebook.com/nopCommerce";
                Assert.assertEquals(actualURL,expectedURL,"Actual URL is not matching expected URL.");

                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);
    }

    public void searchAndVerifyProductsTitle(){
        // Type nike in search box to find nike product
        typeText(_search,loadProperty.getProperty("productName"));

        // Click Submit
        clickOnElement(_submit);



        }

    public void voteAlert(){

        // click on vote
        clickOnElement(By.cssSelector("[id=\"vote-poll-1\"]"));

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String actualAlertMessage= driver.switchTo().alert().getText();

        // Expected alert message.
        String expectedAlertMessage = "Please select an answer";

        // Verify Expected and Actual message
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage,"Select an answer message not displayed");

        // Accepting alert
        alert.accept();

    }

    public void ClickOnNewRelease(){
        clickOnElement(_newRelease);

    }


}



