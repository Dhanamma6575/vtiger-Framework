package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	//initialization
	public LoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="user_name")
	private WebElement usernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
    //getter methods
	public WebElement getUsernametextfield() {
		return usernameTextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordTextfield;
	}

     public WebElement getLoginbutton() {
		return loginButton;
	}
     
     //business logics
     /**
      * used for login app
      * @param username
      * @param password
      * @author Dhanamma
      */
     public void login(String username,String password)
     {
    	 usernameTextfield.sendKeys(username);
    	 passwordTextfield.sendKeys(password);
    	 loginButton.click();
     }
}
