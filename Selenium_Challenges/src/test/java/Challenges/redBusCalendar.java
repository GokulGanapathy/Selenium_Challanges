package Challenges;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class redBusCalendar {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		//Debugger Timeout
		/*
		 *setTimeout(function(){debugger},5000)
		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.redbus.in/");
		
		List<String> weekEndDates = getWeekEndDates("Dec 2025");
		
		System.out.println(weekEndDates);
		driver.quit();
		
	}
	
	public static List<String> getWeekEndDates(String monthYearInput){
		
		List<String> weekEndDates = new ArrayList<>();
		
		driver.findElement(By.cssSelector(".dateText")).click();
		
		WebElement calendar = driver.findElement(By.cssSelector("div[class*='DatePicker__MainBlock']"));
		
		while(true) {
			
			String monthYear1="";
			try {
				String monthYear = calendar.findElement(By.cssSelector("div:nth-child(2)")).getText();
				//monthYear is coming as May 2025 + line space +5 Holidays
				monthYear1 = monthYear.split("\n")[0];
				String holidays = driver.findElement(By.cssSelector("div:nth-child(2) .holiday_count")).getText();		
				System.out.println(monthYear1+"\n"+holidays);
			}catch(Exception e) {
				System.out.println(monthYear1+"\n"+"No Holidays");
			}
			
			if(monthYear1.equals(monthYearInput)) {
				
				List<WebElement> weeks = driver.findElements(By.cssSelector("div div[class*='DayTilesWrapper']"));
				for(int i=1;i<weeks.size();++i) {
					List<WebElement> days = weeks.get(i).findElements(By.cssSelector("span div[class*='CalendarDaysBlock'] span"));
					int x=0;
					if(days.size()>=2) {
						x=days.size()-2;
					}
					for(int j=x;j<days.size();++j) {
						if(days.get(j).getAttribute("class").contains("bwoYtA")) {
							weekEndDates.add(days.get(j).getText());
						}
						else {
							continue;
						}
					}
				}
				break;
			}
			else {
				driver.findElement(By.cssSelector("div[class*='DayNavigator']:last-child svg")).click();
			}
		}
		return weekEndDates;
	}

}
