

import java.io.DataInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TS02_Login_Verification {
	  WebDriver driver;
	  DataInputStream dis;
	  @Test(priority=5)
	  public void tc005_valid_Login() throws InterruptedException, IOException
	  {
		    System.setProperty("webdriver.chrome.driver","D:/Sreekanth_tools/Browser drivers/chromedriver_win32/chromedriver.exe");
			driver=new ChromeDriver();	 
			driver.get("http://dev.kdms.in/ICICISHG/frmLogin.aspx");
		    driver.findElement(By.name("txtUserName")).sendKeys("admin");
			driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			Thread.sleep(1000);
			driver.findElement(By.name("txtPassword")).sendKeys("karvy@123#");
			Thread.sleep(1000);
			dis=new DataInputStream(System.in);
			System.out.println("Enter the captcha");
			@SuppressWarnings("deprecation")
			String s=dis.readLine();
			driver.findElement(By.name("captchaTextBox")).sendKeys(s);
			Thread.sleep(2000);
			driver.findElement(By.name("btnSignin")).click();
			String home_value=driver.findElement(By.xpath(".//*[@id='left']/div/div[2]/div/h5")).getText();
			Assert.assertEquals(home_value, "Welcome");
		    Reporter.log("Verified the valid Login functionality of the Application");
	  } 
	  @Test(priority=6)
	  public void tc006_verify_Links()
	  {
		  String dashboard_link=driver.findElement(By.xpath(".//*[@id='menu']/li[3]/a")).getText();
		  Assert.assertEquals(dashboard_link," Dashboard");
		  Reporter.log("Verified the Dashboard Link ");
		  String transactions_link=driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).getText();
		  Assert.assertEquals(transactions_link," Transactions");
		  Reporter.log("Verified the Transactions Link ");
		  String control_center_link=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a/span[1]")).getText();
		  Assert.assertEquals(control_center_link," Control Center");
		  Reporter.log("Verified the Control Center Link ");
		  String reporter_link=driver.findElement(By.xpath(".//*[@id='lnkreports']/a/span[1]")).getText();
		  Assert.assertEquals(reporter_link," Reports");
		  Reporter.log("Verified the Reporter Link ");
		  String query_link=driver.findElement(By.xpath(".//*[@id='lnkQuery']/a/span")).getText();
		  Assert.assertEquals(query_link," Query");
		  Reporter.log("Verified the Query Link ");	  
	  }
	  @AfterClass
	  public void close()
	  {	
			driver.close();
		  	Reporter.log("Browser closed ");
	  }
}
