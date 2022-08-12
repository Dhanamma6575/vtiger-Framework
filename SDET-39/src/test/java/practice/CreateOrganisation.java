package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

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

public class CreateOrganisation {

	public static void main(String[] args) throws Throwable {
		//FileInputStream fis=new FileInputStream("./data.properties");
		//Properties pboj=new Properties();
		//pboj.load(fis);
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    PropertyUtility plib=new PropertyUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		
	
	String Url=plib.getPropertyKeyValue("url");
	String Username=plib.getPropertyKeyValue("un");
	String Password=plib.getPropertyKeyValue("pw");
	driver.get(Url);
	
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
    driver.findElement(By.linkText("Organizations")).click();
    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
 
    
    //FileInputStream fis=new FileInputStream("./Book2.xlsx");
    //Workbook wb=WorkbookFactory.create(fis);
    //Sheet sh=wb.getSheet("Organization");
    //Row row=sh.getRow(2);
    //Cell cell=row.getCell(3);
    //Random ran=new Random();
   // int ranNum = ran.nextInt(1000);
	int RanNum=jlib.getRandom();
   //String Orgname=cell.getStringCellValue()+RanNum;
	String organizationname=elib.getDataFromExcel("Organization",2,3)+RanNum;
   System.out.println(organizationname);
	driver.findElement(By.name("accountname")).sendKeys(organizationname);
   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
   Thread.sleep(3000);
   String ActualOrganizationName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    
    if(ActualOrganizationName.contains(organizationname))
    {
    	System.out.println("test case pass");
    }
    else
    {
    	System.out.println("test case fail");
    }
    Thread.sleep(3000);
   WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
   WebDriverUtility wlib=new WebDriverUtility();
   wlib.mouseHoverOnElement(driver, signout);
    //Actions a=new Actions(driver);
    //a.moveToElement(signout).perform();
    driver.findElement(By.linkText("Sign Out")).click();
    driver.close();
	}

}

