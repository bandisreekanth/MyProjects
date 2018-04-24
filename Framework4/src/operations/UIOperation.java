package operations;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;

import operations.ReadObjectRepository;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import dataBaseTest.SelectDataBase;

public class UIOperation 
{
	WebDriver driver;
	DataInputStream dis;
	public UIOperation(WebDriver driver)
	{
		this.driver = driver;
	}
	@SuppressWarnings("deprecation")
	public void perform(ReadObjectRepository p,String operation,String objectName,String objectType,String value) throws Exception
	{
		//System.out.println("Object details are : "+operation+" , "+objectName+" , "+objectType+" , "+value);
		switch (operation.toUpperCase()) 
		{
			case "CLICK":
				//Perform click
				driver.findElement(this.getObject(p,objectName,objectType)).click();
				try
				{
				  Thread.sleep(1000);
				  Alert alert=driver.switchTo().alert();
				  String actual=alert.getText();
				  //System.out.println("actual is :"+actual);
				  alert.accept();
				  if(actual.contains(value))
				  {
					  System.out.println("Test Case Pass");
				  }
				  else
				  {
						System.out.println("TestCase Failed : Actual -"+actual+" , expected -"+value);
						throw new Exception("Actual and expected not matched");

				  }
				  //System.out.println("No Application number Found ");
				}
				catch(NoAlertPresentException e)
				{
					System.out.println("No Alert Present");
				}	
				break;
				
			case "MOUSEOVER":
				System.out.println("move to an element ");
				Actions a=new Actions(driver);
				//Thread.sleep(2000);	
				WebElement we=driver.findElement(this.getObject(p, objectName, objectType));
				a.moveToElement(we).build().perform();
				//Thread.sleep(2000);	
				break;
			
			case "SETTEXT":
				//Set text on control
				driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
				break;
			
			case "CLEAR":
				//Set text on control
				driver.findElement(this.getObject(p,objectName,objectType)).clear();
				break;			
		
			case "GOTOURL":
				//Get url of application
				driver.get(p.getObjectRepository_Excel(value));
				break;
			
			case "GETTEXT":
				//Get text of an element
				String actual=driver.findElement(this.getObject(p,objectName,objectType)).getText();
				//System.out.println("actual :"+actual+":");
				//System.out.println("actual :"+value+":");

				if(actual.equals(value))
				{
					System.out.println("TestCase Pass");
				}
				else
				{
					System.out.println("TestCase Failed : Actual -"+actual+" , expected -"+value);
					throw new Exception("Actual and expected not matched");
				}
				break;
			
			case "SETCAPTCHA":
				// Captcha handling
				Thread.sleep(1000);
				dis=new DataInputStream(System.in);
				System.out.println("Enter the captcha");
				String s=dis.readLine();
				driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(s);
				break;
				
			case "GETATTRIB":
				//Get text of an element
				actual=driver.findElement(this.getObject(p,objectName,objectType)).getAttribute("value");			
				if(actual.equals(value))
				{
					System.out.println("TestCase Pass");
				}
				else
				{
					System.out.println("TestCase Failed");
					throw new Exception("Actual and expected not matched");
				}
				break;
			
			case "CLOSE":
				//Close the browser
				driver.close();
				break;
			
			case "SELECTDD":
				//Select the element in Drop Down List
				Select dd=new Select(driver.findElement(this.getObject(p,objectName,objectType)));
				List<WebElement> ele=dd.getOptions();
				if(ele.size()!=0)
				{	
					dd.selectByIndex(Integer.parseInt(value));
					Thread.sleep(2000);
				}
				else
				{
					System.out.println("The specified value not present");
				}
				System.out.println("No.of values in dropdown list is :"+ele.size());			
				try
				{
					driver.switchTo().alert().accept();
					System.out.println("No Application number Found ");
				}
				catch(NoAlertPresentException e)
				{
					System.out.println("Application Number Found ");
				}
				break;
				
			case "SELECTDDT":
				//Select the element in Drop Down List
				Select dd1=new Select(driver.findElement(this.getObject(p,objectName,objectType)));
				List<WebElement> ele1=dd1.getOptions();
				if(ele1.size()!=0)
				{	
					dd1.selectByVisibleText(value);
					//dd1.selectByIndex(Integer.parseInt(value));
					Thread.sleep(2000);
				}
				else
				{
					System.out.println("The specified value not present");
				}
				System.out.println("No.of values in dropdown list is :"+ele1.size());			
				try
				{
					driver.switchTo().alert().accept();
					System.out.println("No Application number Found ");
				}
				catch(NoAlertPresentException e)
				{
					System.out.println("Application Number Found ");
				}
				break;
			
			case "RADIO":
				//Select the element in Radio button
				List<WebElement> radio1=driver.findElements(this.getObject(p,objectName,objectType));
				boolean check_radio=radio1.get(Integer.parseInt(value)).isSelected();
				if(check_radio)
				{
					radio1.get(1).click();
				}
				else
				{
					radio1.get(0).click();
				}
				break;
				
			case "FILEUPLOAD":
				
				 StringSelection sel = new StringSelection(System.getProperty("user.dir")+value);
				 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
				 Thread.sleep(2000);				 
				 driver.findElement(this.getObject(p,objectName,objectType)).click();
				// Create object of Robot class
				 Robot robot = new Robot();
				 Thread.sleep(1000);
				      
				// Press Enter
				 robot.keyPress(KeyEvent.VK_ENTER);
				 
				// Release Enter
				 robot.keyRelease(KeyEvent.VK_ENTER);
				 
				// Press CTRL+V
				 robot.keyPress(KeyEvent.VK_CONTROL);
				 robot.keyPress(KeyEvent.VK_V);
				 
				// Release CTRL+V
				 robot.keyRelease(KeyEvent.VK_CONTROL);
				 robot.keyRelease(KeyEvent.VK_V);
				 Thread.sleep(1000);
				        
			    // Press Enter 
				 robot.keyPress(KeyEvent.VK_ENTER);
				 robot.keyRelease(KeyEvent.VK_ENTER);
				 break;
			case "SELECT_DB":
				SelectDataBase sdb=new SelectDataBase();
				value=sdb.select_db(value);
				driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
				break;

			default:
				break;
		}
	}
	private By getObject(ReadObjectRepository p,String objectName,String objectType) throws Exception
	{
			//Find by xpath
    		if(objectType.equalsIgnoreCase("XPATH"))
    		{
				return By.xpath(p.getObjectRepository_Excel(objectName));
			}	
			//find by id
			else if(objectType.equalsIgnoreCase("ID"))
			{	
				return By.id(p.getObjectRepository_Excel(objectName));				
			}
    		//find by class
			else if(objectType.equalsIgnoreCase("CLASSNAME"))
			{	
				return By.className(p.getObjectRepository_Excel(objectName));	
			}    		
			//find by name
			else if(objectType.equalsIgnoreCase("NAME"))
			{	
				return By.name(p.getObjectRepository_Excel(objectName));	
			}
			//Find by css
			else if(objectType.equalsIgnoreCase("CSSSELECTOR"))
			{
				return By.cssSelector(p.getObjectRepository_Excel(objectName));	
			}
			//find by link
			else if(objectType.equalsIgnoreCase("LINKTEXT"))
			{	
				return By.linkText(p.getObjectRepository_Excel(objectName));	
			}
			//find by partial link
			else if(objectType.equalsIgnoreCase("PARTIALLINKTEXT"))
			{	
				return By.partialLinkText(p.getObjectRepository_Excel(objectName));	
			}
    		//No Element locator found
			else
			{
				throw new Exception(" Wrong Element Locator ");
			}
	}
}
