package com.Testing.Magneto.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Testing.Magneto.pages.MagnetoLoginPage;

@Listeners(Utility.ITestListners.class)

public class MagnetoLoginTest {
	WebDriver driver;
	Logger log = Logger.getLogger(MagnetoLoginTest.class.getName());

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\CJC -Classes\\TB_24_POM_AllConceptsProject\\src\\test\\resources\\Chrome_exe\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	@Parameters({ "url" })
	public void launchURL(String url) {
		driver.get(url);
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

	@Test(enabled = false)
	public void user_info_with_MultipleExcelData() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\admin\\Documents\\ADipika\\ExcelFilesPractice\\Magneto_userInfo.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet("Sheet1");
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			XSSFRow row = sh.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {

			}
			MagnetoLoginPage loginPage = PageFactory.initElements(driver, MagnetoLoginPage.class);

			loginPage.createAccountWithMultipleUser(row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(),
					row.getCell(3).getStringCellValue());

		}

	}

	@Test(priority = 1)
	public void User_Info_form() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\admin\\Documents\\ADipika\\ExcelFilesPractice\\Magneto_userInfo.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet("Sheet1");

		XSSFRow row = sh.getRow(2);
		String fname = row.getCell(0).getStringCellValue();
		String lname = row.getCell(1).getStringCellValue();
		String email = row.getCell(2).getStringCellValue();
		String pass = row.getCell(3).getStringCellValue();
		MagnetoLoginPage loginPage = PageFactory.initElements(driver, MagnetoLoginPage.class);

		loginPage.createAccount(fname, lname, email, pass);
	}

	@Test(priority = 2)
	@Parameters({ "username", "pass" })
	public void SignIn(String user, String pass) throws InterruptedException {
		MagnetoLoginPage loginPage = PageFactory.initElements(driver, MagnetoLoginPage.class);

		loginPage.LoginToAccount(user, pass);

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
		log.info("close DB");
	}

	@AfterSuite
	public void afterSuite() {
		//driver.quit();
	}

}
