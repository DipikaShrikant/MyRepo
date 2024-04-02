package com.CJC.JpetDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	WebDriver driver;
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"gnb-menu\"]/div[1]/div[3]/div/form/div/div/button")
	WebElement loginBtn;
	
	
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Logincheck() {
		username.clear();
		username.sendKeys("Dipika@gmail.com");
		password.clear();
		password.sendKeys("Dipika@123");
		loginBtn.click();
	}
}
