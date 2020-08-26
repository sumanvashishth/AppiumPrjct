package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DialANum {
	
	AppiumDriver<MobileElement> driver;
	
	@Test
	public void tc() throws MalformedURLException, InterruptedException{
		dial();
		Thread.sleep(3000);
	}
	
	public void dial() throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    	cap.setCapability("deviceName", "Note9");
		cap.setCapability("appPackage", "com.samsung.android.dialer");
		cap.setCapability("appActivity", "com.samsung.android.dialer.DialtactsActivity");


		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/sem_tip_popup_message")).click();
		Thread.sleep(3000); 
	    MobileElement nine = driver.findElement(By.id("com.samsung.android.dialer:id/nine"));
	    MobileElement seven = driver.findElement(By.id("com.samsung.android.dialer:id/seven"));
	    MobileElement dial = driver.findElement(By.id("com.samsung.android.dialer:id/dialButton")); 
	    
	    nine.click();
	    seven.click();
	    nine.click();
	    seven.click();
	    nine.click();
	    nine.click();
	    nine.click();
	    seven.click();
	    seven.click();
	    seven.click();
	    
	    dial.click();
		
	}
	
	
	
}
