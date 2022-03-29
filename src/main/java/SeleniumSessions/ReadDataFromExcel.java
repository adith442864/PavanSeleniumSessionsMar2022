package SeleniumSessions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadDataFromExcel {
	
	private static String TEST_DATA_SHEET = "./src/test/resources/testdata/data.xlsx";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static void main(String[] args) throws IOException {
		
		FileInputStream file  = new FileInputStream(TEST_DATA_SHEET);
		
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum();
		System.out.println("No of rows is :" +rows); // 5 -->counting from 0
		
		//get no of cols:
		XSSFRow row = sheet.getRow(0);
		int cols = row.getLastCellNum();
		System.out.println("Number of cols :" +cols); // 4 --> counts from 1
		
		//get specific value from the cell
		System.out.println(sheet.getRow(2).getCell(0).toString());
		
		
		//for loop : to read all the data from the excel:
		for(int i=1; i<=rows; i++) { //1 2 3 4 5
			
			XSSFRow currentRow = sheet.getRow(i);
			
			for(int j=0; j<cols; j++) {
				XSSFCell  cell = currentRow.getCell(j);
				String data = cell.toString();
				System.out.print(data+"      ");
				
			}
			
			System.out.println();
		}
		
		
				

	}

}
