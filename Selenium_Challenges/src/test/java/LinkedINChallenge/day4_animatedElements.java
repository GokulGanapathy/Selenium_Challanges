package LinkedINChallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class day4_animatedElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 𝐔𝐬𝐢𝐧𝐠 𝐬𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 - 𝐂𝐥𝐢𝐜𝐤 𝐨𝐧 𝐭𝐡𝐞 𝐠𝐫𝐨𝐰𝐢𝐧𝐠 𝐛𝐮𝐭𝐭𝐨𝐧 𝐚𝐧𝐝 𝐨𝐧𝐜𝐞 𝐜𝐥𝐢𝐜𝐤𝐞𝐝 𝐲𝐨𝐮 𝐬𝐡𝐨𝐮𝐥𝐝 𝐬𝐞𝐞 "𝐄𝐯𝐞𝐧𝐭 𝐓𝐫𝐢𝐠𝐠𝐞𝐫𝐞𝐝" 𝐦𝐞𝐬𝐬𝐚𝐠𝐞. 
		 * 𝐕𝐞𝐫𝐢𝐟𝐲 𝐭𝐡𝐚𝐭 "𝐄𝐯𝐞𝐧𝐭 𝐓𝐫𝐢𝐠𝐠𝐞𝐫𝐞𝐝".
			𝐇𝐢𝐧𝐭: Not all elements are instantly clickable, particularly when animations etc. are in use.
		 */
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testpages.eviltester.com/styled/challenges/growing-clickable.html");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grown")));
		
		driver.findElement(By.cssSelector(".grown")).click();
		System.out.println(driver.findElement(By.id("growbuttonstatus")).getText());
		Assert.assertEquals(driver.findElement(By.id("growbuttonstatus")).getText(), "Event Triggered");
	}

}
