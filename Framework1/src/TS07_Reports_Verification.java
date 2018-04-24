import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TS07_Reports_Verification extends Login_Captcha {
	@Test(priority=23)
	public void tc023_verify_Reports_link()
	{
		  String x=driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/a/span[1]")).getText();
		  										
		  Assert.assertEquals(x," Reports");
		  Reporter.log("Verified the Reports Link");		   
	}
	
	@Test(priority=24)
	public void tc024_verify_MIS_Reports_Links() throws InterruptedException
	{
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/ul/li[1]/a")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "MIS Report");
       	  Reporter.log("Verified the MIS Reports Link");
	}
	
	@Test(priority=25)
	public void tc025_verify_EmployeePeformance_Reports_Links() throws InterruptedException
	{
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div[1]/div[1]/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Employee Performance");
	   	  Reporter.log("Verified the Employee Performance Reports Link");
			
	}
	@Test(priority=26)
	public void tc026_verify_StatusConsole_Reports_Links() throws InterruptedException
	{
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[6]/ul/li[3]/a")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Status Console");
		  Reporter.log("Verified the Status Console Reports Link");
		
	}	
	@AfterClass
	public void close()
	{	
			driver.close();
		  	Reporter.log("Browser closed ");
	}
}
