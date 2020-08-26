package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class SendSMS {
	
	AppiumDriver<MobileElement> driver;
	@Test
	public void test() throws MalformedURLException, InterruptedException{
		
		send_sms();
	}
	
	public void send_sms() throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    	cap.setCapability("deviceName", "Note9");
		cap.setCapability("appPackage", "com.samsung.android.messaging");
		cap.setCapability("appActivity", "com.samsung.android.messaging.ui.ComposeMessageMms");


		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		MobileElement compose = driver.findElement(By.id("com.samsung.android.messaging:id/fab"));
		compose.click();
		
		MobileElement to = driver.findElement(By.id("com.samsung.android.messaging:id/recipients_editor_to"));
		MobileElement msg = driver.findElement(By.id("com.samsung.android.messaging:id/message_edit_text"));
		MobileElement send = driver.findElement(By.id("com.samsung.android.messaging:id/send_button1"));
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		to.click();
		to.sendKeys("987654321");
		msg.click();
		Thread.sleep(2000);
		msg.sendKeys("Hello, how are you");
		send.click();
		
	}
}
