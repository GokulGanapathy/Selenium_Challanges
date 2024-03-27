package LinkedINChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class day16_mouseHoverMoviePrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /* 𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐡𝐨𝐯𝐞𝐫 𝐨𝐧 𝐭𝐡𝐞 𝐦𝐨𝐯𝐢𝐞 𝐩𝐨𝐬𝐭𝐞𝐫 𝐚𝐧𝐝 𝐨𝐧 𝐡𝐨𝐯𝐞𝐫 𝐢𝐭 𝐬𝐡𝐨𝐮𝐥𝐝 𝐟𝐞𝐭𝐜𝐡 𝐩𝐫𝐢𝐜𝐞 𝐨𝐟 𝐢𝐭.
			𝐒𝐭𝐞𝐩𝐬:
			1)Navigate to: https://lnkd.in/dwDQbUKz
			2)Do the mouse hover on the Movie poster.
			3)Fetch the price and verify it.
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.dev/apps/mouse-hover/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("img[class='poster']"))).build().perform();
		String price = driver.findElement(By.cssSelector("div[class='title-content'] p[class='current-price']")).getText();
		Assert.assertEquals(price, "$24.96");
		System.out.println(price);
		driver.quit();
	}
}
