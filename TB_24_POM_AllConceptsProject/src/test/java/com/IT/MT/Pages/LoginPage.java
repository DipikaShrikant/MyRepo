package com.IT.MT.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name = "userName")
	WebElement user;

	@FindBy(name = "password")
	WebElement pass;

	@FindBy(name = "submit")
	WebElement submitbtn;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void LoginCheck_Simple() {
		user.sendKeys("Dipika@gmail.com");
		pass.sendKeys("Dipika@123");
		submitbtn.click();
	}
	
	public void LoginCheck_DataProvider(String userid,String password) {
		user.sendKeys(userid);
		pass.sendKeys(password);
		submitbtn.click();
		driver.navigate().back();
		driver.navigate().refresh();
	}
	
	public void LoginCheck_properties(String userid,String password) {
		user.sendKeys(userid);
		pass.sendKeys(password);
		submitbtn.click();
	}
	
	public void LoginCheck_Excel(String userid,String password) {
		user.sendKeys(userid);
		pass.sendKeys(password);
		submitbtn.click();
		driver.navigate().back();
		driver.navigate().refresh();
		
	}
}
