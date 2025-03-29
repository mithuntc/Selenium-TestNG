package rahulshettyacademy.tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		firstPage.loginApplication("mm@tt.com", "1234s567@As");
		Assert.assertEquals(" Incorrect email or password. ",firstPage.getErrorMessage());
      
	}

}