package practice2;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 public class ScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		TakesScreenshot ts =(TakesScreenshot) driver;
		File RAM = ts.getScreenshotAs(OutputType.FILE);

		File dest=new File("./photo/screenshot.png");
		driver.close();

		FileUtils.copyFile(RAM, dest);

	}
 }

