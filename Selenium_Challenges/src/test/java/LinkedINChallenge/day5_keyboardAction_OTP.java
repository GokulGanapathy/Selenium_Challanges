package LinkedINChallenge;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class day5_keyboardAction_OTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 𝐔𝐬𝐢𝐧𝐠 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐞𝐧𝐭𝐞𝐫 𝐭𝐡𝐞 𝐯𝐚𝐥𝐢𝐝 𝐜𝐨𝐝𝐞 𝐛𝐲 𝐤𝐞𝐲𝐛𝐨𝐚𝐫𝐝 𝐤𝐞𝐲𝐬 𝐛𝐲 𝐩𝐫𝐞𝐬𝐬𝐢𝐧𝐠 𝐭𝐡𝐞 𝐨𝐧𝐥𝐲 𝐤𝐞𝐲 𝐛𝐮𝐭𝐭𝐨𝐧 𝐚𝐧𝐝 𝐚𝐬𝐬𝐞𝐫𝐭𝐢𝐧𝐠 "𝐬𝐮𝐜𝐜𝐞𝐬𝐬" 𝐦𝐞𝐬𝐬𝐚𝐠𝐞. 
		 *  The confirmation code is - "999999".
			You cannot use sendkeys("9") directly.
			𝐇𝐢𝐧𝐭: Use keyboard events Keys concept
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.dev/apps/verify-account/");
		List<WebElement> entryBox = driver.findElements(By.xpath("//input[@type='number']"));
		Actions action = new Actions(driver);
		
		for(int i=0;i<entryBox.size();++i)
		{
			
			//1st Approach
			//action.moveToElement(entryBox.get(i)).sendKeys(Keys.NUMPAD9).perform();
			
			//2nd Approach
			action.moveToElement(entryBox.get(i)).keyDown(Keys.NUMPAD9).perform();
			action.keyUp(Keys.NUMPAD9).perform();
		}
		//If test fails here we might want to use wait
		System.out.println(driver.findElement(By.cssSelector(".info.success")).getText());
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".info.success")).getText(), "Success");
		driver.quit();
	}

}
