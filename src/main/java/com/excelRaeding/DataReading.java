package com.excelRaeding;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReading {
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		File file= new File("C:\\Users\\COMTECH\\Documents\\Book1.xlsx");	
		Workbook wk= new XSSFWorkbook(file);
		Sheet sheet= wk.getSheet("Sheet1");
		for(int s=0;s<=sheet.getLastRowNum()-1;s++) {
		Row row= sheet.getRow(s);
		for (int i=0; i<=row.getLastCellNum()-1;i++) {
		Cell cell=  row.getCell(i);
		String sa= cell.getStringCellValue();
		System.out.print(sa+"   ");
		
		}
		System.out.println();
		}
		
	}
	public void dataReading() {
		
	}

}
