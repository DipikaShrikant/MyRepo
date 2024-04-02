package com.IT.MT.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		FileInputStream file= new FileInputStream("C:\\Users\\admin\\Documents\\ADipika\\ExcelFilesPractice\\MercuryTest.xlsx");
		
		XSSFWorkbook wb= new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++) {
				XSSFCell cell = row.getCell(j);
				int cellType = cell.getCellType();
				
				
				String cellValue = cell.getStringCellValue();
				System.out.println(cellValue);
				
			}
			
		}
		

	}

}
