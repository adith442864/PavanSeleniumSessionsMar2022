package SeleniumSessions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream("./src/test/resources/testdata/testdata.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		
		//write data into sheet
		/*
		for(int rows=0; rows<=5; rows++) {
			
			XSSFRow row = sheet.createRow(rows);
			
			for(int cols=0; cols<3; cols++) {
				XSSFCell cell = row.createCell(cols);
				cell.setCellValue("welcome");
			}
		}*/
		
		//[0][0] [0][1] [0][2]
		sheet.createRow(0).createCell(0).setCellValue(1234.00);
		sheet.createRow(0).createCell(1).setCellValue("Tom");
		//sheet.createRow(0).createCell(2).setCellValue("QA Manager");
		
		
		sheet.createRow(1).createCell(0).setCellValue(2345.00);
		sheet.createRow(1).createCell(1).setCellValue("Scott");
		//sheet.createRow(1).createCell(2).setCellValue("QA Director");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		
		
		
		

	}

}
