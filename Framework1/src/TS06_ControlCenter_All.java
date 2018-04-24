import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TS06_ControlCenter_All extends TS05_ControlCenter_Verification{
	@Test(priority=21)
	public void tc021_usercreation_actions() throws InterruptedException
	{
		  driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[5]/ul/li[1]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div[1]/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "User Creation");
		  Select users_list=new Select(driver.findElement(By.id("ddlUsersList")));
		  List<WebElement> element=users_list.getOptions();
		  if(element.size()!=0)
		  {
			  Reporter.log("Verified the Users List");
		  }

		  String user_id_label=driver.findElement(By.xpath(".//*[@id='lblUserid']")).getText();
		  Assert.assertEquals(user_id_label, "User Id");
		  Reporter.log("Verified the User Id field");
		  
		  String user_name_label=driver.findElement(By.xpath(".//*[@id='lblname']")).getText();
		  Assert.assertEquals(user_name_label, "User Name");
		  Reporter.log("Verified User Name field");

		  String email_label=driver.findElement(By.xpath(".//*[@id='lblEmail']")).getText();
		  Assert.assertEquals(email_label, "Email");
		  Reporter.log("Verified the Email field");
		  
		  Select role_list=new Select(driver.findElement(By.id("ddlRole")));
		  List<WebElement> role_element=role_list.getOptions();
		  if(role_element.size()!=0)
		  {
			  Reporter.log("Verified the Role List field");
		  }

		  Select branch_list=new Select(driver.findElement(By.id("ddlBranch")));
		  List<WebElement> branch_element=branch_list.getOptions();
		  if(branch_element.size()!=0)
		  {
			  Reporter.log("Verified the Branch List field");
		  }
		  
		  String status_label=driver.findElement(By.xpath(".//*[@id='lblStatus']")).getText();
		  Assert.assertEquals(status_label, "Status");
		  Reporter.log("Verified the Status field");  

		  String user_picture_label=driver.findElement(By.xpath(".//*[@id='Label1']")).getText();
		  Assert.assertEquals(user_picture_label, "Select User Picture");
		  Reporter.log("Verified the 'Select user picture' Label");  

		  String proceed_button=driver.findElement(By.xpath(".//*[@id='btnProceed']")).getAttribute("value");
		  Assert.assertEquals(proceed_button, "Proceed");
		  Reporter.log("Verified the proceed Button");  
	}
	@Test(priority=22)
	public void tc022_changePassword_actions() throws InterruptedException
	{
		  driver.findElement(By.xpath(".//*[@id='menu']/li[5]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[5]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div/div[1]/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Change Password");		  
	
		  String change_pwd_label=driver.findElement(By.xpath(".//*[@id='lblOldcpwd']")).getText();
		  Assert.assertEquals(change_pwd_label, "Old Password");
		  Reporter.log("Verifed the Old Password field");
		  
		  String change_newpwd_label=driver.findElement(By.xpath(".//*[@id='lblNewPwd']")).getText();
		  Assert.assertEquals(change_newpwd_label, "New Password");
		  Reporter.log("Verified the New Password field");
	
		  String confirm_pwd_label=driver.findElement(By.xpath(".//*[@id='lblConfirmpwd']")).getText();
		  Assert.assertEquals(confirm_pwd_label, "Confirm Password");
		  Reporter.log("Verified the Confirm Password field");
	
		  String proceed_button=driver.findElement(By.xpath(".//*[@id='btnProceed']")).getAttribute("value");
		  Assert.assertEquals(proceed_button, "Change");
		  Reporter.log("Verified the 'Change' button");  

	}
	  @AfterClass
	  public void close()
	  {	
			driver.close();
		  	Reporter.log("Browser closed ");
	  }
}
