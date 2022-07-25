package AutomationFramework;

import org.testng.annotations.Test;
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

public class JavaAssign {
	
	private static Timeouts wait;

	@Test
	public static void test1() throws InterruptedException 
	{
		
		ChromeDriver driver = new ChromeDriver();		
		WebDriverManager.chromedriver().setup();
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("admin@xyz.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("admin@123");
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@title=\"Dresses\"])[2]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox' and @name='layered_id_attribute_group_1']")).click();
		WebElement dropdown = driver.findElement(By.id("selectProductSort"));	
		Select select = new Select(dropdown);
		select.selectByVisibleText("Price: Lowest first");
		Thread.sleep(10000);
		WebElement ele = driver.findElement(By.xpath("//h5//a[@title='Printed Chiffon Dress']"));
		Actions action= new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='Add to cart' and @data-id-product='7']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();

	}

}
