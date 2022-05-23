package AutomationTesting.Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objectrepository.registerObject;
import base.browser;


public class index extends browser{
	public ChromeDriver driver;
	Properties prop = new Properties();
	FileInputStream fis;
	public Logger log = LogManager.getLogger(index.class);
	
	@BeforeTest
	public void browsercache() throws IOException
	{
		driver =  chromebrowser();
		
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Objectrepository\\index.prop";
		fis = new FileInputStream(path);
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.clearBrowserCache());
		log.info(driver.getTitle());
	}
	
	@Test(priority = 1)
	public void indexPage() throws IOException
	{
		
		driver.findElement(By.id(prop.getProperty("enter"))).click();
		log.info(driver.getTitle());
	}
	
	@Test(priority =2)
	public void Name() throws IOException  {
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Objectrepository\\register.prop";
		fis = new FileInputStream(path);
		prop.load(fis);
		
		registerObject ob = new registerObject(driver);
		ob.firstName().sendKeys(prop.getProperty("firstName"));
		ob.lastName().sendKeys(prop.getProperty("lastName"));
	}
	
	@Test(priority=3)
	public void address() throws InterruptedException
	{
		registerObject ob = new registerObject(driver);
		ob.address().sendKeys(prop.getProperty("address")+Keys.ENTER+"Chennai - TamilNadu");
		
		/*drag and drop doubt
		Actions a = new Actions(driver);
		a.dragAndDrop(ob.address(),driver.findElement(By.xpath("//textarea[@style='width: 343px; height: 70px;']"))).build().perform();*/
	}
	
	@Test(priority=4)
	public void Emailtip()
	{
		registerObject ob = new registerObject(driver);
		String emailToolTip = ob.emailTooltip().getText();
		log.info("emaliTooltipText is:"+emailToolTip);
	}
	
	@Test(priority=5)
	public void Email() throws IOException
	{
		
		registerObject ob = new registerObject(driver);
		String path1 = System.getProperty("user.dir")+"\\src\\main\\java\\Objectrepository\\register.prop";
		FileInputStream fis1 = new FileInputStream(path1);
		prop.load(fis1);
		ArrayList<String> a = new ArrayList<String>();
		String path = "C:\\Users\\VENKATEC\\OneDrive - The Walt Disney Company\\Desktop\\WebDevelopment\\automation.xlsx";
		fis = new FileInputStream(path);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		int sheets = xs.getNumberOfSheets();
		for(int i=0; i < xs.getNumberOfSheets();i++)
		{
			if(xs.getSheetName(i).equalsIgnoreCase("Register"))
			{
				XSSFSheet sheet = xs.getSheetAt(i);
				Iterator<Row> row = sheet.rowIterator();
				Row firstrow = row.next();
				Iterator<Cell> cell = firstrow.cellIterator();
				int k =0;
				int column = 0;
				while(cell.hasNext())
				{
					Cell value = cell.next();
					
					if(value.getStringCellValue().equalsIgnoreCase("chinniahjudo27@gmail.com"))
					{
						
						System.out.println(value.getRowIndex()+","+value.getColumnIndex());
						String email = value.getStringCellValue();
						System.out.println(email);
						ob.email().sendKeys(email);
						
					}
					k++;
				}
	
			}
					
				}
				
			}
	
	@Test(priority = 6)
	public void gender() throws InterruptedException
	{
		registerObject ob = new registerObject(driver);
		List<WebElement>gen = ob.gender();
		System.out.println(gen.size());
		for(int i =0; i < gen.size();i++)
		{
			log.info("Options:"+gen.get(i).getText());
			if(gen.get(i).getText().equalsIgnoreCase("Male"))
			{
				gen.get(i).click();
			}
		}
		
	}
	
	@Test(priority=7)
	public void Hobbies() throws InterruptedException
	{
		registerObject ob = new registerObject(driver);
		List<WebElement> hobby = ob.hobbies();
		for(WebElement interest : hobby)
		{
			System.out.println(interest.getText());
			if(interest.getText().equalsIgnoreCase("Movies"))
			{
				ob.checkbox().get(0).click();
			}
		}
		
	}
	
	@Test(priority = 8)
	public void phoneNo()
	{
		registerObject ob = new registerObject(driver);
		ob.phone().sendKeys("123456789");
	}

		
	@Test(priority = 9)
	public void country()
	{
		registerObject ob = new registerObject(driver);
		Select s = new Select(ob.country());
		List<WebElement> options = s.getOptions();
		for(WebElement option: options)
		{
			log.info(option.getText());
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
			}
		}
	}
		
	
	@Test(priority=10)
	public void skills()
	{
		registerObject ob = new registerObject(driver);
		Select s = new Select(ob.skills());
		List<WebElement> options = s.getOptions();
		for(WebElement option: options)
		{
			log.info(option.getText());
			if(option.getText().equalsIgnoreCase("java"))
			{
				option.click();
			}
			
		
		}
	}
		
	
	@Test(priority=11)
	public void year()
	{
		registerObject ob = new registerObject(driver);
		Select s = new Select(ob.year());
		s.selectByVisibleText("1996");
	}
	
	@Test(priority =12)
	public void month()
	{
		registerObject ob = new registerObject(driver);
		Select s = new Select(ob.month());
		s.selectByVisibleText("November");
	}
	
	@Test(priority=13)
	public void day()
	{
		registerObject ob = new registerObject(driver);
		Select s = new Select(ob.day());
		s.selectByVisibleText("28");
		
	}
	
	@Test(priority=14)
	public void password() throws IOException
	{
		registerObject ob = new registerObject(driver);
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Objectrepository\\register.prop";
		fis= new FileInputStream(path);
		prop.load(fis);
		ob.password().sendKeys(prop.getProperty("password"));
		ob.confirmpassword().sendKeys(prop.getProperty("password"));
		
	}
	
	@Test(priority = 15)
	public void languages() throws IOException
	{
		registerObject ob = new registerObject(driver);
		ob.multiselect().click();
		List<WebElement> options = ob.languages();
		log.info(options.size());
		for(int i = 0; i < options.size(); i++)
		{
			log.info(options.get(i).getText());
			if(options.get(i).getText().equalsIgnoreCase("English") || options.get(i).getText().equalsIgnoreCase("German"))
					{
						options.get(i).click();
					}
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("Screenshot//language.png"));
		Reporter.log("<img src=\'C:\\Users\\VENKATEC\\espncricinfo\\testingqa\\Screenshot\\language.png\'/>");
	}
	
	
	@Test(priority = 16)
	public void photo()
	{
		registerObject ob = new registerObject(driver);
		ob.photos().sendKeys("C:\\Users\\VENKATEC\\espncricinfo\\Practice\\Screenshot\\language.png");
	}
	@Test(priority = 17)
	public void submit() throws InterruptedException
	{
		registerObject ob = new registerObject(driver);
		ob.submit().click();
		Thread.sleep(1000);
	}
	
		}
	
	
	
	
	
	


