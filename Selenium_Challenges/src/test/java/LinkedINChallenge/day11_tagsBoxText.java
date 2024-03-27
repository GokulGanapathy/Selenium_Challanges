package LinkedINChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class day11_tagsBoxText {

	public static void main(String[] args) {
		/*
		 * ✅𝐓𝐞𝐬𝐭 𝐒𝐜𝐞𝐧𝐚𝐫𝐢𝐨:
			𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐀𝐝𝐝 𝐚𝐧𝐝 𝐫𝐞𝐦𝐨𝐯𝐞 𝐭𝐚𝐠𝐬 𝐚𝐧𝐝 𝐚𝐬𝐬𝐞𝐫𝐭 𝐭𝐚𝐠'𝐬 𝐩𝐫𝐞𝐬𝐞𝐧𝐜𝐞 𝐚𝐧𝐝 𝐜𝐨𝐮𝐧𝐭.
			
			✅𝐒𝐭𝐞𝐩𝐬 :
			
			1) 𝐍𝐚𝐯𝐢𝐠𝐚𝐭𝐞 𝐭𝐨 𝐰𝐞𝐛𝐬𝐢𝐭𝐞:
			https://lnkd.in/ddcs5QEj
			2) 𝐏𝐫𝐢𝐧𝐭 𝐭𝐡𝐞 𝐜𝐨𝐮𝐧𝐭 𝐧𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐭𝐡𝐞 𝐭𝐚𝐠𝐬 & 𝐑𝐞𝐦𝐨𝐯𝐞 𝐚𝐥𝐥 𝐭𝐡𝐞 𝐭𝐚𝐠𝐬 𝐢𝐧𝐬𝐢𝐝𝐞 𝐭𝐡𝐞 𝐛𝐨𝐱.
			3) 𝐀𝐝𝐝 10 𝐭𝐚𝐠𝐬 𝐨𝐟 𝐚𝐧𝐲 𝐤𝐞𝐲𝐰𝐨𝐫𝐝𝐬 𝐲𝐨𝐮 𝐥𝐢𝐤𝐞.
			4) 𝐕𝐞𝐫𝐢𝐟𝐲 𝐭𝐡𝐚𝐭 𝐂𝐨𝐮𝐧𝐭 𝐨𝐟 𝐧𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐭𝐚𝐠𝐬 𝐢𝐬 "0" 𝐚𝐧𝐝 𝐩𝐫𝐢𝐧𝐭 𝐢𝐧 𝐜𝐨𝐧𝐬𝐨𝐥𝐞.
			5) 𝐍𝐨𝐰 𝐑𝐞𝐦𝐨𝐯𝐞 𝐚𝐥𝐥 𝐭𝐚𝐠𝐬 𝐚𝐧𝐝 𝐭𝐫𝐲 𝐭𝐨 𝐢𝐧𝐩𝐮𝐭 "<𝐬𝐜𝐫𝐢𝐩𝐭>𝐚𝐥𝐞𝐫𝐭()</𝐬𝐜𝐫𝐢𝐩𝐭>" 𝐚𝐬 𝐤𝐞𝐲𝐰𝐨𝐫𝐝 𝐚𝐧𝐝 𝐚𝐝𝐝 𝐢𝐭.
			6)𝐓𝐫𝐲 𝐭𝐨 𝐠𝐞𝐭 𝐭𝐡𝐚𝐭 𝐯𝐚𝐥𝐮𝐞 𝐨𝐟 𝐭𝐡𝐞 𝐭𝐚𝐠 𝐚𝐧𝐝 𝐩𝐫𝐢𝐧𝐭 𝐢𝐭 𝐨𝐧 𝐜𝐨𝐧𝐬𝐨𝐥𝐞. 𝐀𝐫𝐞 𝐲𝐨𝐮 𝐚𝐛𝐥𝐞 𝐭𝐨 𝐟𝐞𝐭𝐜𝐡 𝐭𝐡𝐞 𝐯𝐚𝐥𝐮𝐞 𝐨𝐫 𝐧𝐨𝐭? 𝐈𝐟 𝐲𝐞𝐬 𝐭𝐡𝐞𝐧 𝐰𝐡𝐚𝐭 𝐢𝐬 𝐩𝐫𝐢𝐧𝐭𝐞𝐝 𝐨𝐧 𝐜𝐨𝐧𝐬𝐨𝐥𝐞?
		 */
		
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\dell\\Documents\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.dev/apps/tags-input-box/");
		
		String tagText = driver.findElement(By.cssSelector("div[class='details'] p")).getText();
		System.out.println(tagText);
		
		driver.findElement(By.xpath("//button[contains(text(),'Remove All')]")).click();
		
		String[] lis = {"India","Australia","Ashwin","IPL","RCB","CSK","Cloud","Offer","Jobs","Gokul"};
		Actions action = new Actions(driver);
		for(int i=0;i<lis.length;++i) {
			action.moveToElement(driver.findElement(By.xpath("//ul/input"))).sendKeys(lis[i]).sendKeys(Keys.ENTER).perform();
		}
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='details']/p/span")).getText(), "0");
		
		driver.findElement(By.xpath("//button[contains(text(),'Remove All')]")).click();
		action.moveToElement(driver.findElement(By.cssSelector("ul input"))).sendKeys("<script>alert</script>").sendKeys(Keys.ENTER).build().perform();
		System.out.println(driver.findElement(By.cssSelector("ul li")).getText());
	}

}
