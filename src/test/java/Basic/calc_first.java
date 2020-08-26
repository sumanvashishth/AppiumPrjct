package Basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@Test
public class calc_first {
	

	static AppiumDriver<MobileElement> driver;
	
	public static void first() {
		// TODO Auto-generated method stub
		
		try { 
		opencalc();
			
	}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			
		}

	}
	
	@BeforeMethod(enabled = false)
	public static void opencalc() throws MalformedURLException, InterruptedException{
		
		//ChromeOptions cap = new ChromeOptions();
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability("no", true);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME , devi);
		cap.setCapability("deviceName", "Note9");
		//cap.setCapability("uDID", "215b8318a80d7ece");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("platformName", "Android");
		//cap.setCapability("appium:automationName", "abc");
	    //cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		 
		/*cap.setCapability("appPackage", "com.samsung.android.dialer");
		cap.setCapability("appActivity", "com.samsung.android.dialer.DialtactsActivity");*/
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
	    driver = new AndroidDriver<MobileElement> (url,cap);
	    //driver.manage().wait(5000);
	    
	    MobileElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
	    MobileElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
	    MobileElement eight = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_08"));
	    MobileElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
	    MobileElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
	    
	    
	    eight.click();
	    plus.click();
	    two.click();
	    equals.click();
	    
	    String res = result.getText();
	    
		System.out.println("Application Started .... "  + " && Result is " + res);
		System.out.println("completed...");
		
	}

}
