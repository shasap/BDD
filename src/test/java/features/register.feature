@register
Feature: Registration and click the category links

  Scenario: As a user, I should able to register successfully
    So that, I can use all the user features on demonopcommerce website

    Given I am on registration page
    When I enter required registration details
    And I click on register submit button
    Then I should be able to register successfully





