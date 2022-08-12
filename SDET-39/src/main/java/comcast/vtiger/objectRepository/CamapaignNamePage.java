package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamapaignNamePage {
	//initialization
	public  CamapaignNamePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campaignTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement campaignSaveButton;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement addProductPlusButton;

	
	//getters method
	public WebElement getCampaignTextField() {
		return campaignTextField;
	}

	public WebElement getCampaignSaveButton() {
		return campaignSaveButton;
	}
	
	public WebElement getAddProductPlusButton() {
		return addProductPlusButton;
	}
	
	//business logic
	/**
	 * used for writting campaign name and save camaign name
	 * @author Dhanamma
	 */
	public void campaignNameTextField(String cname)
	{
		campaignTextField.sendKeys(cname);
	}
	
	public void campaignsavebutton()
	{
		
		campaignSaveButton.click();
	}
	public void addproductPlusbutton()
	{
		addProductPlusButton.click();
	}
}
