
import java.io.DataInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Login_Captcha {
	WebDriver driver;
	DataInputStream dis;
	 @Test(priority=1)
	  public void tc001_capcha_verificaton() throws InterruptedException, IOException
	  {
		try
		{
			login();
			String home_value=driver.findElement(By.xpath(".//*[@id='left']/div/div[2]/div/h5")).getText();
			Assert.assertEquals(home_value, "Welcome");
			Reporter.log("Entered the valid captcha");
	    }
		catch(UnhandledAlertException e)
		{
			Reporter.log("Entered the invalid captcha");
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			driver.close();
			System.out.println("You entered the wrong captcha, Please re-enter Captcha");
			tc001_capcha_verificaton();
		}
	  }
	  public void login() throws InterruptedException, IOException
	  {
		    System.setProperty("webdriver.chrome.driver","D:/Sreekanth_tools/Browser drivers/chromedriver_win32/chromedriver.exe");
		    driver=new ChromeDriver();	 
		    driver.get("http://dev.kdms.in/ICICISHG/frmLogin.aspx");
		    driver.findElement(By.name("txtUserName")).sendKeys("admin");
		    Thread.sleep(1000);
			driver.findElement(By.name("txtPassword")).sendKeys("karvy@123#");
			Thread.sleep(1000);
			dis=new DataInputStream(System.in);
			System.out.println("Enter the captcha");
			@SuppressWarnings("deprecation")
			String s=dis.readLine();
			driver.findElement(By.name("captchaTextBox")).sendKeys(s);
			driver.findElement(By.name("btnSignin")).click();
	  }
}
