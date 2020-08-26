package tests;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@Test
public class BaseClass {

	AppiumDriver< MobileElement> driver;
	
	@BeforeTest
	public void setup() throws Exception{
		try{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		//caps.setCapability(MobileCapabilityType.UDID, "24451b08100d7ece");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Note9");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		//caps.setCapability(MobileCapabilityType.APP, "");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("w3c", false);
		caps.merge(opt);
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>( url, caps);
		
/*		driver = new AndroidDriver<MobileElement>(url, caps);
		driver = new IOSDriver<MobileElement>(url, caps);
		*/
		}
		catch (Exception e) {
			System.out.println("cause is "+ e.getCause());
			System.out.println("msg is "+ e.getMessage());
			e.printStackTrace();
		
		}
	}
	
	
	@AfterTest
	public void teardown(){
		System.out.println("exit sample test");
		
	}
	
}
