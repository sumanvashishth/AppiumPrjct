package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class DragNDrop {
	
	AppiumDriver<WebElement> driver;
	String Source , Target;
	@Test
	public void test() throws MalformedURLException, InterruptedException{
		
		dragNdrop();
		
		if(Source.contentEquals(Target)){
			
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
		
	}
	
	public void dragNdrop() throws MalformedURLException, InterruptedException{
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    	cap.setCapability("deviceName", "Note9");
    	cap.setCapability("appPackage", "com.mobeta.android.demodslv");
    	cap.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
    	//cap.setCapability("deviceName", "emulator-5554");
    	
    	
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver<WebElement>(url, cap); 
    	Thread.sleep(3000);
    	
    	WebElement basic = driver.findElement(By.id("com.mobeta.android.demodslv:id/activity_title"));
    	basic.click();
    	
    	WebElement sourcetext = driver.findElements(By.id("com.mobeta.android.demodslv:id/text")).get(1);
    	Source = sourcetext.getText();
    	System.out.println("Text is " +Source);
    	
    	WebElement source = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(1);
     	WebElement target = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(7);
    	
    	TouchAction action = new TouchAction(driver);
    	action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
    	
    	WebElement targettext = driver.findElements(By.id("com.mobeta.android.demodslv:id/text")).get(8);
    	Target = targettext.getText();
    	System.out.println("Target text is "+Target);	 
		
		
	}
	
	
}
