package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    HomePage homePage = new HomePage();
    Registration registration = new Registration();
    ResultOfRegistration resultOfRegistration = new ResultOfRegistration();

    @Given("I am on registration page")
    public void i_am_on_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnRegisterButton();


    }

    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        // Write code here that turns the phrase above into concrete actions
        registration.userShouldBeAbleToRegisterSuccessfully();


    }

    @When("I click on register submit button")
    public void i_click_on_register_submit_button() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("I should be able to register successfully")
    public void i_should_be_able_to_register_successfully() {
        // Write code here that turns the phrase above into concrete actions
        resultOfRegistration.verifyRegistrationIsCompleted();
    }


    @Given("I am on homepage")
    public void i_am_on_homepage() {
     homePage.verifyIAmOnHomePage();

    }

    @When("I click {string} link from top menu header")
    public void i_click_link_from_top_menu_header(String topHeaderLinkName) {
     homePage.clickOnTopHeaderLinkOnHomePage(topHeaderLinkName);

    }
    @Then("I should be able to successfully able to navigate to {string} category page")
    public void i_should_be_able_to_successfully_able_to_navigate_to_category_page(String categoryUrl) {
    homePage.verifyCategoryUrl(categoryUrl);
    }


}
