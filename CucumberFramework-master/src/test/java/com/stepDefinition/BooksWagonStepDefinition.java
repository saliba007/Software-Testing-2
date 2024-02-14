package com.stepDefinition;

import io.cucumber.java.en.And;
import org.testng.Assert;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.utilities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BooksWagonStepDefinition extends BaseTest {

	LoginPage loginPage = new LoginPage();

	HomePage homePage = new HomePage();





	@Given("^User is already on Books Wagon Page$")
	public void user_is_already_on_online_bookstore_website() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertTrue(title.contains("Online Bookstore"), "online bookstore website not loaded");
	}

	@And("^I click on the \"(.*)\" category$")
	public void clickCategoryName(String categoryName){
		homePage.validateCategoryClick(categoryName);
	}

	@Then("^I should be taken to \"(.*)\" category$")
	public void verifyCategoryPage(String categoryName){
		homePage.validateCategoryView(categoryName);
	}

	@And("^the category should show at least \"(.*)\" products$")
	public void verifyNumberOfProducts(String number){
		homePage.validateResultsNumber(number);
	}

	@When("^I click on the first product in the results$")
	public void clickFirstProduct() {
		homePage.clickFirstResult();
	}

	@Then("^I should be taken to the details page for that product$")
	public void verifyDetailsPageForProduct() {
		homePage.validateFirstProductResult();
	}

	@When("^I search for a product using the term \"(.*)\"$")
	public void verifyDetailsPageForProduct(String bookName) throws InterruptedException {
		homePage.searchBook(bookName);
	}


	@Then("^I should see the search results$")
	public void verifySearchResult() {
		String res = homePage.searchedResult("java");
		Assert.assertTrue(res.contains("java"), "searched result not showing up");

	}

	@Then("^there should be at least 5 products in the search results$")
	public void verifyFiveResults() {

		homePage.validateResultsNumber("5");

	}


	@Then("^close the browser$")
	public void close_browser() {
		driver.close();
	}

}
