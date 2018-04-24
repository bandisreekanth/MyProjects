package testUtils;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import excelReaderWriter.ReadExcelFile;
import operations.ObjectRead;
import operations.UIOperation;
import excelReaderWriter.WriteExcelFile;

public class ExecuteTests 
{
  static WebDriver driver;
  public static void main(String args[]) throws Exception 
  {
	  ReadExcelFile ref=new ReadExcelFile();
	  WriteExcelFile wef=new WriteExcelFile();
	  ObjectRead obj=new ObjectRead();
      Properties allObjects = obj.getObjectRepository();
      
      // Select the type of the browser from properties file
      String select_browser=allObjects.getProperty("browser_type");
	  //System.out.println(select_browser);
	  
	  // browser type is chrome or firefox or ie
	  if(select_browser.equalsIgnoreCase("chrome"))
	  {
			System.setProperty("webdriver.chrome.driver","D:/Sreekanth_tools/Browser drivers/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver();
	  }
	  else if(select_browser.equalsIgnoreCase("firefox"))
	  {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
	  }
	  else if(select_browser.equalsIgnoreCase("ie"))
	  {
			 System.setProperty("webdriver.ie.driver","D:/Sreekanth_tools/Browser drivers/IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
	  }
	  
	  UIOperation ope=new UIOperation(driver);
	  Sheet sh=ref.readExcel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "Sheet2");
	  int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
	  System.out.println(sh.getLastRowNum());
	  System.out.println(sh.getFirstRowNum());
	  
	  System.out.println("No.of Rows are :"+rowCount);
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
  			Thread.sleep(100);
  			//Print testcase detail on console
  			System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
  			row.getCell(3).toString()+"----"+ row.getCell(4).toString());
  			//Call perform function to perform operation on UI
            try 
            {
            	ope.perform(allObjects, row.getCell(2).toString(), row.getCell(3).toString(),row.getCell(4).toString(), row.getCell(5).toString());
                wef.writeExel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "Sheet2",row.getRowNum(),"Pass");

            }
            catch(Exception e)
            {
            	e.printStackTrace();
            	wef.writeExel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "Sheet2",row.getRowNum(),"Fail - "+e.getMessage());
            }
  	    }
  		else
  		{
  			//Print the new  testcase name when it started
  			System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
  			wef.writeExel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "Sheet2",row.getRowNum(),"New TC Started");
  		}
  		}
  		else
  		{
 			wef.writeExel(System.getProperty("user.dir")+"\\","TestCase.xlsx" , "Sheet1",row.getRowNum(),"New Module Started");			  
  		}
  	  }
   }
 
}
