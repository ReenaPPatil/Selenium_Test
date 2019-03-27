package com.Vtiger.GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It provides libraries to get the data from .xls and .properties
 * @author Reena
 *
 */
public class FileLib {
	/**
	 * Get the key value from the commondata.properties file like url,username,password,browser
	 * @param key
	 * @return value of the key
	 * @throws Throwable
	 */
	
	public String getPropertyKeyValue(String key) throws Throwable{
		FileInputStream fis=new FileInputStream(".//data//commondata.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;		
	}
	
	/**
	 * Get the data from Excel workbook based on user argument
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Throwable
	 */
	
	public String getExcelData(String sheetName,int rowNum,int colNum) throws Throwable{
		FileInputStream fis=new FileInputStream(".//data//testData.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet(sheetName);
				Row row=sh.getRow(rowNum);
				Cell cell=row.getCell(colNum);
				String data=cell.getStringCellValue();
				wb.close();
				return data;
	}
	
	/**
	 * Set the data back to Excel workbook based on user argument
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setExcelData(String sheetName,int rowNum,int colNum) throws Throwable{
		FileInputStream fis=new FileInputStream(".//data//testData.xlsx");
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet(sheetName);
				Row row=sh.getRow(rowNum);
				@SuppressWarnings("unused")
				Cell cell=row.getCell(colNum);
				FileOutputStream fos=new FileOutputStream(".//data//testData.xlsx");
				wb.write(fos);
				wb.close();
	}
	
}