package com.Testing.DemoWebShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registerpage {
	
	WebDriver driver;
	
	@FindBy(id = "gender-female")
	WebElement gender;
	@FindBy(name = "FirstName")
	WebElement fname;
	@FindBy(name = "LastName")
	WebElement lname ;
	@FindBy(name="Email")
	WebElement email ;
	@FindBy(name = "Password")
	WebElement pass ;
	@FindBy(name = "ConfirmPassword")
	WebElement Cpass;
	@FindBy(name = "register-button")
	WebElement registerBtn;
	
	@FindBy(css = "a[href=\"/logout\"]")
	WebElement lgOut;
	
	@FindBy(css = "a[href=\"/login\"]")
	WebElement login;
	
	@FindBy(name = "RememberMe")
	WebElement remenberMe;
	
	@FindBy(css = "input[class=\"button-1 login-button\"]")
	WebElement loginBtn;
	
	public Registerpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void registerInfo(String firstname,String Lastname,String userid,String password) {
		
		gender.click();
		fname.sendKeys(firstname);
		lname.sendKeys(Lastname);
		email.sendKeys(userid);
		pass.sendKeys(password);
		Cpass.sendKeys(password);
		registerBtn.click();
		
	}
	
	public void LoginPage(String user,String password) {
		lgOut.click();
		login.click();
		email.sendKeys(user);
		pass.sendKeys(password);
		remenberMe.click();
		loginBtn.click();
		
	}
}
