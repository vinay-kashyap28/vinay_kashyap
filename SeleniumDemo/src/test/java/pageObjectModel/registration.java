package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registration {
	WebDriver driver;

	public registration(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_gender1")
	WebElement radioButtonMale;
	
	@FindBy(id="id_gender2")
	WebElement radioButtonFemale;

	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement emailAddress;
	
	@FindBy(id="passwd")
	WebElement passwordField;
	
	@FindBy(id="days")
	WebElement birthDay;
	
	@FindBy(id="months")
	WebElement birthMonth;
	
	@FindBy(id="years")
	WebElement birthYear;
	
	@FindBy(id="newsletter")
	WebElement newsLetterCheckbox;
	
	@FindBy(id="optin")
	WebElement optInCheckbox;
	
	@FindBy(id="firstname")
	WebElement addressFirstname;
	
	@FindBy(id="lastname")
	WebElement addressLastname;
	
	@FindBy(id="company")
	WebElement companyName;
	
	@FindBy(id="address1")
	WebElement addressFiled1;
	
	@FindBy(id="address2")
	WebElement addressFiled2;
	
	@FindBy(id="city")
	WebElement cityName;
	
	@FindBy(id="id_state")
	WebElement stateDropdown;
	
	@FindBy(id="postcode")
	WebElement zipCode;
	
	@FindBy(id="id_country")
	WebElement countyDropdown;
	
	@FindBy(id="other")
	WebElement aditionalInfo;
	
	@FindBy(id="phone")
	WebElement homePhone;
	
	@FindBy(id="phone_mobile")
	WebElement mobilePhone;
	
	@FindBy(id="alias")
	WebElement aliasAddress;
	
	@FindBy(id="submitAccount")
	WebElement RegisterButton;
	
	public void Registration(String gender,String fname,String lname, String email, String password, String birthday,int birthmonth, String birthyear, boolean newsLetterBoolean, boolean optinBoolean)
	{
		if (gender == "M")
		{
			radioButtonMale.click();
		}
		else
		{
			radioButtonFemale.click();
		}
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		emailAddress.clear();
		emailAddress.sendKeys(email);
		passwordField.sendKeys(password);
		Select ddBirthday= new Select(birthDay);
		ddBirthday.selectByValue(birthday);

		Select ddBirthmonth= new Select(birthMonth);
		ddBirthmonth.selectByIndex(birthmonth);
		
		Select ddBirthyear= new Select(birthYear);
		ddBirthyear.selectByValue(birthyear);
		
		if(newsLetterBoolean)
		{
			newsLetterCheckbox.click();
		}
		
		if(optinBoolean)
		{
			optInCheckbox.click();
		}
		
	}
	
	public void AddressDetails(String addressfname, String addresslname, String compnay, String adressline1, String addressline2, String city, String state, String zip, String country, String additonalInfo, String phone, String mobilephone, String alias)
	{
		addressFirstname.clear();
		addressFirstname.sendKeys(addressfname);
		addressLastname.clear();
		addressLastname.sendKeys(addresslname);
		companyName.clear();
		companyName.sendKeys(compnay);
		addressFiled1.clear();
		addressFiled1.sendKeys(adressline1);
		addressFiled2.clear();
		addressFiled2.sendKeys(addressline2);
		cityName.sendKeys(city);
		Select ddState= new Select(stateDropdown);
		ddState.selectByVisibleText(state);
		zipCode.sendKeys(zip);
		Select ddCountry= new Select(countyDropdown);
		ddCountry.selectByVisibleText(country);
		aditionalInfo.sendKeys(additonalInfo);
		homePhone.sendKeys(phone);
		mobilePhone.sendKeys(mobilephone);
		aliasAddress.clear();
		aliasAddress.sendKeys(alias);
	}
	public void ClickRegister()
	{
		RegisterButton.click();
	}
	
}


