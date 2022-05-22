package AutomationTesting.Practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;

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
	public void Email() throws IOException
	{
		String path1 = System.getProperty("user.dir")+"\\src\\main\\java\\Objectrepository\\register.prop";
		FileInputStream fis1 = new FileInputStream(path1);
		registerObject ob = new registerObject(driver);
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
	

		
			
		
		}
	
	
	
	
	
	


