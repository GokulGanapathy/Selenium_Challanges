package LinkedINChallenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class day3_pseudoElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*	𝐔𝐬𝐢𝐧𝐠 𝐬𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 - 𝐫𝐞𝐚𝐝 𝐭𝐡𝐞 * 𝐫𝐚𝐭𝐢𝐧𝐠 𝐨𝐟 𝐭𝐡𝐞 𝐛𝐨𝐨𝐤, 
		 *	 𝐞𝐧𝐭𝐞𝐫 𝐢𝐭 𝐢𝐧 𝐭𝐡𝐞 𝐭𝐞𝐱𝐭 𝐛𝐨𝐱 𝐚𝐧𝐝 𝐜𝐥𝐢𝐜𝐤 "𝐜𝐡𝐞𝐜𝐤 𝐫𝐚𝐭𝐢𝐧𝐠" 𝐛𝐮𝐭𝐭𝐨𝐧.
		 * 	 𝐲𝐨𝐮 𝐬𝐡𝐨𝐮𝐥𝐝 𝐬𝐞𝐞 "𝐰𝐞𝐥𝐥 𝐝𝐨𝐧𝐞!" 𝐦𝐞𝐬𝐬𝐚𝐠𝐞. 
			 𝐇𝐢𝐧𝐭: Use CSS Pseudo-elements Concept
		*/
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://play1.automationcamp.ir/advanced.html");
		
		//Getting PesudoElement by using JSExecutor
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String result = (js.executeScript("return "
				+ "window.getComputedStyle(document.querySelector('.star-rating'),'::after')"
				+ ".getPropertyValue('content')")).toString();
		
		System.out.println(result);
		result = result.replaceAll("\"", "");
		System.out.println(result);
		driver.findElement(By.id("txt_rating")).sendKeys(result);
		driver.findElement(By.xpath("//button[contains(@id,'check_rating')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("validate_rating")));
		
		Assert.assertEquals(driver.findElement(By.id("validate_rating")).getText(), "Well done!");
	}

}
