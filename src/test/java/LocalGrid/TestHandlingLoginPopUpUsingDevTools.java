package LocalGrid;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class TestHandlingLoginPopUpUsingDevTools{

	@Test
	public void testHandlingLoginPopUpUsingDevTools() 
	{	
		ChromeDriver driver = new ChromeDriver();  
				
		// Get the devtools from the running driver and create a session
		System.out.println("Creating Chrome DevTools session");
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// Enable the Network domain of devtools
		devTools.send(Network.enable(Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Integer>empty()));

		// Encoding the username and password using Base64
		String auth = "admin:admin";
		String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());
		System.out.println("Encoded String: " + encodeToString);

		// Pass the network header as Authorization : Basic <encoded String>
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Authorization", "Basic " + encodeToString);
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
		
		//Navigate to the website
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//verify the loaded page
		String title = driver.getTitle();
		System.out.println("The page title is : " + title);

		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println("The text present in page is : " + text);
	
		driver.quit();
	}
}
