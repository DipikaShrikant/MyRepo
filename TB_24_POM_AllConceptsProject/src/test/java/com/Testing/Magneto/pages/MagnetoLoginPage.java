package com.Testing.Magneto.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagnetoLoginPage {
	WebDriver driver;
	@FindBy(name = "firstname")
	WebElement fname;
	@FindBy(name = "lastname")
	WebElement lname;
	@FindBy(name = "email")
	WebElement emailid;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "password_confirmation")
	WebElement ConfirmPass;

	@FindBy(css = "button[class=\"action submit primary\"]")
	WebElement createAcBtn;
	@FindBy(css = "button[class=\"action switch\"]")
	WebElement triangle;
	@FindBy(css = "a[href=\"https://magento.softwaretestingboard.com/customer/account/logout/\"]")
	WebElement signOut;

	@FindBy(css = "a[href=\"https://magento.softwaretestingboard.com/customer/account/create/\"]")
	WebElement createNewAccount;

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	WebElement signin;
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement loginUser;
	@FindBy(xpath = "//*[@id=\"pass\"]")
	WebElement Loginpass;
	@FindBy(xpath = "//*[@id=\"send2\"]")
	WebElement loginBtn;

	public MagnetoLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createAccountWithMultipleUser(String fnm, String lnm, String userid, String pass) {
		fname.sendKeys(fnm);
		lname.sendKeys(lnm);
		emailid.sendKeys(userid);
		password.sendKeys(pass);
		ConfirmPass.sendKeys(pass);
		createAcBtn.click();
		triangle.click();
		signOut.click();
		createNewAccount.click();

	}

	public void createAccount(String fnm, String lnm, String userid, String pass) {
		fname.sendKeys(fnm);
		lname.sendKeys(lnm);
		emailid.sendKeys(userid);
		password.sendKeys(pass);
		ConfirmPass.sendKeys(pass);
		createAcBtn.click();
//		triangle.click();
//		signOut.click();

	}

	public void LoginToAccount(String userid, String pass) throws InterruptedException {
		triangle.click();
		signOut.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		signin.click();
		loginUser.sendKeys(userid);
		Loginpass.sendKeys(pass);
		loginBtn.click();

//		

	}

}
