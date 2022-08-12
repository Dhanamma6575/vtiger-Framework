package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comcast.vtiger.genericUtility.WebDriverUtility;

public class DeleteProductPage {
	//initialization
	public DeleteProductPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteButton;

	//getters method
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	//business logic
	/**
	 * used for deleting product which is created 
	 * @author Dhanamma 
	 * @param switchToWindow 
	 */
	public void switchToAlert(WebDriver driver)
	{
		deleteButton.click();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.switchToAlertAccept(driver);
		
	}
	
	
}
