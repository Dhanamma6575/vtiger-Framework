package comcast.vtiger.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility {
          /**
           * wait for page to load before identifying any synchronized element inDOM
           * @author Dhanamma
           */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 *After evey action it will wait for next action to perform
	 * @author Dhanamma
	 */
	public void scriptTimeOuts(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait for the element to be clickable in GUI,and checks for the specific element for every 500milliSeconds
	 * @param driver
	 * @param element
	 * @author Dhanamma
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement Element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * used to wait for the element to be clickable in GUI,and checks for the specified element based on customized time
	 * @param 
	 */
	public void waitForElementWithWithCustomeTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait =new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * used to switch to any window based on window
	 * @PartialWindowTitle
	 * @author Dhanamma
	 */
	public void switchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		 Set<String>allId=driver.getWindowHandles();
		    Iterator<String>ID=allId.iterator();
		    while(ID.hasNext())
		    {
		    	String win=ID.next();
		    	driver.switchTo().window(win);
		    	if(driver.getTitle().contains(PartialWindowTitle))
		    	{
		    		break;
		    	}
		    }
	}
	
	/**
	 * used to accept(ok) alert popo's 
	 * @param driver
	 * @author Dhanamma
	 */
	public void switchToAlertAccept(WebDriver driver )
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to dismiss(cancel) alert pop's
	 * @param driver
	 * @author Dhanamma
	 */
	public void switchToAlerDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch to frame based on index
	 * @param driver
	 * @param index
	 * @author Dhanamma
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to switch to frame based on id or name attribute
	 * @param driver
	 * @param id_name attribute
	 * @author author
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	
	/**
	 * used to select the value from the drop down based on index
	 * @param element
	 * @param index
	 * @author Dhanamme
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the drop down based on value
	 * @param element
	 * @param index
	 * @author Dhanamme 
	 */
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to place cursor on specified element
	 * @param driver
	 * @param element
	 * @author Dhanamma
	 */
	public void mouseHoverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * used to rightclick on specified element
	 * @param driver
	 * @param element
	 * @author Dhanamma
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * used to drag and drop on specified element
	 * @param driver
	 * @param element
	 * @author Dhanamma
	 */
	public void dragAndDrop(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(null, null);
	}
}

