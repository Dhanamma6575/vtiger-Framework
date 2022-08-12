package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPlusButton {
	//initialization
	public CampaignPlusButton(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement camapignPlusButton;

	//getters method
	public WebElement getCamapignPlusButton() {
		return camapignPlusButton;
	}
	
	//business logic
	/**
	 * used for writting campaign name and save campaign name
	 * @author Dhanamma
	 */
	public void campaignPlusButton()
	{
		camapignPlusButton.click();
	}
}
