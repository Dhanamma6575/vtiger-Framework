package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogintoActitime {

	public static void main(String[] args) throws IOException {
		
		Properties pboj=new Properties();
		FileInputStream fis=new FileInputStream("./.properties");
		pboj.load(fis);
		
		String url=pboj.getProperty("url");
		String name=pboj.getProperty("username");
		String Psw=pboj.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.name("pwd")).sendKeys(Psw);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		
		


	}

}
