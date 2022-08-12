package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPlusButton {
	//initialization
		public  ProductPlusButton(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productPlusButton;

	//getters method
	public WebElement getProductsaveButton() {
		return productPlusButton;
	}

	//business logic
	/**
	 * used for writting product name and saving the product name
	 * @author Dhanamma
	 */
	public void pplusButton()
	{
		productPlusButton.click();
	}
}
