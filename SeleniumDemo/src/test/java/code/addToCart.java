package code;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.addCart;
import pageObjectModel.commonPage;
import pageObjectModel.registration;
import utility.Reporter;

public class addToCart extends Reporter{
	
	private static Timeouts wait;
	
	static WebDriver driver= null;
	
	
	@BeforeTest
	public void setUP() throws InterruptedException
	{
		driver = new ChromeDriver();		
		WebDriverManager.chromedriver().setup();
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test(dataProvider="login")
	public static void testaddTocart(String username, String  password) throws InterruptedException 
	{
		test = extent.createTest("testaddTocart");
		test.log(Status.INFO, "Log in");
		commonPage commonpage = new commonPage(driver);
		commonpage.login(username, password);
		Thread.sleep(5000);
		test.log(Status.INFO, "Add to cart");
		addCart  addcart = new addCart(driver);
		addcart.addCartValue();
		test.pass("Items has been added");
	}
	@AfterTest
	public void close() 
	{
		driver.quit();
	}
	
	@DataProvider
	public String[][] login() throws IOException
	{
		String filePath="./TestData/";
		String fileName="LoginDetails.xlsx";
		String sheetName="Login";
		
		String[][] data = utility.ReadExcel.ReadExcelData(filePath, fileName, sheetName);
		return data;
	}
	
	@DataProvider
	public String[][] registration() throws IOException
	{
		String filePath="./TestData/";
		String fileName="RegistrationDetails.xlsx";
		String sheetName="Registration";
		
		String[][] data = utility.ReadExcel.ReadExcelData(filePath, fileName, sheetName);
		return data;
	}
	
}
