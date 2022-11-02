package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersPage {

	public WebDriver Gdriver;

	public CustomersPage(WebDriver driver) {

		Gdriver = driver;
		PageFactory.initElements(driver, this);
	}

	By InkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By InkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddnew = By.xpath("//a[@class='btn btn-primary']"); // Add new
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtcustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

	By lstitemAdministrators = By.xpath("//li[contains(text(), 'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(), ' Registered' )]");
	By lstitemGuests = By.xpath("//li[contains(text(), 'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(), 'Vendors')]");

	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName = By.xpath("//input[@id='Company']");

	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");

	// Actions Methods
	public String getPageTitle() {
		return Gdriver.getTitle();
	}

	public void clickOnCustomersMenu() {
		Gdriver.findElement(InkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem() {
		Gdriver.findElement(InkCustomers_menuitem).click();
	}

	public void clickOnAddnew() {
		Gdriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email) {
		Gdriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		Gdriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException {
		if (!role.equals("Vendors")) // If role is vendors should not delete Register
		{
			Gdriver.findElement(By.xpath("//span[@title='delete']")).click();
		}
		Gdriver.findElement(txtcustomerRoles).click();
		WebElement listitem;
		Thread.sleep(3000);
		if (role.equals("Administrators")) {
			listitem = Gdriver.findElement(lstitemAdministrators);
		} else if (role.equals("Guests"))

		{
			listitem = Gdriver.findElement(lstitemGuests);
		} else if (role.equals("Registered")) {
			listitem = Gdriver.findElement(lstitemRegistered);
		} else if (role.equals("Vendors")) {
			listitem = Gdriver.findElement(lstitemVendors);
		} else {
			listitem = Gdriver.findElement(lstitemGuests);
		}
		// listitem.click();
		// Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) Gdriver;
		js.executeScript("arguments[0].click();", listitem);
	}

	public void setManagerOfVendor(String value) {
		Select drp = new Select(Gdriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			Gdriver.findElement(rdMaleGender).click();
		} else if (gender.equals("Female")) {
			Gdriver.findElement(rdFeMaleGender).click();
		} else {

			Gdriver.findElement(rdMaleGender).click();// Default
		}
	}

	public void setFirstName(String Fname) {

		Gdriver.findElement(txtFirstName).sendKeys(Fname);
	}

	public void setLastName(String Iname) {

		Gdriver.findElement(txtLastName).sendKeys(Iname);
	}

	public void setDob(String dob) {
		Gdriver.findElement(txtDob).sendKeys(dob);
	}

	public void setCompanyName(String comname) {

		Gdriver.findElement(txtCompanyName).sendKeys(comname);
	}

	public void setAdminContent(String content) {
		Gdriver.findElement(txtAdminContent).sendKeys(content);
	}

	public void clickOnSave() {

		Gdriver.findElement(btnSave).click();
	}

}
