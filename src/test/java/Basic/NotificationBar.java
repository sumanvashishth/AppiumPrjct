package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class NotificationBar {

	AppiumDriver<WebElement> driver;
	String Source , Target;
	@Test
	public void test() throws MalformedURLException, InterruptedException{
		notificationBar();

	}
	public void notificationBar() throws MalformedURLException, InterruptedException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    	cap.setCapability("deviceName", "Note9");
    	
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver<WebElement>(url, cap); 
    	Thread.sleep(3000);
    	((AndroidDriver)driver).openNotifications();
    	
    	WebElement source = driver.findElement(By.id("com.android.systemui:id/quick_settings_background"));
    	
    	TouchAction action = new TouchAction(driver);
    	action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(source,516,2044)).release().perform();
    	
    	
    	
	}
	
}
