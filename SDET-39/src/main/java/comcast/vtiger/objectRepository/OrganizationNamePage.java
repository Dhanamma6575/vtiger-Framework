package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationNamePage {
	//initialization
	public OrganizationNamePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement oraganizationNameTextfield;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement organizationsaveButton;

	//getters method
	public WebElement getOraganizationNameTextfield() {
		return oraganizationNameTextfield;
	}
	public WebElement getOrganizationsaveButton() {
		return organizationsaveButton;
	}
	
	//business logic
	/**
	 * used for writting organisation name and save the organization name
	 * @author Dhanamma
	 */
	public void organizationName(String OraganizationName)
	{
		oraganizationNameTextfield.sendKeys(OraganizationName);
	}
	public void savebutton()
	{
		organizationsaveButton.click();
		
	}
	
	
}
