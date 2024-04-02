package com.CJC.JpetDemo.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CJC.JpetDemo.pages.Login;

public class LoginTest {
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\git\\MyRepo\\TB_24_POM_AllConceptsProject\\src\\test\\resources\\Chrome_exe\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void launchURL() {
		driver.get("https://jpetstore.aspectran.com/account/signonForm");
	}

	@BeforeClass
	public void Cookies() {
		driver.manage().getCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void maximize() {
		driver.manage().window().maximize();
	}
	@Test
	public void LoginTest() {
		Login login = PageFactory.initElements(driver, Login.class);
		login.Logincheck();
	}
	@AfterMethod
	public void screenShot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src,
				new File("C:\\CJC -Classes\\TB_24_POM_AllConceptsProject\\src\\test\\resources\\screenShot"));
	}

	@AfterClass
	public void deleteCokies() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void closedb() {
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}


}
