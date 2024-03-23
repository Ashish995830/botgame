package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.Base;

public class CheckoutPage extends Base {

	public void user_click_on_the_product() {

		WebElement productAdd = driver.findElement(By.cssSelector("[alt='Radiant Tee']"));
		clickOnElement(productAdd);
	}

	public void user_select_the_size() {

		WebElement productSize = driver.findElement(By.cssSelector("div#option-label-size-143-item-169"));
		clickOnElement(productSize);
		//hello

	}

	public void user_select_the_colour() {

		WebElement productColour = driver.findElement(By.cssSelector("div#option-label-color-93-item-56"));
		clickOnElement(productColour);

	}

	public void user_enter_the_qunatity(String u) {

		WebElement qty = driver.findElement(By.cssSelector("input#qty"));
		expcilitWait(10, qty, "visible");
		qty.sendKeys(u);
	}

	public void user_click_on_the_Add_to_cart_button() {

		WebElement addCart = driver.findElement(By.cssSelector("[title='Add to Cart']"));
		clickOnElement(addCart);
	}

	public void user_click_on_the_basket_button() {

		WebElement basketBtn = driver.findElement(By.cssSelector("span.counter-number"));

		expcilitWait(10, basketBtn, "clickable");

		executorClick(basketBtn);

	}

	public void user_click_on_proceed_to_checkout() {

		WebElement checkoutBtn = driver.findElement(By.cssSelector("button#top-cart-btn-checkout"));
		clickOnElement(checkoutBtn);

	}

	public void user_enter_email_address(String v) {

		WebElement email = driver.findElement(By.cssSelector("#customer-email-fieldset>div>div>input"));

		email.sendKeys(v);

	}

	public void user_enter_firstName_and_lastName(String m, String n) {

		WebElement firstName = driver.findElement(By.cssSelector("input#YURSC2H"));
		firstName.sendKeys(m);

		WebElement lastName = driver.findElement(By.cssSelector("input#TKMLT5X"));
		lastName.sendKeys(n);

	}

	public void user_enter_streetAddress(String o) {

		WebElement streetAdd = driver.findElement(By.cssSelector("input#YUOQ4CT"));
		streetAdd.sendKeys(o);

	}

	public void user_enter_city(String m) {

		WebElement city = driver.findElement(By.cssSelector("input#ISUSQO7"));
		city.sendKeys(m);

	}

	public void user_select_country() {

		WebElement country = driver.findElement(By.cssSelector("select#MRY6MH8"));

		selectDropDown(country, "IN", "value");

	}

	public void user_select_state() {

		WebElement state = driver.findElement(By.cssSelector("select#MI43DSL"));

		selectDropDown(state, "566", "value");
	}

	public void user_enter_zipcode(String n) {

		WebElement zipCode = driver.findElement(By.cssSelector("input#R4BEBDK"));
		zipCode.sendKeys(n);

	}

	public void user_enter_PhoneNo(String o) {

		WebElement phoneNo = driver.findElement(By.cssSelector("input#LHLNTPK"));
		phoneNo.sendKeys(o);

	}

	public void user_select_shipping_method() {

		WebElement shipMethod = driver.findElement(By.cssSelector("[type='radio']"));

		if (!shipMethod.isSelected()) {

			shipMethod.click();
		}
	}

	public void user_click_Next_button() {

		WebElement nextBtn = driver.findElement(By.cssSelector("button.button.action.continue.primary"));
		clickOnElement(nextBtn);

	}

	public void user_click_on_place_order() {

		WebElement placeOrder = driver.findElement(By.cssSelector("button.action.primary.checkout"));
		clickOnElement(placeOrder);

	}

	public void validate_the_confirmation_message() {

		WebElement thankYouHeading = driver.findElement(By.cssSelector("[data-ui-id='page-title-wrapper']"));
		validateText(thankYouHeading, "Thank you for your purchase!");

	}

}
