package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.BaseTest;

import java.security.Key;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='oxd-main-menu-search']//input")
    WebElement searchBox;
    @FindBy(xpath = "//*[@id='ctl00_lihome']/a")
    WebElement booksListHover;


    @FindBy(xpath = "(//*[text()='%s'])[1]")
    WebElement categoryClick;
    @FindBy(xpath = "//p[text()='paul  Collings']")
    WebElement userDropdownname;

    @FindBy(xpath = "//*[@class='category-head']/h1")
    WebElement categoryLabel;

    @FindBy(xpath = "//*[@class='preferences-show']//b")
    WebElement numOfProducts;

    @FindBy(xpath = "//*[@class='preferences-show']//b")
    WebElement numOfProductsOnSearch;

    @FindBy(xpath = "(//*[@class='list-view-books']//a)[1]")
    WebElement firstProduct;

    @FindBy(xpath = "//*[@id='ctl00_phBody_ProductDetail_lblTitle']")
    WebElement firstProductResultPage;

    @FindBy(name = "btnTopSearch")
    WebElement searchBtn;


    @FindBy(xpath = "//*[@class='searchcomponent']/input")
    WebElement searchBookInput;

    @FindBy(xpath = "//*[@class='search-summary search-heading']/h1/span")
    WebElement searchResultText;


    public boolean validateCategoryClick(String category) {
        booksListHover.click();
        String cat = "(//*[text()='%s'])[1]";
        driver.findElement(By.xpath(String.format(cat, category))).click();
        return categoryLabel.getText().equalsIgnoreCase(category);
    }

    public boolean validateCategoryView(String category) {

        return categoryLabel.getText().equalsIgnoreCase(category);
    }

    public boolean validateResultsNumber(String numbers) {

        return numOfProducts.getText().equalsIgnoreCase(numbers);
    }

    public boolean clickFirstResult() {
        try {
            firstProduct.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateFirstProductResult() {
        return firstProductResultPage.isDisplayed();
    }

    public void searchBook(String bookName) throws InterruptedException {

        searchBookInput.sendKeys(bookName);
        Thread.sleep(3000);
        searchBtn.click();
    }



    public String searchedResult(String search) {
        return searchResultText.getText();
    }

    public void close() {
        driver.quit();
    }


}
