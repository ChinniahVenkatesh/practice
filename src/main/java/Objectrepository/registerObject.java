package Objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registerObject {
	
	
	public ChromeDriver driver;
	public  registerObject(ChromeDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@ng-model='FirstName']")
	WebElement firstName;
	
	public WebElement firstName()
	{
		return firstName;
	}

	By lastName  = By.xpath("//input[@ng-model='LastName']");
	
	public WebElement lastName()
	{
		return driver.findElement(lastName);
	}
	
	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	WebElement address;
	
	public WebElement address()
	{
		return address;
	}
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement email;
	
	public WebElement email()
	{
		return email;
	}
	
	@FindBy(xpath = "//div[@class='col-md-4 col-xs-4 col-sm-4']/label")
	List<WebElement> gender;
	
	public List<WebElement> gender()
	{
		return gender;
	}
	
	By hobbies = By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']/div");
	
	public List<WebElement> hobbies()
	{
		return driver.findElements(hobbies);
	}
	
	@FindBy(xpath = "//div[@class='col-md-4 col-xs-4 col-sm-4']/div/input")
	List<WebElement> checkbox;
	
	public List<WebElement> checkbox()
	{
		return checkbox;
	}
	
	
	@FindBy(xpath="//div[@class='col-sm-4 col-xs-4 tooltptext']/span")
	WebElement emailTooltip;
	
	public WebElement emailTooltip()
	{
		return emailTooltip;
	}
	
	@FindBy(xpath="//div[@class='col-md-4 col-xs-4 col-sm-4']/input[@type='tel']")
	WebElement phone;
	
	public WebElement phone()
	{
		return phone;
	}
	
	
	
	@FindBy(id="country")
	WebElement country;
	
	public WebElement country()
	{
		return country;
	}
	
	@FindBy(id="Skills")
	WebElement skills;
	
	public WebElement skills()
	{
		return skills;
	}
	
	@FindBy(id="yearbox")
	WebElement year;
	
	public WebElement year()
	{
		return year;
	}
	
	@FindBy(xpath="//select[@ng-model='monthbox']")
	WebElement month;
	
	public WebElement month()
	{
		return month;
	}
	
	@FindBy(id="daybox")
	WebElement day;
	
	public WebElement day()
	{
		return day;
	}
	
	@FindBy(id="firstpassword")
	WebElement password;
	
	public WebElement password()
	{
		return password;
	}
	
	@FindBy(id="secondpassword")
	WebElement confirmpassword;
	
	public WebElement confirmpassword()
	{
		return confirmpassword;
	}
	
	@FindBy(xpath="//button[@id='submitbtn']")
	WebElement submit;
	
	public WebElement submit()
	{
		return submit;
	}
	
	@FindBy(tagName="multi-select")
	WebElement multiselect;
	
	public WebElement multiselect()
	{
		return multiselect;
	}
	
	@FindBy(xpath="//div[@id='msdd']/following-sibling::div/ul/li/a")
	List<WebElement> languages;
	
	public List<WebElement> languages()
	{
		return languages;
	}
	
	@FindBy(id="imagesrc")
	WebElement photos;
	
	public WebElement photos()
	{
		return photos;
	}
	
	
	
}
