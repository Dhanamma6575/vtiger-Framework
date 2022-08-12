package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.JavaUtility;
import comcast.vtiger.genericUtility.PropertyUtility;
import comcast.vtiger.genericUtility.WebDriverUtility;

public class AddProductToCampaign {

	public static void main(String[] args) throws Throwable  {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		PropertyUtility plib=new PropertyUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String Url=plib.getPropertyKeyValue("url");
		String Username=plib.getPropertyKeyValue("un");
		String Password=plib.getPropertyKeyValue("pw");
		
		driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		 wlib.mouseHoverOnElement(driver, more);
		
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
				int RanNum=jlib.getRandom();
			
				String Productname=elib.getDataFromExcel("Product",2,4)+RanNum;
			    System.out.println(Productname);
		
	    int RanNum1=jlib.getRandom();
		String camgnName=elib.getDataFromExcel("Camapaign",2,1)+RanNum1;
	
	    System.out.println(camgnName);
	    driver.findElement(By.name("campaignname")).sendKeys(camgnName);
	    driver.findElement(By.xpath("//img[@alt='Select']")).click();
	   
	    wlib.switchToWindow(driver,"Products&action");
	 
	    driver.findElement(By.id("search_txt")).sendKeys(Productname);
	    driver.findElement(By.name("search")).click();
        driver.findElement(By.xpath("//a[text()='Laptop669']")).click();
	
        wlib.switchToWindow(driver,"Campaigns&action");
  
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
      String value=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
     
		
		if(value.contains(camgnName))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
        Thread.sleep(3000);
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		 wlib.mouseHoverOnElement(driver, signout);
		 
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 driver.close();
}
}
