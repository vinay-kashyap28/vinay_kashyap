package utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {
	 public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest test;
	 
	@BeforeSuite()
	public void setUpReport()
	{
		System.out.println("Running Before Suite");
		htmlReporter = new ExtentHtmlReporter("report.html");
		//create ExtentReports and attach reporter(s)
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);

	}
	@AfterMethod()
	public void afterMethod(ITestResult result)
	{
		System.out.println("Running after Suite");
		if (result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(result.getName()+" Testcase Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(MarkupHelper.createLabel(result.getName()+" Testcase Pass", ExtentColor.GREEN));
		}
		else 
		{
			test.skip(MarkupHelper.createLabel(result.getName()+" Testcase Skip", ExtentColor.BLUE));
		}
	}
	
	@AfterSuite()
	public void closeReport()
	{
		extent.flush();
	}
}
