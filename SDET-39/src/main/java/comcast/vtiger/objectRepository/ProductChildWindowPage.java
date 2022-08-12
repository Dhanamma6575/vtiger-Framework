package comcast.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductChildWindowPage {
	//initialization
	public ProductChildWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="search_txt")
	private WebElement productsearchTextField;
	
	@FindBy(name="search")
	private WebElement searchTextField;
	
	
	//declaration
	public WebElement getProductsearchTextField() {
		return productsearchTextField;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}
	

	//business logic
	/**
	 * used for adding product to campaign
	 * @author Dhanamma
	 */
	public void childWindowtextbox(String Productname)
	{
		productsearchTextField.sendKeys(Productname);
	}
	
	public void serchtext(WebDriver driver )
	{ 
		searchTextField.click();
		// driver.findElement(By.xpath("//a[text()='"+Productname+"']")).click();
	}
	 

	
}
