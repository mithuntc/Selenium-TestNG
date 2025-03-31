package midhun.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import midhun.TestComponents.BaseTest;
import midhun.pageobjects.CartPage;
import midhun.pageobjects.CheckoutPage;
import midhun.pageobjects.LandingPage;
import midhun.pageobjects.ProductCatalogue;

public class StepDefinitionImplementation extends BaseTest{
	public LandingPage landingPage; 
	public ProductCatalogue secondPage;
	public CartPage cart;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		
		landingPage = launchApplication();
	}
	
	@Given("^Logged in  wit the username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) {
		System.out.println(username);
		System.out.println(username);
		secondPage = landingPage.loginApplication(username, password);
		
	}
	@When("^I add the product (.+) from cart$")
	public void I_add_the_product_from_cart(String productName) throws InterruptedException {
		List<WebElement> items = secondPage.getProductList();
		secondPage.getProductByName(productName);
		secondPage.addProductToCart(productName);
		
	}
	@And("^And  Checkout (.+) and Submit the order$")
	public void and_Checkout_and_Submit_the_order(String productName) {
		secondPage.goToCartPage();
		// on cart page
		cart = secondPage.goToCartPage();
		Boolean match = cart.VerifyProductDisplay(productName);
		System.out.println(match);
		CheckoutPage checkout = cart.goToCheckout();
		// checkout section and placing an order
		checkout.selectCountry("india");
		checkout.submitOrder();
	}
	
	@Then("{string}message displayed on ConfirmationPage")
	public void message_displayed_on_ConfirmationPage(String string) {
		System.out.println(string);
	}	
}
