
package objectpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "product_sort_container")
	WebElement sortDropdown;

	@FindBy(className = "product_label")
	WebElement homePageTitle;

	@FindBy(xpath = "(//button[text()='ADD TO CART'])[1]")
	WebElement firstAddToCartButton;

	@FindBy(className = "inventory_item_name")
	List<WebElement> productNames;

	public String getHomePageTitle() {
		return homePageTitle.getText();
	}

	public void applyProductFilter(int index) {
		Select dropdown = new Select(sortDropdown);
		dropdown.selectByIndex(3);
	}

	public List<String> getProductNames() {
		List<String> names = new ArrayList<>();
		for (WebElement product : productNames) {
			names.add(product.getText());
		}
		return names;
	}

	public String addFirstProductToCart() {
		String name = productNames.get(0).getText();
		firstAddToCartButton.click();
		return name;
	}
}
