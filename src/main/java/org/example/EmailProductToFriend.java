package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailProductToFriend extends Utils{

    private By _buildYourOwnComputer = By.xpath("//h2/a[@href=\"/build-your-own-computer\"]");
    private By _clickEmailAFriend = By.cssSelector("[class=\"button-2 email-a-friend-button\"]");
    private By _typeEmailAFriend = By.className("friend-email");
    private By _messageToFriend = By.id("PersonalMessage");
    private By _sendEmail = By.name("send-email");
    private By _actualEmailSentMessage = By.className("result");

    public void RegisteredUserShouldBeAbleToEmailProductToFriend(){


        // Click on Build your own computer text to select product
        clickOnElement(_buildYourOwnComputer);

        // Click on Email a friend button on selected product
        clickOnElement(_clickEmailAFriend);

        // Enter friends's Email address
        typeText(_typeEmailAFriend,"abc@xyz.com");

        // Enter personal message to friend
        typeText(_messageToFriend,"This is a good customized computer.");

        // Click on send Email
        clickOnElement(_sendEmail);

        // Expected message to verify email has been sent
        String expectedEmailSentMessage = "Your message has been sent.";

        // Actual message to verify email has been sent
        String actualEmailSentMessage = getTextFromElement(_actualEmailSentMessage);

        // Verify Actual & Expected text
        Assert.assertEquals(actualEmailSentMessage,expectedEmailSentMessage,"Your message has not been sent.");

    }

}
