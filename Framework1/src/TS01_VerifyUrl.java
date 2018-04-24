import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TS01_VerifyUrl {
	WebDriver driver;
	 @Test(priority=2)
	  public void tc002_URL_chrome() {
		  System.setProperty("webdriver.chrome.driver","D:/Selenium tools/chromedriver_win32/chromedriver.exe");
		  driver=new ChromeDriver();	 
		  driver.get("http://dev.kdms.in/ICICISHG/frmLogin.aspx");
		  String login_label=driver.findElement(By.xpath(".//*[@id='login']/p")).getText();
		  Assert.assertEquals(login_label, "Enter your username and password");
		  Reporter.log("Verified the URL of the ICICI SHG Application in Chrome Browser");
	  } 
	 @Test(priority=3)
	  public void tc003_URL_firefox() {
		  driver=new FirefoxDriver();	 
		  driver.get("http://dev.kdms.in/ICICISHG/frmLogin.aspx");
		  String login_label=driver.findElement(By.xpath(".//*[@id='login']/p")).getText();
		  Assert.assertEquals(login_label, "Enter your username and password");
		  Reporter.log("Verified the URL of the ICICI SHG Application in Firefox Browser");
	  }
	 @Test(priority=4)
	  public void tc004_URL_ie() {
	
		  System.setProperty("webdriver.ie.driver","D:/Sreekanth_tools/Browser drivers/IEDriverServer.exe");
		  driver=new InternetExplorerDriver();
		  driver.get("http://dev.kdms.in/ICICISHG/frmLogin.aspx");
		  String login_label=driver.findElement(By.xpath(".//*[@id='login']/p")).getText();
		  Assert.assertEquals(login_label, "Enter your username and password");
		  Reporter.log("Verifyied the URL of the ICICI SHG Application in IE Browser");
	  }
	 
	 @AfterMethod
	 public void close()
	 {
		 
		 driver.close();
		 Reporter.log("Browser closed ");
	 }
}
