package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


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

}
