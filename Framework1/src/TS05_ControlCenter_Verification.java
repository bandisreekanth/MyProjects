import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TS05_ControlCenter_Verification extends Login_Captcha
{	
	@Test (priority=18)
	public void tc018_verify_controlCenter_link() 
	{
		  String x=driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a/span[1]")).getText();
		  Assert.assertEquals(x, " Control Center");
		  Reporter.log("Verified the Control Center Link");
	}
	@Test(priority=19)
	public void tc019_verify_userCreation_link() throws InterruptedException
	{
		  driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[5]/ul/li[1]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div[1]/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "User Creation");
		  Reporter.log("Verified the User Creation Page Link");
	} 
	@Test(priority=20)
	public void tc020_verify_changePassword_link() throws InterruptedException
	{
		  driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[5]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div/div[1]/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Change Password");
		  Reporter.log("Verified the Change Password Page Link");
	}
	
}
