package UtilityPackage;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class UtilClass  {
	
	
	public  String [][] getDataFromExcel() throws IOException{
		
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Darsh\\Desktop\\UltaLoginCredentials.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		System.out.println(workbook.getNumberOfSheets());
		System.out.println(	workbook.getSheetName(0));
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowNum=	sheet.getPhysicalNumberOfRows();
		int colNum=sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rowNum+"   "+colNum);
		String[] [] obj=new String[rowNum][colNum];
		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++) {
			Cell c1=sheet.getRow(i).getCell(j);		
			obj[i][j]=c1.getStringCellValue();
			
			System.out.println(c1.getStringCellValue());
			}
			
		}
	
		return  obj;
	}
	
	
	public void screenShot(WebDriver driver) throws IOException {
		LocalDateTime myDateObj = LocalDateTime.now();
	  // System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
	    String formattedDate = myDateObj.format(myFormatObj);
	   // System.out.println("After formatting: " + formattedDate);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Darsh\\eclipse-workspace\\HybridFramework\\Screenshots\\"+formattedDate+"m.png"));
		
	}
	
	
}

