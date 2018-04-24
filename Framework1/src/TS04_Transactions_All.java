import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TS04_Transactions_All extends TS03_Transactions_Verfication{
	  @Test(priority=11)
	  public void ts011_browserUpload_actions() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[1]/a/i")).click();
		  String user_txt=driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Upload Your Documents");
		  Reporter.log("Clicked on Upload button('Browse Upload')and Chosen the file");
    	  String invalid_filePath="D:\\Sreekanth_Project\\ICICI_SHG_SRS.docx";
    	  driver.findElement(By.id("fileUpload")).sendKeys(invalid_filePath);
		  driver.findElement(By.id("btnUpload")).click();
       	  try{
    		  Thread.sleep(3000);
    		  driver.switchTo().alert().accept();
    		  Reporter.log("Invalid File Uploaded (Not .xlsx)");
    	  }
    	  catch(NoAlertPresentException e)
    	  {   
    		  Reporter.log("Uploaded the Valid File (.xlsx)");
    	  }
       	  String valid_filePath = "D:\\Sreekanth_Project\\SHGDATA.xlsx";
		  driver.findElement(By.id("fileUpload")).sendKeys(valid_filePath);
		  driver.findElement(By.id("btnUpload")).click();
		  Reporter.log("Uploaded the Valid File (.xlsx)");
	      Reporter.log("Clicked on Submit button ");    
 	  }
	  @Test(priority=12)
	  public void ts012_dataEntry_SHG() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Data Entry");
		  Select Product_type=new Select(driver.findElement(By.id("ddlproducttype")));
		  List<WebElement> element=Product_type.getOptions();
		  if(element.size()==4)
		  {
			  Reporter.log("Verfied the Product type (SHG, FE and KCC)");
		  }
	      Product_type.selectByVisibleText("Self Help Group");
		  Reporter.log("Product type selected as SHG"); 
		  Thread.sleep(2000);
		  try
		  {
			  driver.switchTo().alert().accept();
			  System.out.println("No application Number Present ");
		  }
		  catch(NoAlertPresentException e)
		  {
			  System.out.println("Application Number Present ");
		  }
		  Select App_num=new Select(driver.findElement(By.id("ddlAppno")));
		  List<WebElement> element1=App_num.getOptions();
		  if(element1.size()!=0)
		  {
			  Reporter.log("Selected an Application Number Field");
			  App_num.selectByIndex(1);
			  Reporter.log("Application Number Selected by the specified index value");
		  }
		  else
		  {
			  Reporter.log("Application Number not available");
		  }
	  }
	  @Test(priority=13)
	  public void ts013_dataEntry_FE() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Data Entry");
		  Select Product_type=new Select(driver.findElement(By.id("ddlproducttype")));
		  List<WebElement> element=Product_type.getOptions();
	      String prod_type=element.get(2).getText();
		  if(prod_type.equals("Field Equipment"))
		  {
				  Product_type.selectByVisibleText("Field Equipment");
				  Reporter.log("Product type selected as FE"); 
				  Thread.sleep(2000);
				  try
				  {
					  driver.switchTo().alert().accept();
					  System.out.println("No application Number Present ");
				  }
				  catch(NoAlertPresentException e)
				  {
					  System.out.println("Application Number Present ");
				  }
				  Select App_num=new Select(driver.findElement(By.id("ddlAppno")));
				  List<WebElement> element1=App_num.getOptions();
				  if(element1.size()!=0)
				  {
					  Reporter.log("Selected an Application Number Field");
					  App_num.selectByIndex(1);
					  Reporter.log("Application Number Selected by the specified index value");
				  }
				  else
				  {
					  Reporter.log("Application Number not available");
				  }
			  }
		  
	  }
	  @Test(priority=14)
	  public void ts014_dataEntry_KCC() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[2]/a")).click();
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div/div/div/div/div/div/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Data Entry");
		  Select Product_type=new Select(driver.findElement(By.id("ddlproducttype")));
		  List<WebElement> element=Product_type.getOptions();
	  	  String prod_type=element.get(3).getText();
	  	  if(prod_type.equals("Kissan Credit Cards"))
		  {
				  Product_type.selectByVisibleText("Kissan Credit Cards");
				  Reporter.log("Product type selected as KCC "); 
				  Thread.sleep(2000);
				  try
				  {
					  driver.switchTo().alert().accept();
					  System.out.println("No application Number Present ");
				  }
				  catch(NoAlertPresentException e)
				  {
					  System.out.println("Application Number Present ");
				  }
				  Select App_num=new Select(driver.findElement(By.id("ddlAppno")));
				  List<WebElement> element1=App_num.getOptions();
				  if(element1.size()!=0)
				  {
					  Reporter.log("Selected an Application Number Field");
					  App_num.selectByIndex(1);
					  Reporter.log("Application Number Selected by the specified index value");
				  }
				  else
				  {
					  Reporter.log("Application Number not available");
				  }
		  }
		  
	  }
	  @Test(priority=15)
	  public void tc015_priority_forms_SHG() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[3]/a")).click();	  												
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div[1]/div/div[1]/div[1]/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Priority Forms");
		  Select Product_type=new Select(driver.findElement(By.name("ddlprocuctType")));
		  List<WebElement> element=Product_type.getOptions();
		  if(element.size()==4)
		  {
			  Reporter.log("Verfied the Product type in Priority Forms (SHG,FE,KCC ");
		  }
		  Product_type.selectByVisibleText("Self Help Group");
		  Reporter.log("Product type selected as SHG in Priority Forms "); 
		  Thread.sleep(3000);
		  Select App_num=new Select(driver.findElement(By.id("ddlAppNumber")));
		  List<WebElement> element1=App_num.getOptions();
		  if(element1.size()!=0)
		  {
			  Reporter.log("Selected an Application Number Field");
			  App_num.selectByIndex(1);
			  Reporter.log("Application Number Selected by the specified index value");
		  }
		  else
		  {
			  Reporter.log("Application Number not available");
		  }
	  }
	
	  @Test(priority=16)
	  public void tc016_priority_forms_FE() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[3]/a")).click();	  												
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div[1]/div/div[1]/div[1]/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Priority Forms");
		  Select Product_type=new Select(driver.findElement(By.name("ddlprocuctType")));
		  List<WebElement> element=Product_type.getOptions();
		  if(element.size()==4)
		  {
			  Reporter.log("Verfied the Product type in Priority Forms (SHG,FE,KCC)");
		  }
		  Product_type.selectByVisibleText("Field Equipment");
		  Reporter.log("Product type selected as FE in Priority Forms "); 
		  Thread.sleep(3000);
		  Select App_num=new Select(driver.findElement(By.id("ddlAppNumber")));
		  List<WebElement> element1=App_num.getOptions();
		  if(element1.size()!=0)
		  {
			  Reporter.log("Selected an Application Number Field");
			  App_num.selectByIndex(1);
			  Reporter.log("Application Number Selected by the specified index value");
		  }
		  else
		  {
			  Reporter.log("Application Number not available");
		  }
	  }
	  @Test(priority=17)
	  public void tc017_priority_forms_KCC() throws InterruptedException
	  {
		  driver.findElement(By.xpath(".//*[@id='menu']/li[4]/a/span[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("html/body/form/div[4]/ul/li[4]/ul/li[3]/a")).click();	  												
		  String user_txt=driver.findElement(By.xpath("html/body/form/div[5]/div[1]/div/div[1]/div[1]/header/h5")).getText();
		  Assert.assertEquals(user_txt, "Priority Forms");
		  Select Product_type=new Select(driver.findElement(By.name("ddlprocuctType")));
		  List<WebElement> element=Product_type.getOptions();
		  if(element.size()==4)
		  {
			  Reporter.log("Verfied the Product type in Priority Forms (SHG,FE,KCC)");
		  }
		  Product_type.selectByVisibleText("Kissan Credit Cards");
		  Reporter.log("Product type selected as KCC in Priority Forms "); 
		  Thread.sleep(3000);
		  Select App_num=new Select(driver.findElement(By.id("ddlAppNumber")));
		  List<WebElement> element1=App_num.getOptions();
		  if(element1.size()!=0)
		  {
			  Reporter.log("Selected an Application Number Field");
			  App_num.selectByIndex(1);
			  Reporter.log("Application Number Selected by the specified index value");
		  }
		  else
		  {
			  Reporter.log("Application Number not available");
		  }
	  }
	  @AfterClass
	  public void close()
	  {	
			driver.close();
		  	Reporter.log("Browser closed ");
	  }
}
