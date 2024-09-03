package com.TestCases;




import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjectModel.AddCustomerName;
import com.PageObjectModel.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void TC_AddCustomerTest_003() throws IOException, InterruptedException 
	{
		driver.get(url);
		
		LoginPage cp= new LoginPage(driver);
		cp.EnterUsername(Username1);
		cp.Enterpasswordname(Password1);
		cp.clickonbutton();
		
		Thread.sleep(4000);
		
		AddCustomerName addcust = new AddCustomerName(driver);
		addcust.clickonnewcustomer();
		addcust.EnterCustomerName("Pawan");
		addcust.clickcustomerradio("Male");
		addcust.EnterDob("10", "15", "1995");
		addcust.Enteraddress("BMC Colony anand nagar");
		addcust.EnterCity("Mumbai");
		addcust.Enterstate("Maharashtra");
		addcust.Enterpincode(400102);
		Thread.sleep(3000);
		addcust.Entermobile(888888);
		
		String Emailid =randomString()+"@gmail.com";
		addcust.addressemail(Emailid);
		addcust.enterpassword("134555");
		addcust.clickonsubit();
		
		Thread.sleep(3000);
		
		boolean  res=driver.getPageSource().contains("Customer Registered Successfully!!!");
           if(res=true)
           {
        	  Assert.assertTrue(true);
           }
           else
           {
        	   capture(driver,"addcustomer");
        	   Assert.assertTrue(false);
           }
	}
		
	public String randomString()
	{
		String generate =RandomStringUtils.randomAlphabetic(8);
		return generate;
	}
}
