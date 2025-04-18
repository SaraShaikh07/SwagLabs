
package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(css = ".cart_button")
	WebElement continueButton;

	@FindBy(css = ".cart_button")
	WebElement finishButton;

	@FindBy(className = "complete-header")
	WebElement successMsg;

	public void fillInfoAndContinue(String fName, String lName, String pCode) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(pCode);
		continueButton.click(); 

	}

	public void completePurchase() {
		continueButton.click(); 
	}

	public String getConfirmationMessage() {
		return successMsg.getText();
	}
}
