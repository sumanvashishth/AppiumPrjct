package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
@Test
public class TestCases extends BaseClass {

	
	public void tc1(){
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("tc1 ...");
	}
	
public void tc2(){
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("appium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("tc2 ...");
	}
	
	
	
	
}
