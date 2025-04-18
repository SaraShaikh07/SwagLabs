package objectpages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login-button")
	WebElement loginButton;

	public void login(String user, String pass) {
		usernameField.sendKeys(user);
		passwordField.sendKeys(pass);
		loginButton.click();
	}

	public String getErrorMessage() {
		WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
		return errorElement.getText();
	}
}
