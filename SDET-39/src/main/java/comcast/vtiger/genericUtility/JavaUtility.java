package comcast.vtiger.genericUtility;

import java.util.Random;

public class JavaUtility {
     /**
      * This is used for Concatenate to Excel data 
      * @author Dhanamma
      */
	
	public int getRandom()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}
}
