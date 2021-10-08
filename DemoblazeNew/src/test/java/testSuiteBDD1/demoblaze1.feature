@demoblaze
Feature: Automation of DemoBlaze Website

@open_url 
Scenario: open the demoblaze site
Given user has opened browser
Then validate home page  

@signup_invalid_details 
Scenario: validate for invalid details
When click on sign up button
And enter invalid details
Then unsuccessful registration

@signup_valid_details
Scenario: validate for valid details
Given user is on signUp page
When enter valid details
Then successful registration

@invalid_login 
Scenario Outline: Login functionality for a Demoblaze site
When click on login button
And user enter invalid username as "<username>" and password as "<password>"
Then login should be unsuccessful
Examples:
 |username|password|
 |Groot|Groot@123|
 
@valid_login
Scenario Outline: Login functionality for a Demoblaze site
Given user is on the login page
When user enter valid username as "<username1>" and password as "<password1>"
Then login should be successful
Examples:
 |username1|password1|
 |Purple|Purple@123|
 
@contactUs 
Scenario: Valid contact us functionality for a Demoblaze site
When user clicks on contactUs btn, enter the required details & click on send message button
Then message should be successfully send

@categories 
Scenario: Verifying product categories
When user clicks on any given category
Then respective products are displayed

@display_details 
Scenario: Verifying product details
When user clicks on any product 
Then user is redirected to product details page & product details are displayed

@add_to_cart 
Scenario: validating add to cart button
Given user is on the product page
When clicks on add to cart button 
Then product is added to cart

@delete_product 
Scenario: validating delete product functionality
Given user is on the cart page
When user clicks on delete 
Then product is removed from the cart

@purchase_form 
Scenario: validating place order form
Given user is on the cart page
When clicks on place order button,enters required details & clicks on purchase button
Then confirmation details are displayed 
