package LinkedINChallenge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day7_moveAndClick_Actions {
	
	@Test
	public void moveAndClick() {
		
		/*
		 * 𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐩𝐞𝐫𝐟𝐨𝐫𝐦𝐬 𝐭𝐡𝐞 "𝐑𝐢𝐠𝐡𝐭 𝐂𝐥𝐢𝐜𝐤" 𝐨𝐟 𝐦𝐨𝐮𝐬𝐞 𝐚𝐧𝐝 𝐲𝐨𝐮 𝐰𝐢𝐥𝐥 𝐬𝐞𝐞 𝐭𝐡𝐞 𝐦𝐞𝐧𝐮 
		 * 𝐭𝐡𝐞𝐧 𝐧𝐚𝐯𝐢𝐠𝐚𝐭𝐞 𝐭𝐨 "𝐒𝐡𝐚𝐫𝐞 𝐦𝐞𝐧𝐮" 𝐨𝐩𝐭𝐢𝐨𝐧 𝐚𝐧𝐝 𝐜𝐥𝐢𝐜𝐤 𝐨𝐧 𝐚𝐥𝐥 "𝐬𝐨𝐜𝐢𝐚𝐥 𝐦𝐞𝐝𝐢𝐚 𝐥𝐢𝐧𝐤𝐬" 𝐢𝐧 𝐬𝐮𝐛-𝐦𝐞𝐧𝐮. 
		 * 𝐚𝐧𝐝 𝐚𝐬𝐬𝐞𝐫𝐭𝐬 𝐭𝐡𝐞 𝐯𝐞𝐫𝐢𝐟𝐢𝐜𝐚𝐭𝐢𝐨𝐧 𝐦𝐞𝐬𝐬𝐚𝐠𝐞 𝐟𝐨𝐫 𝐚𝐥𝐥 𝐬𝐨𝐜𝐢𝐚𝐥 𝐥𝐢𝐧𝐤𝐬.
		 * e.g: "Menu item Twitter clicked"
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.dev/apps/context-menu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action =new Actions(driver);
		List<WebElement> shareItems = driver.findElements(By.cssSelector(".share-menu .menu-item"));
		int n=shareItems.size();
		for(int i=0;i<n;++i)
		{
			action.moveByOffset(100,100).contextClick().moveToElement(driver.findElement(By.cssSelector(".uil.uil-angle-right")))
						.build().perform();
			shareItems.get(i).click();
			
			String shareItem = shareItems.get(i).findElement(By.tagName("span")).getText();
			System.out.println(shareItem);
			
			String msg = driver.findElement(By.xpath("//p[@id='msg']")).getText();
			System.out.println(msg);
			
			Assert.assertEquals(msg,"Menu item "+shareItem+" clicked");
		}
		driver.quit();
	}
}
