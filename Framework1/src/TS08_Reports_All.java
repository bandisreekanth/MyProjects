
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TS08_Reports_All extends Login_Captcha{
	
	@Test(priority=27)
	public void ts027_MIS_reports_actions() throws InterruptedException
	{
       	  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/ul/li[1]/a")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "MIS Report");
		  driver.findElement(By.xpath(".//*[@id='txtfromdate']")).clear();
		  driver.findElement(By.xpath(".//*[@id='txtfromdate']")).sendKeys("10122016");
		  Reporter.log("From Date Selected from MIS Report ");
		  driver.findElement(By.xpath(".//*[@id='txttodate']")).clear();
		  driver.findElement(By.xpath(".//*[@id='txttodate']")).sendKeys("11122016");
		  Reporter.log("To Date Selected from MIS Report ");
		  driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		  Reporter.log("Clicked on Submit Button ");	  
	}
	@Test(priority=28)
	public void ts028_employeePeformance_Reports_actions() throws InterruptedException
	{
	   	  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div[1]/div[1]/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Employee Performance");
		  driver.findElement(By.xpath(".//*[@id='txtFrDt']")).clear();
		  driver.findElement(By.xpath(".//*[@id='txtFrDt']")).sendKeys("10122016");
		  Reporter.log("From Date Selected from Employee Performance Report ");
		  driver.findElement(By.xpath(".//*[@id='txtToDate']")).clear();
		  driver.findElement(By.xpath(".//*[@id='txtToDate']")).sendKeys("11122016");
		  Reporter.log("To Date Selected from Employee Performance Report ");
		  driver.findElement(By.xpath(".//*[@id='btnView']")).click();
		  Reporter.log("Click on View Button ");	
	
	}
	@Test(priority=29)
	public void ts029_statusConsole_Reports_actions() throws InterruptedException
	{
		  driver.findElement(By.xpath(".//*[@id='Header_lnkreports']/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/ul/li[3]/a")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Status Console");
		  driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_txtfromdate']")).clear();
		  driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_txtfromdate']")).sendKeys("10122016");
		  Reporter.log("From Date Selected from Status Console Report ");
		  driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_txttodate']")).clear();
		  driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_txttodate']")).sendKeys("11122016");
		  Reporter.log("To Date Selected from Status Console Report ");
		  driver.findElement(By.xpath(".//*[@id='ContentPlaceHolder1_btnView']")).click();
		  Reporter.log("Clicked on View Button ");
			
		  /*  List<WebElement> Table_rows=driver.findElements(By.xpath(".//*[@id='content']/div[1]/div/div/div/div/div/div/table/tbody/tr"));
		  System.out.println("No.of Table rows : "+Table_rows.size());
		  for(int i=1;i<=Table_rows.size();i++)
		  {
			  String x=".//*[@id='content']/div[1]/div/div/div/div/div/div/table/tbody/tr["+i+"]/td";
			  List<WebElement> Table_cols=driver.findElements(By.xpath(x));
			  System.out.println("No.of Columns in "+i+" th row is :"+Table_cols.size());
			  for(int j=1;j<=Table_cols.size();j++)
			  {
				  String y=".//*[@id='ContentPlaceHolder1_DatagridBranch']/tbody/tr["+i+"]/td["+j+"]";
				  System.out.println(driver.findElement(By.xpath(y)).getText());
			  }
		  }*/
	}
	  @AfterClass
	  public void close()
	  {	
			driver.close();
		  	Reporter.log("Browser closed ");
	  }
}
