package LinkedINChallenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day8_dragAndDrop {

	public static void main(String[] args) {
		
		/*
		 * 𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐩𝐞𝐫𝐟𝐨𝐫𝐦𝐬 𝐭𝐡𝐞 𝐃𝐫𝐚𝐠 𝐚𝐧𝐝 𝐝𝐫𝐨𝐩 𝐭𝐡𝐞 𝐢𝐭𝐞𝐦𝐬 𝐢𝐧𝐭𝐨 𝐭𝐡𝐞𝐢𝐫 𝐜𝐨𝐫𝐫𝐞𝐬𝐩𝐨𝐧𝐝𝐢𝐧𝐠 𝐬𝐩𝐨𝐭𝐬 
		 * . 𝐇𝐞𝐫𝐞 𝐢𝐬 𝐚 𝐥𝐢𝐬𝐭 𝐨𝐟 𝐭𝐡𝐞 10 𝐑𝐢𝐜𝐡𝐞𝐬𝐭 𝐏𝐞𝐨𝐩𝐥𝐞 - 𝐲𝐨𝐮 𝐧𝐞𝐞𝐝 𝐭𝐨 𝐚𝐫𝐫𝐚𝐧𝐠𝐞 𝐭𝐡𝐞𝐧 𝐢𝐧 𝐭𝐡𝐞 𝐜𝐨𝐫𝐫𝐞𝐜𝐭 𝐨𝐫𝐝𝐞𝐫 𝐚𝐬 𝐠𝐢𝐯𝐞𝐧 𝐛𝐞𝐥𝐨𝐰 :

		// 𝐄𝐱𝐩𝐞𝐜𝐭𝐞𝐝 𝐨𝐫𝐝𝐞𝐫 𝐨𝐟 𝐧𝐚𝐦𝐞𝐬 𝐢𝐧 𝐋𝐢𝐬𝐭 𝐨𝐫𝐝𝐞𝐫:
		   position: 1, name: "Jeff Bezos"
		   position: 2, name: "Bill Gates"
		   position: 3, name: "Warren Buffett"
		   position: 4, name: "Bernard Arnault"
		   position: 5, name: "Carlos Slim Helu"
		   position: 6, name: "Amancio Ortega"
		   position: 7, name: "Larry Ellison"
		    position: 8, name: "Mark Zuckerberg"
		   position: 9, name: "Michael Bloomberg"
		 */
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaplayground.dev/apps/sortable-list/");
		String[] lisArray = {"Jeff Bezos","Bill Gates","Warren Buffett","Bernard Arnault","Carlos Slim Helu","Amancio Ortega",
				                "Larry Ellison","Mark Zuckerberg","Michael Bloomberg"};
		List<WebElement> lis = driver.findElements(By.cssSelector("p[class='person-name']"));
		Actions action = new Actions(driver);
		for(int i=0;i<lisArray.length;++i)
		{
			if(lis.get(i).getText().equals(lisArray[i]))
			{
				continue;
			}
			else {
				for(int j=i+1;j<lis.size();++j)
				{
					if(lis.get(j).getText().equals(lisArray[i]))
					{
						action.dragAndDrop(lis.get(j), driver.findElement(By.cssSelector("li[data-index='"+i+"']"))).perform();
						break;
					}
				}
			}
		}
		
		

	}

}
