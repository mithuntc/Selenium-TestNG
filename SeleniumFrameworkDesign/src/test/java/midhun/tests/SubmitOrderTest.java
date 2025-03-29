package midhun.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import midhun.TestComponents.BaseTest;
import midhun.pageobjects.CartPage;
import midhun.pageobjects.CheckoutPage;
import midhun.pageobjects.OrderPage;
import midhun.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	@Test(groups= {"erroHandling"})
	public void submitOrderValidationTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		firstPage.loginApplication("mm@tt.com", "1234s567@As");
		Assert.assertEquals(" Incorrect email or password. ", firstPage.getErrorMessage());

	}
	@Test(dataProvider="getData" , groups="{Purchase}")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ProductCatalogue secondPage = firstPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> items = secondPage.getProductList();
		secondPage.getProductByName(input.get("productName"));
		secondPage.addProductToCart(input.get("productName"));
		// clicking cart icon
		secondPage.goToCartPage();
		// on cart page
		CartPage cart = secondPage.goToCartPage();
		Boolean match = cart.VerifyProductDisplay(input.get("productName"));
		System.out.println(match);
		CheckoutPage checkout = cart.goToCheckout();
		// checkout section and placing an order
		checkout.selectCountry("india");
		checkout.submitOrder();

	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue secondPage = firstPage.loginApplication("mm@mm.com", "1234567@As");	
		OrderPage order = secondPage.goToOrdersPage();
		Assert.assertTrue(order.VerifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{		
		List<HashMap<String,String>> maindata = getJsonData(System.getProperty("user.dir") +"\\src\\test\\java\\midhun\\data\\PurchaseOrder.json");
		return new Object[][] {{maindata.get(0)},{maindata.get(1)}};
	}

}
