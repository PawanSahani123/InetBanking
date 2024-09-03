package com.TestCases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjectModel.LoginPage;
import com.Utilities.ReaddatafromExcel;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="read")
	public void logindd(String user , String pass)
	{
		LoginPage lp = new LoginPage(driver);
		lp.EnterUsername(user);
		lp.Enterpasswordname(pass);
		lp.clickonbutton();
	}
	
	
	
	@DataProvider(name="read")
	String [][]getData() throws IOException
	{
		String path="C://Users//Admin//eclipse-workspace//InetBankingV1/src//test//java//com//TestData//testdata.xlsx";
		int rownum=ReaddatafromExcel.getRowCount(path, "sheet1");
		int colcount=ReaddatafromExcel.getcellcount(path, "sheet1");
		String ReaddatafromExcel[][]= new String[rownum][colcount];
		
		ReaddatafromExcel r= new ReaddatafromExcel();
		for(int i=1 ;i<=rownum ;i++)
		{
			XSSFRow row =r.sheet.getRow(i);
			
			for(int j=0 ;j<colcount ;j++)
			{

				XSSFCell cell=row.getCell(j);
                         
				System.out.print("||"+cell);
				
			}
		}
		return ReaddatafromExcel;
	}

}
