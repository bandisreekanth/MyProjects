package testBase;

import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import extentManager.ExtentManager;
public class BaseTest 
{
	public ExtentReports rep=ExtentManager.getInstance();//Making it public as it can be accessible in every package
	public ExtentTest test;		
	public String testName;


	@AfterTest
	public void quit()
	{
		if(rep!=null)
		{
			rep.endTest(test);
			rep.flush();
			// The above two lines are compulsory else reports will not be generated
		}
		
	}

}
