package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogintoVtiger {

	
	public static void main(String[] args) throws IOException {
		
		Properties pboj=new Properties();
		FileInputStream fis=new FileInputStream("./data.properties");
		pboj.load(fis);
		
		String Url=pboj.getProperty("url");
		String Username=pboj.getProperty("un");
		String Password=pboj.getProperty("pw");
		
		WebDriver driver=new ChromeDriver();
		driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		

	}

}
