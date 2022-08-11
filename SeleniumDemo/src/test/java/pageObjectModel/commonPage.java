package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonPage {

	WebDriver driver;

	public commonPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="email_create")
	WebElement createEmail;
	
	@FindBy(id="email")
	WebElement userNameFiled;
	
	@FindBy(id="SubmitCreate")
	WebElement createAnAccountButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signinButton;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement userNameTextbox;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	WebElement loginButton;

	
	public void login(String username, String password)
	{
		signinButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		userNameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		loginButton.click();
	}
	
	public void StartRegistration(String email)
	{	
		createEmail.sendKeys(email);
		createAnAccountButton.click();
	}
	public void SigninClick()
	{	
		signinButton.click();
	}
}

