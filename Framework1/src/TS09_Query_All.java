import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TS09_Query_All extends Login_Captcha {
	  @Test(priority=30)
	  public void ts030_verify_query()
	  {
		  
		    driver.findElement(By.xpath(".//*[@id='lnkQuery']/a/span")).click();
		    Reporter.log("Clicked on Query Link ");
		  
		    String query_text=driver.findElement(By.xpath("html/body/form/div[5]/div[1]/div/div/div/div/div/header/h5")).getText();
		    Assert.assertEquals(query_text,"Query");
		    Reporter.log("Redirect to Query page ");
		  
		    String AppNum_label=driver.findElement(By.xpath(".//*[@id='rbtnlist']/tbody/tr/td[1]/span/label")).getText();
		    Assert.assertEquals(AppNum_label,"App Number");
		    Reporter.log("Verified the App Number Radio button ");

		    String ApsID_label=driver.findElement(By.xpath(".//*[@id='rbtnlist']/tbody/tr/td[2]/span/label")).getText();
		    Assert.assertEquals(ApsID_label,"APS ID");
		    Reporter.log("Verified the APS ID Radio button ");
		    
		    String submit_label=driver.findElement(By.xpath(".//*[@id='btnSubmit']")).getAttribute("value");
		    Assert.assertEquals(submit_label,"Submit");
		    Reporter.log("Verified the Submit button ");
	
	  }
	  @AfterClass
	  public void close()
	  {	
			driver.close();
		  	Reporter.log("Browser closed ");
	  }

}
