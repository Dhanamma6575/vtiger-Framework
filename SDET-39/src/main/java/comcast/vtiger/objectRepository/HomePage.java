package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comcast.vtiger.genericUtility.WebDriverUtility;

public class HomePage {
	//initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	 
      //declaration
		@FindBy(linkText="Organizations")
		private WebElement oraganizationButton;
		
		@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
		private WebElement productButton;
		
		
		@FindBy(name="Campaigns")
		private WebElement campaignButton;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement signoutButton;
		
		@FindBy(xpath="//a[text()='More']")
		private WebElement morelink;
		
	

	//getters method	
	 public WebElement getOraganizationButton() {
				return oraganizationButton;
			}

	 public WebElement getProductButton() {
				return productButton;
			}

	

	 public WebElement getCampaignButton() {
				return campaignButton;
			}

	 public WebElement getSignoutButton() {
				return signoutButton;
			}
	 public WebElement getMorelink() {
			return morelink;
		}
	 //business logics
	 /**
	  * used for homepage
	  * @author Dhanamma
	  */
	 public void oraganizationButton()
	 {
		 oraganizationButton.click();
	 }
	 
	 public void productButton()
	 {
		 productButton.click();
	 }
	 
	 public void campaignButton()
	 {
		 campaignButton.click();
	 }
	 
	 public void signoutButton(WebDriver driver)
	 {
		 Actions a= new Actions(driver);
		 a.moveToElement(signoutButton).click().perform();
		 signoutButton.click();
	 }
	 
	 public void morelink(WebDriver driver)
	 {
		WebDriverUtility wlib=new WebDriverUtility();
		 wlib.mouseHoverOnElement(driver, morelink);
	 }
}
