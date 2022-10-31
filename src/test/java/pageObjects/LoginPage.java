package pageObjects;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver Gdriver;

	public LoginPage(WebDriver driver) {

		Gdriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement btnLogOut;

	public void setUserName(String username) {
		txtEmail.clear();
		txtEmail.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogOut() {
		btnLogOut.click();
	}
}
