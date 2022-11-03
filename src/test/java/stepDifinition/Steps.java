package stepDifinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	@Before
	public void setup() throws IOException {
		properties = new Properties();
		FileInputStream ip = new FileInputStream("config.properties");
		properties.load(ip);

		logger = Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		String br = properties.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("Firefox.Driver", properties.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		logger.info("..........Lunching Browser.....");
		driver.manage().window().maximize();
	}

	@Given("^User Launch Chrome browser$")
	public void user_launch_chrome_browser() {

		loginPage = new LoginPage(driver);

	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_url_something(String URL) {
		logger.info("..........Lunching Url.....");
		driver.get(URL);
	}

	@And("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_email_as_something_and_password_as_something(String email, String password) {
		logger.info("..........User entring Credeandial.....");
		loginPage.setUserName(email);
		loginPage.setPassword(password);

	}

	@And("^Click on Login$")
	public void click_on_login() throws InterruptedException {
		logger.info("..........User clicks on Login.....");
		loginPage.clickLogin();
		Thread.sleep(3000);

	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_title_should_be_something(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^User click on Log out link$")
	public void user_click_on_log_out_link() {
		loginPage.clickLogOut();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("^close browser$")
	public void close_browser() {
		driver.quit();
	}

	// Add new Customer stepdifinition ..........

	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		customersPage = new CustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", customersPage.getPageTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		customersPage.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(1000);
		customersPage.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		customersPage.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", customersPage.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomString() + "@gmail.com";
		customersPage.setEmail(email);
		customersPage.setPassword("test123");
		customersPage.setCustomerRoles("Guest");
		Thread.sleep(3000);
		customersPage.setManagerOfVendor("Vendor 2");
		customersPage.setGender("Male");
		customersPage.setFirstName("Pavan");
		customersPage.setLastName("Kumar");
		customersPage.setDob("7/05/1985"); // Format: D/MM/YYY
		customersPage.setCompanyName("busyQA");
		customersPage.setAdminContent("This is for testing .........");
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		customersPage.clickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));

	}

	// Steps for searching customeres using email id..............

	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		searchCustomerPage = new SearchCustomerPage(driver);
		searchCustomerPage.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCustomerPage.ClickSearch();
		Thread.sleep(3000);

	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status = searchCustomerPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	// Steps for searching customers by Fname and Lname

	@When("Enter cutomer FirstName")
	public void enter_cutomer_first_name() {
		searchCustomerPage = new SearchCustomerPage(driver);
		searchCustomerPage.setFirstName("Victoria");
	}

	@When("Enter cutomer LastName")
	public void enter_cutomer_last_name() {
		searchCustomerPage.setLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status = searchCustomerPage.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}

}
