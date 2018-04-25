package excelReaderWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SheetCount {
	File file;
	String fileName;
	int count;
	static Workbook wb = null;
	public int count_sheet(String filepath,String fileName) throws IOException
	{
		file =	new File(filepath+fileName);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		//Find the file extension by splitting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file or xls file
		if(fileExtensionName.equals(".xlsx"))
		{
			wb = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls"))
		{
			wb = new HSSFWorkbook(inputStream);
		}
		count=wb.getNumberOfSheets();
		System.out.println("No.of Sheets in the workbook :"+count);
		return count;
	}
	public String SheetName(int sheetNumber) throws IOException
	{
		String sn=wb.getSheetName(sheetNumber);
		System.out.println("sheet Name is : "+sn);	
		return sn;
	}
}
