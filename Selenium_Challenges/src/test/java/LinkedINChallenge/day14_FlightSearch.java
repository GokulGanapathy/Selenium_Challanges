package LinkedINChallenge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class day14_FlightSearch {

	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jetblue.com/");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[title='TrustArc Cookie Consent Manager']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='TrustArc Cookie Consent Manager']")));
		driver.findElement(By.xpath("//div/div/a[contains(text(),'Accept All Cookies')]")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("(//input[contains(@id,'jb-autocomplete')])[1]")).clear();
		driver.findElement(By.xpath("(//input[contains(@id,'jb-autocomplete')])[1]")).sendKeys("mumbai");
		List<WebElement> suggestions = driver.findElements(By.cssSelector(".list-item"));
		for (int i = 0; i < suggestions.size(); ++i) {
			System.out.println(suggestions.get(i).findElement(By.cssSelector("span span div")).getText());
			if (suggestions.get(i).findElement(By.cssSelector("span span div")).getText().contains("Mumbai")) {
				suggestions.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[contains(@id,'jb-autocomplete')])[2]")).clear();
		driver.findElement(By.xpath("(//input[contains(@id,'jb-autocomplete')])[2]")).sendKeys("London");

		List<WebElement> suggestions2 = driver.findElements(By.cssSelector(".list-item"));
		for (int i = 0; i < suggestions2.size(); ++i) {
			//System.out.println(suggestions2.get(i).findElement(By.cssSelector("span span div[class='in-area']")).getText());
			if (suggestions2.get(i).findElement(By.cssSelector("span span div[class='in-area']")).getText().contains("Heathrow")) {
				suggestions2.get(i).click();
				break;
			}
		}
		
		WebElement departDate = driver.findElement(By.id("jb-date-picker-input-id-0"));
		WebElement returnDate = driver.findElement(By.id("jb-date-picker-input-id-1"));
		WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search flights')]"));

		
		
		departDate.sendKeys("03/20/2024");
		returnDate.sendKeys("03/22/2024");
		searchButton.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[role='dialog']")));
		driver.findElement(By.cssSelector("div[role='dialog'] span")).click();
		driver.findElement(By.cssSelector("div[role='dialog'] span")).click();
	}
}
