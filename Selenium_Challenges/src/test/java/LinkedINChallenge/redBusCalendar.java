package LinkedINChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class redBusCalendar {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.cssSelector(".dateText")).click();
		WebElement calendar = driver.findElement(By.cssSelector("div[class*='DatePicker__MainBlock']"));
		String monthYear = calendar.findElement(By.cssSelector("div:nth-child(2)")).getText();
		String holidays = calendar.findElement(By.cssSelector("div:nth-child(2) .holiday_count")).getText();		
		System.out.println(monthYear+" "+holidays);
	}

}
