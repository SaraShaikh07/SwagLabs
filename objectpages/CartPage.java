
package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public CartPage(WebDriver driver) {
        
        PageFactory.initElements(driver, this);
    }
	
	
   
    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    @FindBy(className = "inventory_item_name")
    private WebElement cartItemName;

    @FindBy(css = ".checkout_button")
    private WebElement checkoutButton;

    

    public void goToCart() {
        cartButton.click();
    }

    public String getCartItemName() {
        return cartItemName.getText();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}
