package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{

    HomePage homePage = new HomePage();
    Registration registration = new Registration();
    ResultOfRegistration resultOfRegistration= new ResultOfRegistration();
    EmailProductToFriend emailProductToFriend = new EmailProductToFriend();
    ProductInComputer productInComputer = new ProductInComputer();
    AddToCartInDesktop addToCartInDesktop = new AddToCartInDesktop();
    AddToCart addToCart = new AddToCart();

    @Test (priority = -1)
    public void newUserRegistration(){
        // On homepage, user click register button
     homePage.clickOnRegisterButton();

     // User fill registration form on registration page
     registration.userShouldBeAbleToRegisterSuccessfully();

     // User verify registration completed successfully on new URL
     resultOfRegistration.verifyRegistrationIsCompleted();

    }

    @Test (priority = 0)
    public void referProductToFriend(){

        //On Homepage, user click register button
        homePage.clickOnRegisterButton();

        // User fill registration form on registration page
        registration.userShouldBeAbleToRegisterSuccessfully();

        // User verify registration completed successfully on new URL
        resultOfRegistration.verifyRegistrationIsCompleted();

        // As registered user, user click continue to do next action
        resultOfRegistration.continueAsRegisteredUser();

        // registered user able to refer product to friend via Email.
        emailProductToFriend.RegisteredUserShouldBeAbleToEmailProductToFriend();

    }

    @Test (priority = 1)
    public void SelectCustomisedAndAddToCart(){
        // User click on computer
        homePage.clickOnComputerLink();

        // User select desktop from computer category
        productInComputer.SelectDesktop();

        // User click 'Add to cart' for desktop
        addToCartInDesktop.SelectAndAddToCart();

        // User customise desktop and confirm 'Add to cart'
        addToCart.SelectCustomisedAndAddProductToCart();
    }

    @Test (priority = 2)
    public void UserAbleToSeePriceInSelectedCurrency(){

        //User change currency and see price accordingly in selected currency
        homePage.productPriceInSelectedCurrency();
    }

    @Test (priority = 3)
    public void poll(){
        //Unregistered user try to vote
        homePage.unregisteredUserCommunityPoll();

        // User click on register
        homePage.clickOnRegisterButton();

        // User fills registration form
        registration.userShouldBeAbleToRegisterSuccessfully();

        //User verify registration is completed
        resultOfRegistration.verifyRegistrationIsCompleted();

        // User continue as registered user
        resultOfRegistration.continueAsRegisteredUser();

        //Registered user votes
        homePage.registeredUserCommunityPoll();
    }


}
