package practice2;

import org.testng.annotations.Test;

public class Sample1 {
	@Test                
	public void createContat()
	{
		System.out.println("contact created");
		int[] arr= {1,2,3};
		System.out.println(arr[5]);

	}
	@Test (dependsOnMethods="createContat")              
	public void modifyContact()
	{
		System.out.println("modifty contact");
	}
    @Test (dependsOnMethods="modifyContact")              
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
