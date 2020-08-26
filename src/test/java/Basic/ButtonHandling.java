package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ButtonHandling {
	
	AppiumDriver<WebElement> driver;
	@Test
	public void test() throws MalformedURLException, InterruptedException{
		button();
		
	}
	
	public void button() throws MalformedURLException, InterruptedException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    	cap.setCapability("deviceName", "Note9");
    	cap.setCapability("app", "/home/summi/Desktop/Summi/apk's/APIDemo.apk");
    	
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver<WebElement>(url, cap); 
    	Thread.sleep(3000);
    	
    	WebElement demo = driver.findElements(By.id("android:id/text1")).get(1);
    	demo.click();
    	Thread.sleep(1000);
    	driver.findElementByAccessibilityId("Views").click();
    	driver.findElementByName("Controls").click();
    	driver.findElementByAccessibilityId("02. Dark Theme").click();
    	
    	
    	}
}
