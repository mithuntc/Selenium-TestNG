
@tag
Feature: Purchase the order from a e-commerce website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page
  
  @tag2
  Scenario Outline: Positive test of submiting an order
    Given Logged in  wit the Username <username> and password <password>
    When I add the product <productName> from cart
    And  Checkout <productName> and Submit the order
    Then "THANKYOU FOR THE ORDER." message displayed on ConfirmationPage
 
    Examples: 
      | username      | password         | productName         |
      | mm@mm.com     | 1234567@As       | ZARA COAT 3         |
