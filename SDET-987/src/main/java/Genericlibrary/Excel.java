package Genericlibrary;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	/**
	    * used to read the data from excel workook based on
	    * @param shettName
	    * @param rowNum
	    * @param colNum
	    * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	    */
		
		String filePath = "./testData/TestData.xlsx";
		
		public String getExcelData(String shettName , int rowNum , int colNum) throws Throwable {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(shettName);
			Row row = sh.getRow(rowNum);
			wb.close();
			return row.getCell(colNum).getStringCellValue();
		}				
}
