package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LogintoFlipkart {

	public static void main(String[] args) throws IOException {
		Properties pboj=new Properties();
		FileInputStream fis=new FileInputStream("./flipkart.properties");
		pboj.load(fis);
		
		String url=pboj.getProperty("url");
		
		String name=pboj.getProperty("enteremail");
		String Psw=pboj.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	    driver.findElement(By.xpath("//a[text()='Login']")).click();
	    	 
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Psw);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		

	}

}
