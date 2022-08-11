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
import pageObjectModel.commonPage;
import pageObjectModel.registration;
import utility.Reporter;

public class registrationScript extends  Reporter {
	
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
		commonPage CP  = new commonPage(driver);
		CP.SigninClick();
		CP.StartRegistration("source@gmail.com");
		Thread.sleep(8000);
	}
	
	@Test(dataProvider="registrationData")
	public static void testregistration(String gender, String fName, String lName, String email, String password, String birthDay, String birthMonth,String birthYear, String newsLetter, String optin, String addressfname, String addresslname, String compnay, String adressline1, String addressline2, String city, String state ,String zip ,String country, String additonalInfo,String phone,String mobile,String alias) throws IOException 
	{
		test = extent.createTest("testregistration");
		test.log(Status.INFO, "Registration");
		int birthMonthvalue= Integer.parseInt(birthMonth);
		boolean newsLetterBoolean;
		boolean optinBoolean;
		if (newsLetter=="TRUE")
			{
				newsLetterBoolean= true;
			}
		else
			{
				newsLetterBoolean= false;
			}
				
		if (optin=="TRUE")
			{
				optinBoolean= true;
			}
		else
			{
				optinBoolean= false;
			}
		
		registration reg  = new registration(driver);
		reg.Registration(gender, fName, lName, email, password, birthDay, birthMonthvalue, birthYear, newsLetterBoolean,optinBoolean);
		reg.AddressDetails(addressfname, addresslname, compnay, adressline1, addressline2, city, state, zip,country,additonalInfo, phone, mobile, alias);
		reg.ClickRegister();
		test.pass("Registration Sucessfull");
	}
	@AfterTest
	public void close() 
	{
		driver.quit();
	}
	
	
	@DataProvider
	public String[][] registrationData() throws IOException
	{
		String filePath="./TestData/";
		String fileName="RegistrationDetails.xlsx";
		String sheetName="Registration";
		
		String[][] data = utility.ReadExcel.ReadExcelData(filePath, fileName, sheetName);
		return data;
	}
	
}
