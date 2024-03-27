package LinkedINChallenge;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class day12_WebPageWithMaxLinks {
	
	/*
	 * 𝐂𝐫𝐞𝐚𝐭𝐞 𝐚𝐧 𝐚𝐮𝐭𝐨𝐦𝐚𝐭𝐢𝐨𝐧 𝐒𝐞𝐥𝐞𝐧𝐢𝐮𝐦 𝐭𝐞𝐬𝐭 𝐬𝐜𝐫𝐢𝐩𝐭 𝐭𝐡𝐚𝐭 𝐯𝐞𝐫𝐢𝐟𝐲 𝐥𝐢𝐧𝐤 𝐜𝐨𝐮𝐧𝐭 𝐜𝐚𝐥𝐜𝐮𝐥𝐚𝐭𝐢𝐨𝐧 𝐚𝐧𝐝 𝐢𝐝𝐞𝐧𝐭𝐢𝐟𝐢𝐜𝐚𝐭𝐢𝐨𝐧 𝐨𝐟 𝐩𝐚𝐠𝐞 𝐰𝐢𝐭𝐡 𝐦𝐚𝐱𝐢𝐦𝐮𝐦 𝐥𝐢𝐧𝐤𝐬 𝐛𝐲 𝐮𝐬𝐢𝐧𝐠 𝐇𝐚𝐬𝐡𝐌𝐚𝐩 𝐜𝐨𝐧𝐜𝐞𝐩𝐭 𝐨𝐟 𝐉𝐚𝐯𝐚.
		1) 𝐍𝐚𝐯𝐢𝐠𝐚𝐭𝐞 𝐭𝐨 4 𝐰𝐞𝐛𝐬𝐢𝐭𝐞 𝐨𝐧𝐞 𝐛𝐲 𝐨𝐧𝐞 𝐰𝐡𝐢𝐜𝐡 𝐢𝐬 𝐦𝐞𝐧𝐭𝐢𝐨𝐧𝐞𝐝 𝐛𝐞𝐥𝐨𝐰 :
		- https://lnkd.in/gRnwQiz5
		- https://lnkd.in/gvXtHnEM
		- https://lnkd.in/dS393xhT
		- https://demo.guru99.com/
		
		𝐘𝐨𝐮 𝐧𝐞𝐞𝐝 𝐭𝐨 𝐬𝐭𝐨𝐫𝐞 𝐚𝐥𝐥 4 𝐔𝐑𝐋𝐬 𝐢𝐧 𝐒𝐭𝐫𝐢𝐧𝐠 𝐀𝐫𝐫𝐚𝐲 𝐬𝐞𝐭.
		
		2) 𝐏𝐫𝐢𝐧𝐭 𝐭𝐡𝐞 𝐔𝐫𝐥 𝐨𝐟 𝐏𝐚𝐠𝐞,𝐏𝐚𝐠𝐞 𝐓𝐢𝐭𝐥𝐞 & 𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐥𝐢𝐧𝐤𝐬 𝐨𝐧 𝐭𝐡𝐚𝐭 𝐬𝐩𝐞𝐜𝐢𝐟𝐢𝐞𝐝 𝐔𝐑𝐋 𝐏𝐚𝐠𝐞(𝐇𝐨𝐦𝐞 𝐏𝐚𝐠𝐞).
		
		3)𝐀𝐟𝐭𝐞𝐫 𝐩𝐫𝐨𝐜𝐞𝐬𝐬𝐢𝐧𝐠 𝐚𝐥𝐥 𝐔𝐑𝐋𝐬, 𝐯𝐞𝐫𝐢𝐟𝐲 𝐭𝐡𝐚𝐭 𝐭𝐡𝐞 𝐜𝐨𝐧𝐬𝐨𝐥𝐞 𝐥𝐨𝐠 𝐝𝐢𝐬𝐩𝐥𝐚𝐲𝐬 𝐭𝐡𝐞 𝐩𝐚𝐠𝐞 𝐭𝐢𝐭𝐥𝐞 𝐰𝐢𝐭𝐡 𝐭𝐡𝐞 𝐦𝐚𝐱𝐢𝐦𝐮𝐦 𝐧𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐥𝐢𝐧𝐤𝐬.
		𝐓𝐡𝐞 𝐜𝐨𝐧𝐬𝐨𝐥𝐞 𝐬𝐡𝐨𝐮𝐥𝐝 𝐝𝐢𝐬𝐩𝐥𝐚𝐲 𝐢𝐧 𝐭𝐡𝐢𝐬 𝐟𝐨𝐫𝐦: "𝐏𝐚𝐠𝐞 𝐰𝐢𝐭𝐡 𝐌𝐚𝐱𝐢𝐦𝐮𝐦 𝐋𝐢𝐧𝐤𝐬: [𝐏𝐚𝐠𝐞 𝐓𝐢𝐭𝐥𝐞] - [𝐍𝐮𝐦𝐛𝐞𝐫 𝐨𝐟 𝐋𝐢𝐧𝐤𝐬] 𝐥𝐢𝐧𝐤𝐬".
	 */
	@Test
	public void maxLink() {
		WebDriver driver = new ChromeDriver();
		String arr[]= {"https://www.lambdatest.com/blog/selenium-best-practices-for-web-testing/",
				"https://www.ministryoftesting.com/articles/websites-to-practice-testing",
				"https://naveenautomationlabs.com/opencart/",
				"https://demo.guru99.com/"};
		HashMap<String,Integer> map = new HashMap<>();
		int max=0;
		String page=null;
		for(int i=0;i<arr.length;++i) {
			driver.get(arr[i]);
			map.put(driver.getTitle(), driver.findElements(By.cssSelector("a")).size());
			if(driver.findElements(By.cssSelector("a")).size()>max) {
				max=driver.findElements(By.cssSelector("a")).size();
				page=driver.getTitle();
			}
		}
		System.out.println(map);
		System.out.println("Page with maximum Links : "+page+" - "+map.get(page));
		driver.quit();
	}

}
