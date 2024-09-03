package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReaddatafromExcel {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static int row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile ,String path) throws IOException
	{
		fi= new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheetAt(0);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		
		return rowcount;
	}
	
	public static int getcellcount(String xfile , String path)
	{
		fi= new FileInputStream(xfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheetAt(0);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		
		return cellcount;
	}
}





