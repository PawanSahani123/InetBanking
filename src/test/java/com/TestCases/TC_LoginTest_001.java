package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjectModel.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException
	{
		log.info("Open URL");
		driver.get(url);

		LoginPage pg= new LoginPage(driver);
		
		
	    pg.EnterUsername(Username1);
		pg.Enterpasswordname(Password1);
		
		log.info("Entered Username and password");
		pg.clickonbutton();
		log.info("clicked on Login button");
		capture(driver,"loginTest1");
		if(driver.getTitle().equals("Guru9 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("Test is passed");
		}
		else
		{
			capture(driver,"loginTest");  // value pass to the screen short
			Assert.assertTrue(false);
			log.info("Test is failed");
		}
		
		
	}

}
