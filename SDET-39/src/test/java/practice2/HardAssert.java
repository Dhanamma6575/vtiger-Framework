package practice2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
   
	@Test
	public void createdCustomerTest()
	{
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals("A","A");
		System.out.println("step 3");
		System.out.println("step 4");
	}
	
	@Test
	public void modifyCustomerTest()
	{
		System.out.println("=======================================");
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
	}
}
