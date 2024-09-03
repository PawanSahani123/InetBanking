package com.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerName{

	public static	WebDriver Idriver; 
	public  AddCustomerName(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver ,this);
	}
	
	//identify the element
	@FindBy(linkText= "New Customer")WebElement newCustomer;
	@FindBy(name = "name")WebElement customerName;
	@FindBy(xpath = "//input[@type='radio'][@value='m']")WebElement mgender;
	@FindBy(id="dob")WebElement dob;
	@FindBy(name="addr")WebElement address;
	@FindBy(name="city")WebElement city;
	@FindBy(name="state")WebElement state;
	@FindBy(name="pinno")WebElement pincode;
	@FindBy(name="telephoneno")WebElement mobile1;
	
	@FindBy(name="emailid")WebElement email;
	@FindBy(name="password")WebElement password;
	@FindBy(name="sub")WebElement submit;
	
	// action method those who have find element
	
	public void clickonnewcustomer()
	{
		newCustomer.click();
	}
	public void EnterCustomerName(String cname)
	{
		customerName.sendKeys(cname);
	}
	
	public void clickcustomerradio(String cgender)
	{
		mgender.click();
	}
	
	public void EnterDob(String mm, String dd, String yy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yy);
	}
	
	public void Enteraddress(String caddress)
	{
		address.sendKeys(caddress);
	}
	
	public void EnterCity(String ccity)
	{
		city.sendKeys(ccity);
	}
	public void Enterstate(String cstate)
	{
		state.sendKeys(cstate);
	}
	public void Enterpincode(int pin)
	{
		pincode.sendKeys(String.valueOf(pin));
	}
	public void Entermobile(int mobile)
	{
		mobile1.sendKeys(String.valueOf(mobile));
	}
	
	public void addressemail(String cemail)
	{
		email.sendKeys(cemail);
	}
	public void enterpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickonsubit()
	{
		submit.click();
	}
	
}
    