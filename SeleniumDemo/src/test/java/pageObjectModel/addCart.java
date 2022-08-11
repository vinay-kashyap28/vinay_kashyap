package pageObjectModel;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addCart {
	WebDriver driver;

	public addCart(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Women']")
	WebElement womenButton;
	
	@FindBy(xpath="(//a[@title='Summer Dresses'])[1]")
	WebElement summerDress;
	
	@FindBy(id="layered_id_attribute_group_2")
	WebElement mSizeCheckbox;
	
	@FindBy(id="selectProductSort")
	WebElement listName;
	
	@FindBy(xpath="//img[@alt='Printed Chiffon Dress']")
	WebElement dress1;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	WebElement continueShop;
	
	@FindBy(xpath="//img[contains(@src,'1/2/12')]")
	WebElement dress2;
	
	@FindBy(xpath="//a[@title='Add to cart' and @data-id-product='7']")
	WebElement addDress1;
	
	@FindBy(xpath="//a[@title='Add to cart' and @data-id-product='5']")
	WebElement addDress2;
	
	@FindBy(xpath="//a[contains(@title,'Proceed to checkout')]")
	WebElement checkOut;
	
	@FindBy(xpath="//a[@title=\"Return to Home\"]")
	WebElement clickHome;
	
	public void addCartValue() throws InterruptedException
	{
		clickHome.click();
		Thread.sleep(5000);
		Actions action= new Actions(driver);
		WebElement ele = womenButton;
		action.moveToElement(ele).perform();
		summerDress.click();		
		mSizeCheckbox.click();		
		WebElement productSort = listName;	
		Select list = new Select(productSort);
		list.selectByVisibleText("Price: Lowest first");
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Printed Chiffon Dress']")));
		WebElement ele1 = dress1;	
		action.moveToElement(ele1).perform();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Add to cart' and @data-id-product='7']")));		
		addDress1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Continue shopping']")));
		continueShop.click();		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebElement ele2 = dress2;
		action.moveToElement(ele2).perform();
		Thread.sleep(5000);
		addDress2.click();
		Thread.sleep(8000);
		checkOut.click();
		assertEquals("47.38", "47.38");
	}

	

}
