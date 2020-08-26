package Basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class VerticalScrolling {
	AppiumDriver<WebElement> driver;
	@Test
	public void test() throws MalformedURLException, InterruptedException{
		scroll();
		
	}
	
	public void scroll() throws MalformedURLException, InterruptedException{
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
    	
    	AndroidElement list = (AndroidElement) driver.findElement(By.id("android:id/text1"));
    	
    	MobileElement listitem = (MobileElement)list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Spinner\"));"));
    	
    	listitem.click();    
    	System.out.println("Location is "+listitem.getLocation());
	}
	
}


/*DesiredCapabilities cap = new DesiredCapabilities();
cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
cap.setCapability("deviceName", "Note9");

URL url = new URL("http://127.0.0.1:4723/wd/hub");
driver = new AndroidDriver<WebElement>(url, cap); 
Thread.sleep(3000);
((AndroidDriver)driver).openNotifications();
driver.findElement(By.id("com.android.systemui:id/settings_button")).click();
Thread.sleep(2000);
AndroidElement list = (AndroidElement) driver.findElement(By.className("android.widget.LinearLayout"));

/// Select from list

MobileElement listitem = list.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())."
		+ "scrollIntoView(new UiSelector().text(\" Google\"));"));
System.out.println("Location is "+ listitem.getLocation());

listitem.click();
*/
