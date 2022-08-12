package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationValidation {

	public OraganizationValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualOrganizationdata;

	public WebElement getActualOrganizationdata() {
		return actualOrganizationdata;
	}
	
	public String actualOraganizationName()
	{
		return actualOrganizationdata.getText();
	}
}
