package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@Test
public class InstallApk extends DesiredCapsCommon{

	//AppiumDriver<MobileElement> driver;
	
	public void tc1() throws MalformedURLException{
	 
		
/*	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	cap.setCapability("platformVersion", "10");
	cap.setCapability("deviceName", "Note9");
	cap.setCapability(MobileCapabilityType.APP, "/home/summi/Desktop/Summi/apk's/GPS Test.apk");
	
	URL url = new URL("http://127.0.0.1:4723/wd/hub");
	
	driver = new AndroidDriver<MobileElement>(url, cap);*/
	 System.out.println("Executed");
	
	}
	
}
