package AutomationTesting.Practice;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Objectrepository.registerObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	
	public ChromeDriver driver;
	
	@Test(priority =1)
	public void testing() throws InterruptedException, IOException
	{
		driver = (ChromeDriver) WebDriverManager.chromedriver().create();
		driver.get("http://demo.automationtesting.in/Register.html");
		registerObject ob = new registerObject(driver);
		Select s = new Select(driver.findElement(By.id("yearbox")));
		List<WebElement> options = s.getOptions();
		for(WebElement option: options)
		{
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("1996"))
			{
				option.click();
			}
		}
	
		
		
		
		
	}
	
	
	
	@Test(priority=2)
	public void day() throws IOException
	{
		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Objectrepository\\register.prop";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		driver.findElement(By.tagName("multi-select")).click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='msdd']/following-sibling::div/ul/li/a"));
		System.out.println(options.size());
		for(int i = 0; i < options.size(); i++)
		{
			System.out.println(options.get(i).getText());
			if(options.get(i).getText().equalsIgnoreCase("English") || options.get(i).getText().equalsIgnoreCase("German"))
					{
						options.get(i).click();
					}
		}
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("Screenshot//language.png"));
		Reporter.log("<img src=\'C:\\Users\\VENKATEC\\espncricinfo\\testingqa\\Screenshot\\language.png\'/>");
	}
	
	@Test(priority=3)
	public void photo()
	{
		driver.findElement(By.id("imagesrc")).sendKeys("C:\\Users\\VENKATEC\\espncricinfo\\Practice\\Screenshot\\language.png");
		
	}
	
	@Test(priority=4)
	public void submit() throws InterruptedException
	{
		registerObject ob = new registerObject(driver);
		ob.submit().click();
		Thread.sleep(1000);
	}

}
