package practice2;

import org.testng.Assert;
import org.testng.annotations.Test;

import comcast.vtiger.genericUtility.ReTryImpClass;

public class DemoForRetry {
	@Test(retryAnalyzer = comcast.vtiger.genericUtility.ReTryImpClass.class)
	public void modifyContact()
	{
		Assert.assertEquals(false,true);
		System.out.println("modified contact");
	}
}
