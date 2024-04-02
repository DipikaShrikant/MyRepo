package com.IT.MT.Test;

import org.testng.annotations.Test;

import com.IT.MT.Pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LoginTest {
	WebDriver driver;
	static Logger log = Logger.getLogger(LoginTest.class.getName());

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\CJC -Classes\\TB_24_POM_AllConceptsProject\\src\\test\\resources\\Chrome_exe\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void launchURL() {
		driver.get("https://demo.guru99.com/test/newtours/");
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

//	@Test(priority = 1)
//	public void Simple_LoginTest() {
//		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
//		login.LoginCheck_Simple();
//		log.info("Simple Login Test Sucessful");
//	}
//
//	@Test(priority = 2, dataProvider = "getData")
//	public void DataProvide_LoginTest(String user, String pass) {
//		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
//		lp.LoginCheck_DataProvider(user, pass);
//		log.info("Login Test wth DataProvider Successful");
//
//	}
//
//	@Test(priority = 3)
//
//	public void Properties_LoginTest() throws IOException {
//		Properties prop = new Properties();
//		FileInputStream file = new FileInputStream(
//				"C:\\CJC -Classes\\TB_24_POM_AllConceptsProject\\src\\test\\resources\\config.properties");
//		prop.load(file);
//
//		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
//		lp.LoginCheck_properties(prop.getProperty("username"), prop.getProperty("password"));
//		log.info("Login test with Properties fille Successfull");
//	}
//
//	@Test(priority=4)
//
//	public void Excel_LoginTest() throws IOException {
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\admin\\Documents\\ADipika\\ExcelFilesPractice\\MercuryTest.xlsx");
//
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet("Sheet1");
//		XSSFRow row = sheet.getRow(0);
//		XSSFCell cell = row.getCell(0);
//		String user = cell.getStringCellValue();
//		XSSFCell cell2 = row.getCell(1);
//		String pass = cell2.getStringCellValue();
//
//		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
//		lp.LoginCheck_Excel(user, pass);
//		log.info("Login from excel Data successful");
//	}
//
//	
	@Test()
	public void MultipalExcel_LoginTest() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\Documents\\ADipika\\ExcelFilesPractice\\MercuryTest.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
				lp.LoginCheck_Excel(row.getCell(0).getStringCellValue(), 
			                        row.getCell(1).getStringCellValue());

			}
		}
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
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { new Object[] { "Rohit11@gmail.com", "RS@123" },
				new Object[] { "Mohit11@gmail.com", "MK@123" }

		};
	}
}
