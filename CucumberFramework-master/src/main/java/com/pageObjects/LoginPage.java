package com.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.BaseTest;

public class LoginPage extends BaseTest {

	public LoginPage() {
		BaseTest.initializeBrowser();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginBtn;
	@FindBy(xpath = "//div[@class='oxd-alert-content oxd-alert-content--error']//p")
	WebElement invalidInputErrorMsg;

	public String validateLoginPageTitle() {
		String loginTitle = driver.getTitle();
		return loginTitle;
	}
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return new HomePage();
	}
	public String validateInvalidErrorMsg() {
		return invalidInputErrorMsg.getText();
	}
}
