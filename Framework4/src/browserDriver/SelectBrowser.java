package browserDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import operations.ReadObjectRepository;

public class SelectBrowser 
{
	WebDriver driver;
	public SelectBrowser(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebDriver getBrowser() throws IOException
	{
		ReadObjectRepository ror=new ReadObjectRepository();
		
		// Select the browser type from objectRepository
		String select_browser=ror.getObjectRepository_Excel("browser_type");
    	
		// browser type is chrome or firefox or ie
		if(select_browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/browserDriver/chromedriver.exe");
			//DesiredCapabilities capability = DesiredCapabilities.chrome();
			//capability.setCapability("chrome.binary", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		else if(select_browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/browserDriver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(select_browser.equalsIgnoreCase("ie"))
		{
			
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/browserDriver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		return driver;
	}

}
