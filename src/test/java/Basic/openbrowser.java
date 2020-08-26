package Basic;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
@Test
public class openbrowser {
	
	static AppiumDriver<MobileElement> driver;
	
	@BeforeSuite
	
	public void setup() {
		  System.setProperty("webdriver.chrome.driver", "/home/summi/workspace/Appium/src/test/res/Driver/chromedriver");		
		  }
	
	public static void first() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		tc();
		
	}

	@Test(enabled = false)
	
	private static void tc() throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		//caps.setCapability("uDID", "215b8318a80d7ece");
		caps.setCapability("deviceNAme", "Note9");
		caps.setCapability(CapabilityType.BROWSER_NAME ,"Chrome");
		//caps.setCapability(MobileCapabilityType.FORCE_MJSONWP, true);
		//caps.setCapability("w3c", false);
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("w3c", false);
		caps.merge(opt);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url , caps);
		driver.get("https://www.google.com");
		
		System.out.println("Chrome started ...");
		
		
	}

}
