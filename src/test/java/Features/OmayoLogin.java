package Features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OmayoLogin {
	WebDriver driver = null;

	@Given("^I visite to application website$")
	public void I_visite_to_application_website() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
	}

	@When("^I enter Username as \"([^\"]*)\" and Pasword as \"([^\"]*)\" into the fields$")
	public void I_enter_Username_as_someusernames_and_Pasword_as_somepasswords_into_the_fields(String username,
			String password) {
		driver.findElement(By.name("userid")).sendKeys(username);
		driver.findElement(By.name("pswrd")).sendKeys(password);
	}

	@And("^I click on login button$")
	public void I_click_on_login_button() {
		driver.findElement(By.cssSelector("input[value='Login']")).click();

	}

	@Then("^User should be able to login based on \"([^\"]*)\" login status$")
	public void User_should_be_able_to_login_based_on_expected_login_status(String expetedResult) {

		String actualResult;
		try {
			Alert alert = driver.switchTo().alert();
			actualResult = null;
			if (alert.getText().contains("Error Password")) {
				actualResult = "failure";

			}
		} catch (Exception e) {
			actualResult = "success";
		}
		Assert.assertEquals(expetedResult, actualResult);
		driver.quit();
	}

}
