package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browser {
	
	public ChromeDriver chromebrowser()
	{
		
		ChromeDriver driver = (ChromeDriver) WebDriverManager.chromedriver().create();
		return driver;
	}
}
