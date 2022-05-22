package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
}
