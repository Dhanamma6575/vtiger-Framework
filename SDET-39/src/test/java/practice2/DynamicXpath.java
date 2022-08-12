package practice2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
   WebElement src=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
   WebElement dest=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
   src.sendKeys("Mumbai");
   driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
   
   dest.sendKeys("New Dehli");
    driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
    
    driver.findElement(By.xpath("//label[@for='departure']")).click();
    
    String requiredMonth="november";
    String requiredYear="2022";
    String requiredDate="15";
    
    String currentMonthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]")).getText();
    String currentMonth=currentMonthYear.split(" ")[0];
    String currentYear=currentMonthYear.split(" ")[1];
    
    while((currentMonth.equalsIgnoreCase(requiredMonth)) && currentYear.equals(currentYear)) 
    {
    driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
    currentMonthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
    currentMonth=currentMonthYear.split(" ")[0];
    currentYear=currentMonthYear.split(" ")[1];
	}

    driver.findElement(By.xpath("(//a[text()='"+requiredDate+"'])[1]")).click();
}
}