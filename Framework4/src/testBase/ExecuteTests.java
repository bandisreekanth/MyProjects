package testBase;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import excelReaderWriter.ReadExcelFile;
import operations.ReadObjectRepository;
import operations.UIOperation;
import excelReaderWriter.WriteExcelFile;
import browserDriver.SelectBrowser;

public class ExecuteTests extends BaseTest
{    
	
  String filepath=System.getProperty("user.dir")+"\\src\\screenShots\\";	  
  private WebDriver driver;
  public String sheetName="Smoke";		 
  @Test(priority=1)
  public void testCase() throws Exception 
  {
//	  test = rep.startTest(testName);// Start this test
//	  test.log(LogStatus.INFO," Starting the application to test ");
	  ReadExcelFile ref=new ReadExcelFile();
	  WriteExcelFile wef=new WriteExcelFile();
	  ReadObjectRepository ror=new ReadObjectRepository();
	  SelectBrowser browser=new SelectBrowser(driver);
	 // Select the browser from the set of browsers
	  driver=browser.getBrowser();
	  UIOperation ope=new UIOperation(driver);
	  Sheet sh=ref.readExcel(System.getProperty("user.dir")+"\\src\\testData\\","TestCase.xlsx" , sheetName);
	  int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
	  //Create a loop over all the rows of excel file to read it
	  int tc_num=0;
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
  			test.log(LogStatus.INFO,row.getCell(1).toString()+"--"+row.getCell(2).toString()+"----"+
  		  	row.getCell(3).toString()+"----"+ row.getCell(4).toString() );
  			
  			//Call perform function to perform operation on UI
            try 
            {
            	ope.perform(ror, row.getCell(2).toString(), row.getCell(3).toString(),row.getCell(4).toString(), row.getCell(5).toString());
                wef.writeExel(System.getProperty("user.dir")+"\\src\\testData\\","TestCase.xlsx" ,sheetName,row.getRowNum(),"Pass");              
                test.log(LogStatus.PASS,"PASS");
                takeScreenshot("ScreenShot_"+row.getRowNum());	
    			
             }
            catch(Exception e)
            {
      			
            	e.printStackTrace();
            	wef.writeExel(System.getProperty("user.dir")+"\\src\\testData\\","TestCase.xlsx" ,sheetName,row.getRowNum(),"Fail - "+e.getMessage());
            	test.log(LogStatus.FAIL,"FAIL");
            	takeScreenshot("ScreenShot_"+row.getRowNum());
            }
  	    }
  		else
  		{
  			
  			test = rep.startTest(row.getCell(1).toString());
			test.log(LogStatus.INFO," Starting the Test Case ");
  
  	       	//Print the new  testcase name when it started
  			System.out.println("New Testcase->"+row.getCell(1).toString() +" Started");
  			wef.writeExel(System.getProperty("user.dir")+"\\src\\testData\\","TestCase.xlsx" , sheetName,row.getRowNum(),"New TC Started");
  			Reporter.log(" Test Case "+tc_num+" : "+row.getCell(1).toString()+" - Passed");
  			tc_num++;
  			test.log(LogStatus.INFO," Test Case "+tc_num+" : "+row.getCell(1).toString()+" - Started" );
  		}
  	   }
  	   else
  	   {
 			wef.writeExel(System.getProperty("user.dir")+"\\src\\testData\\","TestCase.xlsx" ,sheetName,row.getRowNum(),"New Module Started");			  
  	   }
  	  }
  	  driver.close();
   }
   public void takeScreenshot(String name)
   {
	    Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String path=filepath+screenshotFile;
		//take screenshot
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//embed it in the reports
		test.log(LogStatus.INFO,test.addScreenCapture(path));
	   
	}
}		