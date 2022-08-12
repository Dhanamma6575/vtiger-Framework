package com.crm.Sdet.AddProductToCampaignTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import comcast.vtiger.objectRepository.ProductChildWindowPage;
import comcast.vtiger.objectRepository.ProductNamePage;
import comcast.vtiger.objectRepository.ProductPlusButton;
@Listeners(comcast.vtiger.genericUtility.ListenerImplimentationClass.class)
public class AddCampaignToProductTest extends BaseClass {

	@Test(groups={"smokeTest","regresstionTest"})
	public void createCampaignWithProduct() throws Throwable{
		
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();	
		HomePage home=new HomePage(driver);
		home.productButton();
		
		ProductPlusButton pplusbutton=new ProductPlusButton(driver);
		pplusbutton.pplusButton();
		

			int RanNum=jlib.getRandom();
		    String Productname=elib.getDataFromExcel("Product",2,4)+RanNum;
		    ProductNamePage producnamepage=new ProductNamePage(driver);
	        producnamepage.productName(Productname);
	        producnamepage.SaveButton();
		    System.out.println(Productname);
		 
			   
			home.morelink(driver);
			
			
			home.campaignButton();
			CampaignPlusButton cplusbutton=new CampaignPlusButton(driver);
			cplusbutton.campaignPlusButton();
			
		     int RanNum1=jlib.getRandom();
		     String camgnName=elib.getDataFromExcel("Camapaign",2,1)+RanNum1;
		     CamapaignNamePage camnamepage=new CamapaignNamePage(driver);
			 camnamepage.campaignNameTextField(camgnName);
			 System.out.println(camgnName);
			 camnamepage.addproductPlusbutton();
		   
			    
			wlib.switchToWindow(driver,"Products&action");
			
			 ProductChildWindowPage childwindow= new ProductChildWindowPage(driver);
			 childwindow.childWindowtextbox(Productname);
			 childwindow.serchtext(driver);
			 Thread.sleep(3000);
			
		   driver.findElement(By.xpath("//a[text()='"+Productname+"']")).click();
		    
		    wlib.switchToWindow(driver,"Campaigns&action");
		    camnamepage.campaignsavebutton();
		  
			CampaignValidation actualData=new CampaignValidation(driver);
			String actualCampaignName=actualData.actualCampaignName();
			Assert.assertEquals(actualCampaignName.contains(actualCampaignName),true);
				
				
		home.signoutButton(driver);
		 driver.close();
			    
	}

}
