package LinkedINChallenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1_BypassAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *𝐓𝐞𝐬𝐭 𝐒𝐜𝐞𝐧𝐚𝐫𝐢𝐨: Develop an automation script that bypasses the Basic Browser Authentication Popup. 
			𝐔𝐬𝐞𝐫𝐧𝐚𝐦𝐞: admin
			𝐏𝐚𝐬𝐬𝐰𝐨𝐫𝐝: admin
		 */
		
		WebDriver driver = new ChromeDriver();
		String userName = "admin";   // UserName
		String password = "admin";	// Password
		
		
		//The format is "https://userName:Password@website.com"
		String url = "https://"+userName+":"+password+"@the-internet.herokuapp.com/basic_auth";
		driver.get(url);
	}

}
