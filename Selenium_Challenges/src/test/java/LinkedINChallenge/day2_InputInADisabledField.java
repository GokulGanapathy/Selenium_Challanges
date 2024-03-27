package LinkedINChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day2_InputInADisabledField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		//This is Negative Scenario
		/*
		 * 𝐓𝐞𝐬𝐭 𝐒𝐜𝐞𝐧𝐚𝐫𝐢𝐨: Develop an automation script that will input 
		 * a value in a disabled field (You cannot able to input value in field with sendkeys()
		 *  directly if field is disabled)
		 */
		System.out.println(driver.findElement(By.id("pass")).isEnabled());   // Checking whether the element is enabled or not
		
		//Using JSExecutor to give the value to the element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('pass').value='Password@1234'");

	}

}
