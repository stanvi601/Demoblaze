package testSuiteBDD1;

import base1.Base1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages1.Details1;
import pages1.Home1;
import pages1.Purchase1;

public class Stepdef1 
{
	Home1 h=new Home1();
	Details1 d=new Details1();
	Purchase1 p=new Purchase1();
	Base1 b=new Base1();
	

	@Given("^user has opened browser$")
	public void user_has_opened_browser() throws Throwable 
	{
		h.openURL();
	}

	@Then("^validate home page$")
	public void validate_home_page() throws Throwable 
	{
		h.validate_hmpg();
	}

	@When("^click on sign up button$")
	public void click_on_sign_up_button() throws Throwable
	{
		h.open_signup();
	}

	@And("^enter invalid details$")
	public void enter_invalid_details() throws Throwable
	{
		h.invalid_signup();
	}

	@Then("^unsuccessful registration$")
	public void unsuccessful_registration() throws Throwable 
	{
		h.signup_status();
	}
	
	@Given("^user is on signUp page$")
    public void user_is_on_signup_page() throws Throwable
	{
       h.navigate_signup();
    }

    @When("^enter valid details$")
    public void enter_valid_details() throws Throwable 
    {
        h.valid_Reg();
    }

    @Then("^successful registration$")
    public void successful_registration() throws Throwable
    {
        h.signup_status();
    }
    
    @When("^click on login button$")
    public void click_on_login_button() throws Throwable
    {
       h.open_login();
    }

    @And("^user enter invalid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_invalid_username_as_something_and_password_as_something(String username, String password) throws Throwable
    {
      h.invalid_login(username, password);
    }
    
    @Then("^login should be unsuccessful$")
    public void login_should_be_unsuccessful() throws Throwable
    {
       h.login_status();
    }

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() throws Throwable 
    {
       h.login_form();
    }

    @When("^user enter valid username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_valid_username_as_something_and_password_as_something(String username1, String password1) throws Throwable
    {
       h.valid_login(username1, password1);
    }

    @Then("^login should be successful$")
    public void login_should_be_successful() throws Throwable 
    {
       h.login_status();
    }
    
    @When("^user clicks on contactUs btn, enter the required details & click on send message button$")
    public void user_clicks_on_contactus_btn_enter_the_required_details_click_on_send_message_button() throws Throwable
    {
       h.contact_us();
    }

    @Then("^message should be successfully send$")
    public void message_should_be_successfully_send() throws Throwable
    {
       h.msg_status();
    }

    @When("^user clicks on any given category$")
    public void user_clicks_on_any_given_category() throws Throwable 
    {
      h.category();
    }

    @Then("^respective products are displayed$")
    public void respective_products_are_displayed() throws Throwable
    {
       h.read_products();
    }
   
    @When("^user clicks on any product$")
    public void user_clicks_on_any_product() throws Throwable 
    {
        d.prod_link();
    }

    @Then("^user is redirected to product details page & product details are displayed$")
    public void user_is_redirected_to_product_details_page_product_details_are_displayed() throws Throwable 
    {
      d.prod_details();
    }
    
    @Given("^user is on the product page$")
    public void user_is_on_the_product_page() throws Throwable 
    {
      d.validate_prdpg();
    }

    @When("^clicks on add to cart button$")
    public void clicks_on_add_to_cart_button() throws Throwable 
    {
       d.add_to_cartbtn();
    }

    @Then("^product is added to cart$")
    public void product_is_added_to_cart() throws Throwable 
    {
       d.cart_status();
    }

    @Given("^user is on the cart page$")
    public void user_is_on_the_cart_page() throws Throwable 
    {
       d.validate_cart();
    }

    @When("^user clicks on delete$")
    public void user_clicks_on_delete() throws Throwable 
    {
       d.delete_product();
    }

    @Then("^product is removed from the cart$")
    public void product_is_removed_from_the_cart() throws Throwable 
    {
     d.del_cart_status();
    }

    @When("^clicks on place order button,enters required details & clicks on purchase button$")
    public void clicks_on_place_order_buttonenters_required_details_clicks_on_purchase_button() throws Throwable 
    {
    	Thread.sleep(2000);
    	p.place_order();
    }

    @Then("^confirmation details are displayed$")
    public void confirmation_details_are_displayed() throws Throwable
    {
    	p.purchase_confirm();
    }
}
