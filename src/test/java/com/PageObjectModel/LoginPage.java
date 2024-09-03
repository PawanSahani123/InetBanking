package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
public static	WebDriver Idriver; 
	public LoginPage(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver ,this);
	}

	//identify the WebElement
	@FindBy(xpath="//input[contains(@name,'uid') and @type='text']")WebElement username;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(name="btnLogin")WebElement Loginbutton;
	
	
	//identify the action on webelement
	
	public void EnterUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void Enterpasswordname(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickonbutton()
	{
		Loginbutton.click();
	}
	
	
	
}
