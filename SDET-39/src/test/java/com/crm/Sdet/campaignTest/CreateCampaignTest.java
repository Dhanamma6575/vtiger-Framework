package com.crm.Sdet.campaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.JavaUtility;
import comcast.vtiger.genericUtility.PropertyUtility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.objectRepository.CamapaignNamePage;
import comcast.vtiger.objectRepository.CampaignPlusButton;
import comcast.vtiger.objectRepository.CampaignValidation;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage1;
@Listeners(comcast.vtiger.genericUtility.ListenerImplimentationClass.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups={"smokeTest","regressionTest"})
	public void createCampaign() throws Throwable{
		//WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//PropertyUtility plib=new PropertyUtility();
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		//WebDriverUtility wlib=new WebDriverUtility();
		
		//String Url=plib.getPropertyKeyValue("url");
		//String Username=plib.getPropertyKeyValue("un");
		//String Password=plib.getPropertyKeyValue("pw");
		
		//driver.get(Url);
		//LoginPage1 login1=new LoginPage1(driver);
		//login1.login(Username, Password);
		
		//driver.findElement(By.name("user_name")).sendKeys(Username);
		//driver.findElement(By.name("user_password")).sendKeys(Password);
		//driver.findElement(By.id("submitButton")).click();
		
		HomePage home=new HomePage(driver);
		home.morelink(driver);
		//WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		//Actions a=new Actions(driver);
		 //a.moveToElement(more).perform();
		//WebElement more=driver.findElement(By.xpath("//a[text()='More']"));
		 //wlib.mouseHoverOnElement(driver, more);
		//driver.findElement(By.name("Campaigns")).click();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		 
		
		home.campaignButton();
		
		CampaignPlusButton cplusbutton=new CampaignPlusButton(driver);
		cplusbutton.campaignPlusButton();
	    int RanNum=jlib.getRandom();
	   	String camgnName=elib.getDataFromExcel("Camapaign",3,1)+RanNum;
	   	
	   	CamapaignNamePage campaignnamepage=new CamapaignNamePage(driver);
	   	
	   	campaignnamepage.campaignNameTextField(camgnName);
	   	campaignnamepage.campaignsavebutton();
	    //String camgnName = cell.getStringCellValue()+RanNum;
	    //System.out.println(camgnName);
	    //driver.findElement(By.name("campaignname")).sendKeys(camgnName);
	    //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
		//String Actualcampaignname=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		CampaignValidation actualData=new CampaignValidation(driver);
		String actualCampaignName=actualData.actualCampaignName();
		Assert.assertEquals(actualCampaignName.contains(actualCampaignName),true);
	   	
		//if(Actualcampaignname.contains(camgnName))
		//{
			//System.out.println("pass");
		//}
		//else
		//{
			//System.out.println("fail");
		//}
		
		   home.signoutButton(driver);
		  
		    driver.close();
	}

}
