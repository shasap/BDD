package org.example;

import org.openqa.selenium.By;

import org.testng.Assert;

public class ResultOfRegistration extends Utils{

    private By _actualMessage = By.className("result");
    private By _continue = By.cssSelector("[class=\"button-1 register-continue-button\"]");

    public void verifyRegistrationIsCompleted() {

        // Expected message from documents/requirements received
        String expectedMessage = "Your registration completed";

        // Actual message from Web page
        String actualMessage = driver.findElement(_actualMessage).getText();

        // Assert to verify actual message text
        Assert.assertEquals(actualMessage, expectedMessage, "Registration is not successful");

    }

    public void continueAsRegisteredUser(){

        // Continue as registered user..
        clickOnElement(_continue);

    }

}
