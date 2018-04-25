package testBase;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import excelReaderWriter.ReadExcelFile;
import excelReaderWriter.SheetCount;
import operations.ReadObjectRepository;
import operations.UIOperation;
import excelReaderWriter.WriteExcelFile;
import browserDriver.SelectBrowser;

public class ExecuteTests 
{ 
  private static final String FILENAME =System.getProperty("user.dir")+"\\Report.txt";
  static int pass_count=0,fail_count=0;	
  String filepath=System.getProperty("user.dir")+"\\screenShots\\";	
  //String filepath1=System.getProperty("user.dir")+"\\src\\screenShots\\Fail\\";
  //String filepath2=System.getProperty("user.dir")+"\\src\\screenShots\\Pass\\";	  
  private WebDriver driver;
  public void start_tc(String workbookName,String sheetName) throws Exception 
  {
	  ReadExcelFile ref=new ReadExcelFile();
	  WriteExcelFile wef=new WriteExcelFile();
	  ReadObjectRepository ror=new ReadObjectRepository();
	  SelectBrowser browser=new SelectBrowser(driver);
	 // Select the browser from the set of browsers
	  driver=browser.getBrowser();
	  UIOperation ope=new UIOperation(driver);
	  Sheet sh=ref.readExcel(System.getProperty("user.dir")+"\\",workbookName , sheetName);
	  int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
	  //Create a loop over all the rows of excel file to read it
	  for (int i = 1; i < rowCount+1; i++) 
  	  {
  		//Loop over all the rows
  		Row row = sh.getRow(i);
  		//Check if the first cell contain a value, if yes, That means it is the new testcase name
  		if(row.getCell(0).toString().length()==0)
  		{	
  		 if(row.getCell(1).toString().length()==0)
  		 {
  			Thread.sleep(1000);
  			//Print testcase detail on console
  			System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
  			row.getCell(3).toString()+"----"+ row.getCell(4).toString());
  			//Call perform function to perform operation on UI
            try 
            {
            	ope.perform(ror, row.getCell(2).toString(), row.getCell(3).toString(),row.getCell(4).toString(), row.getCell(5).toString());
                wef.writeExel(System.getProperty("user.dir")+"\\",workbookName ,sheetName,row.getRowNum(),"Pass");
                pass_count++;
                //takeScreenshot("ScreenShot_"+row.getRowNum(),filepath2);
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            	wef.writeExel(System.getProperty("user.dir")+"\\",workbookName, sheetName,row.getRowNum(),"Fail - "+e.getMessage());
            	fail_count++;
            	//takeScreenshot("ScreenShot_"+row.getRowNum(),filepath1);
            	takeScreenshot("ScreenShot_"+sheetName+"_"+row.getRowNum());	
            }
  	    }
  		else
  		{
  			//Print the new  testcase name when it started
  			System.out.println("New Testcase->"+row.getCell(1).toString() +" Started");
  			wef.writeExel(System.getProperty("user.dir")+"\\",workbookName , sheetName,row.getRowNum(),"New TC Started");
  		}
  	   }
  	   else
  	   {
 			wef.writeExel(System.getProperty("user.dir")+"\\",workbookName , sheetName,row.getRowNum(),"New Module Started");			  
  	   }
  	  }
   }
   public void takeScreenshot(String name)
   {
	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   //The below method will save the screen shot in d drive with test method name 
       try 
       {
				FileUtils.copyFile(scrFile, new File(filepath+name+".png"));
				System.out.println("***Placed screen shot in "+filepath+" ***");
       } 
       catch (IOException e) 
       {
				e.printStackTrace();
       }
	}
   public static void main(String args[]) throws Exception
   {
	   ReadObjectRepository ror=new ReadObjectRepository();
	   ExecuteTests et=new ExecuteTests();
	   SheetCount sc=new SheetCount();
	   System.out.println("Excel file name is : "+args[0]);
	   ror.setWorkBook(args[0]);
	   int count=sc.count_sheet(System.getProperty("user.dir")+"\\",args[0]);
	   for(int i=1;i<count;i++)
	   {
		  String sn=sc.SheetName(i);
		   et.start_tc(args[0],sn);
	   }
	   
	   
	    BufferedWriter bw = null;
		FileWriter fw = null;
		try 
		{
			String content = "  Total number Steps : "+(pass_count+fail_count)+
					"\r\n  No.of Test Cases Passed :"+pass_count+
					"\r\n  No.of Test Cases Failed :"+fail_count;
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("\n Status Report is genertated in 'Report.txt'  file in the current folder....");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		bw.close();
		fw.close();
	}
}		