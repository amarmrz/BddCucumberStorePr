package stepDifinition;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public CustomersPage customersPage;
	public SearchCustomerPage searchCustomerPage;
	public Properties properties;
	public static Logger logger;

	// generating random emails....
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);

		return generatedString;

	}
}
