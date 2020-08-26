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


public class CalculatorTest {
	AppiumDriver<MobileElement> driver;
	String res ;
	@Test
	public void tc() throws MalformedURLException, InterruptedException{
		
		calc();
		if(res.contains("3")){
			System.out.println("TC Passed");	
		}
		else {
			
			System.out.println("TC Failed");
		}	
	}
	public void calc() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    	cap.setCapability("deviceName", "Note9");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");


		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);

		MobileElement nine = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09"));
		MobileElement div = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div"));
		MobileElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
		MobileElement equals = driver
				.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
		MobileElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));

		nine.click();
		div.click();
		three.click();
		equals.click();
		Thread.sleep(2000);

		res = result.getText();

	}
	
}
