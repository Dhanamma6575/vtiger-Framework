package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPlusButton {
	//initialization
	public  OrganizationPlusButton(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	//declaration
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement organizationPlusButton;

	//getters methods
		public WebElement getOrganizationplusButton() {
			return organizationPlusButton;
		}
	
	//business logic
		/**
		  * used for homepage
		  * @author Dhanamma
		  */
		public void plusButton()
		{
			organizationPlusButton.click();
		}
		
}
