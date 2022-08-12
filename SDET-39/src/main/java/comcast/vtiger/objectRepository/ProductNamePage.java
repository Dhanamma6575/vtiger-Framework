package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductNamePage {
		//initialization
		public  ProductNamePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="productname")
		private WebElement productNameTextField;
	
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement productSaveButton;

		//getters method
		public WebElement getProductnameTextField() {
			return productNameTextField;
		}

		public WebElement getProductsaveButton() {
			return productSaveButton;
		}
		
		//business logic
		/**
		 * used to write product name and save the product
		 * @author Dhanamma
		 * @return 
		 */
		public void productName(String ProductName)
		{
			productNameTextField.sendKeys(ProductName);
		}
		
		public void SaveButton()
		{
			productSaveButton.click();
		}
}
