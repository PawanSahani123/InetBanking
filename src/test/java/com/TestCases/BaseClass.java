package com.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utilities.ReadConfig;
import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig= new ReadConfig();
	public String url=readconfig.getApplicationURL();
	public String Username1=readconfig.getusername();
	public String Password1=readconfig.getPasswordname();



	/*public String url="https://demo.guru99.com/v4/index.php";
	public String Username1="mngr587161";
	public String Password1="bAsUpuv";
	 */
	public static WebDriver driver;
	public static Logger log;

	@Parameters({"browser"})
	@BeforeClass
	void setup(String br)
	{
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option= new ChromeOptions();
			option.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
			driver=new ChromeDriver(option);
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}

		else {
			driver.get(url);
		}

		/*	WebDriverManager.chromedriver().setup();
		ChromeOptions option= new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
		driver=new ChromeDriver(option); */
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




		log=LogManager.getLogger("InetBankingV1");

	}
		@AfterClass
		void teardown()
		{
			//driver.close();
			driver.quit();
		}

     	@Test
		public void capture(WebDriver driver , String tname) throws IOException
		{
			TakesScreenshot ts= (TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File des= new File("./Screenshot/"+tname +".png");
			FileUtils.copyFile(src, des);
		}



}
