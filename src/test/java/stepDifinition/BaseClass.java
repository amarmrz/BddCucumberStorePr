package stepDifinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public CustomersPage customersPage;
	public SearchCustomerPage searchCustomerPage;

	// generating random emails....
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);

		return generatedString;

	}
}
