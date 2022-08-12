package comcast.vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtility {
	/**
	 * 
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data.properties");
		Properties pro=new Properties();
		pro.load(fis);
	  String value = pro.getProperty(Key);
		return value;
		
	}
}
