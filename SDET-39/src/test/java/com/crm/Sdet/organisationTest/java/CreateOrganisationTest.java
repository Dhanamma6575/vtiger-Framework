package com.crm.Sdet.organisationTest.java;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.BaseClass;
import comcast.vtiger.genericUtility.ExcelUtility;
import comcast.vtiger.genericUtility.JavaUtility;

import comcast.vtiger.genericUtility.PropertyUtility;
import comcast.vtiger.genericUtility.WebDriverUtility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage1;
import comcast.vtiger.objectRepository.OraganizationValidation;
import comcast.vtiger.objectRepository.OrganizationNamePage;
import comcast.vtiger.objectRepository.OrganizationPlusButton;
@Listeners(comcast.vtiger.genericUtility.ListenerImplimentationClass.class)
public class CreateOrganisationTest extends BaseClass{
 
	@Test(groups={"smokeTest","regresstionTest"})
	public void createOrganization() throws Throwable {
		
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
	
	
	HomePage home=new HomePage(driver);
	home.oraganizationButton();
	
	OrganizationPlusButton orgplusbtn=new OrganizationPlusButton(driver);
	orgplusbtn.plusButton();
 
	int RanNum=jlib.getRandom();
  
	String organizationname=elib.getDataFromExcel("Organization",1,1)+RanNum;
	
	 OrganizationNamePage orgname=new OrganizationNamePage(driver);
	   orgname.organizationName(organizationname);
	   orgname.savebutton();
	    
	   Thread.sleep(3000);
	  
    OraganizationValidation actualData=new OraganizationValidation(driver);
    String actualorganizationData=actualData.actualOraganizationName();
	Assert.assertEquals(actualorganizationData.contains(organizationname),true);

    home.signoutButton(driver);
  
    driver.close();
	}

}
