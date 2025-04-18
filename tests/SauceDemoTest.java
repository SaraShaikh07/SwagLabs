
package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.ReportBaseTest;
import objectpages.LoginPage;
import objectpages.HomePage;
import objectpages.CartPage;
import objectpages.CheckoutPage;

import java.util.List;

public class SauceDemoTest extends ReportBaseTest {

	ExtentTest test;

	@Test(dataProvider = "loginData")
	public void verifySauceDemoFlow(String username, String password) {

		test = extent.createTest("verifySauceDemoFlow - User: " + username);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		if (username.equals("locked_out_user")) {
			String errorMessage = loginPage.getErrorMessage();
			Assert.assertTrue(errorMessage.contains("Sorry, this user has been locked out"));
			test.fail("Login failed as expected for locked-out user");
			return;
		}

		HomePage homePage = new HomePage(driver);
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, "Products", "Homepage title mismatch.");
		test.pass("User successfully landed on Home Page.");

		HomePage homePage1 = new HomePage(driver);
		homePage1.applyProductFilter(3);

		List<String> productNames = homePage1.getProductNames();
		System.out.println("Products sorted by price (Low to High):");
		for (String name : productNames) {
			System.out.println(name);
		}

		String selectedProductName = homePage1.addFirstProductToCart();

		CartPage cartPage = new CartPage(driver);
		cartPage.goToCart();
		String cartItemName = cartPage.getCartItemName();
		Assert.assertEquals(cartItemName, selectedProductName, "Product not added to cart correctly.");

		cartPage.proceedToCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.fillInfoAndContinue("Sam", "Smith", "12345");
		checkoutPage.completePurchase();

		String confirmationMsg = checkoutPage.getConfirmationMessage();
		Assert.assertEquals(confirmationMsg, "THANK YOU FOR YOUR ORDER", "Order was not completed successfully.");
	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, 
			                    { "locked_out_user", "secret_sauce" },
				                { "problem_user", "secret_sauce" }, 
				                { "performance_glitch_user", "secret_sauce" } };
	}
}
