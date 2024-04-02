package com.Testing.DemoWebShop.Test;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.IT.MT.Test.LoginTest;
import com.Testing.DemoWebShop.pages.Registerpage;

public class RegisterTest {
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
		driver.get("https://demowebshop.tricentis.com/register");
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

	@Test(dataProvider = "getData", priority = 1)
	public void registerTest(String fname, String lname, String email, String pass) {
		Registerpage register = PageFactory.initElements(driver, Registerpage.class);
		register.registerInfo(fname, lname, email, pass);
	}

	@Test(priority = 2)
	public void loginTest() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\CJC -Classes\\TB_24_POM_AllConceptsProject\\src\\test\\resources\\Config.properties");

		prop.load(file);

		Registerpage lp = PageFactory.initElements(driver, Registerpage.class);
		lp.LoginPage(prop.getProperty("username1"), prop.getProperty("password1"));
	}

	@Test(priority = 3)
	public void ExcelLogin() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\Documents\\ADipika\\ExcelFilesPractice\\MercuryTest.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = row.getCell(0);
		String usernm = cell.getStringCellValue();
		XSSFCell cell1 = row.getCell(1);
		String pass = cell1.getStringCellValue();
		Registerpage page = PageFactory.initElements(driver, Registerpage.class);
		page.LoginPage(usernm, pass);

	}

//	@Test
//	public void AllDatainExcel() throws IOException {
//		FileInputStream fil = new FileInputStream(
//				"C:\\Users\\admin\\Documents\\ADipika\\ExcelFilesPractice\\MercuryTest.xlsx");
//		XSSFWorkbook wb = new XSSFWorkbook(fil);
//
//		XSSFSheet sheet = wb.getSheet("Sheet1");
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//			XSSFRow row = sheet.getRow(i);
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//
//				Registerpage rp = PageFactory.initElements(driver, Registerpage.class);
//				rp.LoginPage(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
//			}
//		}
//
//	}

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
		return new Object[][] { new Object[] { "Sachin", "Tendulkar", "ST120016@gmail.com", "ST@123" } };
	}
}
