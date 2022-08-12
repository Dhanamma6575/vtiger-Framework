package com.crm.Sdet.productTest;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import comcast.vtiger.objectRepository.ProductNamePage;
import comcast.vtiger.objectRepository.ProductPlusButton;
import comcast.vtiger.objectRepository.ProductValidation;
@Test(retryAnalyzer = comcast.vtiger.genericUtility.ReTryImpClass.class)
@Listeners(comcast.vtiger.genericUtility.ListenerImplimentationClass.class)
public class CreateProductTest extends BaseClass{

	@Test(groups={"smokeTest","regressionTest"})
	public void createProduct() throws Throwable {
		
		JavaUtility jlib=new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
		
		
		HomePage home=new HomePage(driver);
		home.productButton();
		
		ProductPlusButton pplusbutton=new ProductPlusButton(driver);
		pplusbutton.pplusButton();
	    int RanNum=jlib.getRandom();
        String Productname=elib.getDataFromExcel("Product",2,4)+RanNum;
		
        ProductNamePage producnamepage=new ProductNamePage(driver);
        producnamepage.productName(Productname);
        producnamepage.SaveButton();
		
		ProductValidation actualProductName=new ProductValidation(driver);
		String actualProductData=actualProductName.actualProductName();
		Assert.assertEquals(actualProductData.contains(Productname),true);
	
	   home.signoutButton(driver);
	    driver.close();
	}
	
}
