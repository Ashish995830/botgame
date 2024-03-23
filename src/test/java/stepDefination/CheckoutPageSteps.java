package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import page.CheckoutPage;

public class CheckoutPageSteps {

	CheckoutPage check = new CheckoutPage();

	@When("user click on the product")
	public void user_click_on_the_product() {

		check.user_click_on_the_product();

	}

	@And("user select the size")
	public void user_select_the_size() {

		check.user_select_the_size();

	}

	@And("user select the colour")
	public void user_select_the_colour() {

		check.user_select_the_colour();
	}

	@And("user enter the qunatity {string}")
	public void user_enter_the_qunatity(String x) {

		check.user_enter_the_qunatity(x);
	}

	@And("user click on the Add to cart button")
	public void user_click_on_the_Add_to_cart_button() {

		check.user_click_on_the_Add_to_cart_button();

	}

	@And("user click on the basket button")
	public void user_click_on_the_basket_button() {

		check.user_click_on_the_basket_button();

	}

	@And("user click on proceed to checkout")
	public void user_click_on_proceed_to_checkout() {

		check.user_click_on_proceed_to_checkout();
	}

	@And("user enter emailaddress {string}")
	public void user_enter_email_address(String y) {

		check.user_enter_email_address(y);
	}

	@And("user enter firstName {string} and lastName {string}")
	public void user_enter_firstName_and_lastName(String a, String b) {

		check.user_enter_firstName_and_lastName(a, b);
	}

	@And("user enter streetAddress {string}")
	public void user_enter_streetAddress(String c) {

		check.user_enter_streetAddress(c);
	}

	@And("user enter city {string}")
	public void user_enter_city(String d) {

		check.user_enter_city(d);

	}

	@And("user select state")
	public void user_select_state() {

		check.user_select_state();
	}

	@And("user enter zipcode {string}")
	public void user_enter_zipcode(String e) {

		check.user_enter_zipcode(e);
	}

	@And("user select country")
	public void user_select_country() {

		check.user_select_country();
	}

	@And("user enter PhoneNo {string}")
	public void user_enter_PhoneNo(String g) {

		check.user_enter_PhoneNo(g);
	}

	@And("user select shipping method")
	public void user_select_shipping_method() {

		check.user_select_shipping_method();
	}

	@And("user click Next button")
	public void user_click_Next_button() {

		check.user_click_Next_button();
	}

	@And("user click on place order")
	public void user_click_on_place_order() {

		check.user_click_on_place_order();
	}

	@And("validate the confirmation message")
	public void validate_the_confirmation_message() {

		check.validate_the_confirmation_message();
	}

}
