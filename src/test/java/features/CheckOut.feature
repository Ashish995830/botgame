Feature: Checkout functionality of luma

  @Reg
  Scenario: Validate the checkout functionality
    When user click on the product
    And user select the size
    And user select the colour
    And user enter the qunatity "10"
    And user click on the Add to cart button
    And user click on the basket button
    And user click on proceed to checkout
    And user enter emailaddress "joh@domain.com"
    And user enter firstName "Rohit" and lastName "surdas"
    And user enter streetAddress "room no 14,colin street"
    And user enter city "ghazibad"
    And user select state
    And user enter zipcode "201016"
    And user select country
    And user enter PhoneNo "9958302155"
    And user select shipping method
    And user click Next button
    And user click on place order
    And validate the confirmation message
