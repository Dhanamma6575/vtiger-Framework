package comcast.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import comcast.vtiger.objectRepository.LoginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public  static WebDriver sDriver;
	PropertyUtility plib=new PropertyUtility();
	@BeforeSuite(groups={"smokeTest","regresstionTest"})
	public void BS()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest(groups={"smokeTest","regresstionTest"})
	public void BT()
	{
		System.out.println("Execution scrip in parallel mode");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regresstionTest"})
	public void BC( ) throws Throwable
	{
		System.out.println("launching the browser");
		String Browser = plib.getPropertyKeyValue("browser");
		  if(Browser.equalsIgnoreCase("chrome"))
		  {
		   
		 WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();

		  }
		   else if(Browser.equalsIgnoreCase("firefox"))
		  {
		   WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		  }
		  else if(Browser.equalsIgnoreCase("edge"))
		   {
		   WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		   }
		 
		   else
		   {
		     driver = new ChromeDriver();
		   }
		  sDriver=driver;
		  }
	
	@BeforeMethod(groups={"smokeTest","regresstionTest"})
	public void BM() throws Throwable
	{
		System.out.println("Login to Application");
		String Url=plib.getPropertyKeyValue("url");
		String Username=plib.getPropertyKeyValue("un");
		String Password=plib.getPropertyKeyValue("pw");
	     driver.get(Url);
				
		LoginPage1 login1=new LoginPage1(driver);
		login1.login(Username, Password);
		}
	
	@AfterMethod(groups={"smokeTest","regresstionTest"})
	public void AM()
	{
		System.out.println("Logout from Application");
	}
	
	@AfterClass(groups={"smokeTest","regresstionTest"})
	public void AC()
	{
		System.out.println("closing the browser");
	}
	
	@AfterTest(groups={"smokeTest","regresstionTest"})
	public void AT()
	{
		System.out.println("parallel execution done");
	}
	
	@AfterSuite(groups={"smokeTest","regresstionTest"})
	public void AS()
	{
		System.out.println("DataBase connection close");
	}
}

