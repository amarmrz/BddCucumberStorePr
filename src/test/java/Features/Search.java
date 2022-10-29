package Features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {

	@Given("^I visit the website as a guest user$")
	public void i_visit_the_website_as_a_guest_user()  {
		System.out.println("hello");
	}

	@When("^I select the books option from the dropdown$")
	public void i_select_the_books_option_from_the_dropdown() {
		System.out.println("hello");
	}

	@When("^I select the Baby option from the dropdown$")
	public void i_select_the_baby_option_from_the_dropdown()  {
		System.out.println("hello");
	}

	@Then("^I should see the books page loaded$")
	public void i_should_see_the_books_page_loaded()  {
		System.out.println("hello");
	}

	@Then("^I should see the Baby page loaded$")
	public void i_should_see_the_baby_page_loaded()  {
		System.out.println("hello");
	}

	@And("^I click on Search icon$")
	public void i_click_on_search_icon() {
		System.out.println("hello");
	}

	@And("^I should see Books at Amazon as heading$")
	public void i_should_see_books_at_amazon_as_heading()  {
		System.out.println("hello");
	}

	@And("^I should see The baby store as heading$")
	public void i_should_see_the_baby_store_as_heading()  {
		System.out.println("hello");
	}

	@But("^I should not see other category products$")
	public void i_should_not_see_other_category_products() {
		System.out.println("hello");
	}

}
