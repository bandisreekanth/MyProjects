import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TS03_Transactions_Verfication extends Login_Captcha{

/*	@Test(priority=7)
	  public void tc007_verify_transaction_link() {
		  String x=driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).getText();
		  Assert.assertEquals(x," Transactions");
		  Reporter.log("Verified the Transactions Link");
	  }*/
	  @Test(priority=8)
	  public void tc008_verify_browserUpload_link() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[1]/a")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Upload Your Documents");
		  Reporter.log("Verified the Browser Upload Link");
	  }
	  @Test(priority=9)
	  public void tc009_verify_dataEntry_link() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Data Entry");
		  Reporter.log("Verified the Data Entry Link");
	  }
	  @Test(priority=10)
	  public void tc010_verify_priorityForms_link() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[3]/a")).click();	  												
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div[1]/div/div[1]/div[1]/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Priority Forms");
		  Reporter.log("Verified the Priority Forms Link");
	  }
 	
}
