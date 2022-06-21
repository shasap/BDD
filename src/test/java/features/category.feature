@category
Feature: category

  Scenario Outline: User should be able to navigate desired category page successfully from top menu header
    Given I am on homepage
    When I click "<category name>" link from top menu header
    Then I should be able to successfully able to navigate to "<category_url>" category page
    Examples:
      | category name     | category_url                                   |
      | Computers         | https://demo.nopcommerce.com/computers         |
      | Electronics       | https://demo.nopcommerce.com/electronics       |
      | Apparel           | https://demo.nopcommerce.com/apparel           |
      | Digital downloads | https://demo.nopcommerce.com/digital-downloads |
      | Books             | https://demo.nopcommerce.com/books             |
      | Jewelry           | https://demo.nopcommerce.com/jewelry           |
      | Gift Cards        | https://demo.nopcommerce.com/gift-cards        |

