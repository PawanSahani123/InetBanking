package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	{
		File file= new File("./Configration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) 
		{
			System.out.println("Execption :"+e.getMessage());
		}
	}
	
     public String getApplicationURL()
     {
    	 String url=pro.getProperty("Baseurl");
    	 return url;
     }
     public String getusername()
     {
    	 String CustomerUsername=pro.getProperty("Username1");
    	 return CustomerUsername;
     }
	
     public String getPasswordname()
     {
    	 String Confirmpassword=pro.getProperty("Password1");
    	 return Confirmpassword;
     }
}


