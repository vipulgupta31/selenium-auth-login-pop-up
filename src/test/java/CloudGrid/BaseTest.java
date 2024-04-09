package CloudGrid;

import java.net.*;
import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

	public RemoteWebDriver driver = null;

	String username = System.getenv("LT_USERNAME") == null ? "<lambdatest_username>" : System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "<lambdatest_accesskey>" : System.getenv("LT_ACCESS");
	
	String status = "failed";
	
	@BeforeTest
	public void setup() {
		try {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("Windows 10");
			chromeOptions.setBrowserVersion("124.0");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("build", "Handling Login pop-up using Selenium Java");
			ltOptions.put("name", "Handling Login pop-up using Selenium Java");
			ltOptions.put("w3c", true);
			chromeOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeDriver() 
	{
		driver.executeScript("lambda-status=" + status);
		driver.quit();
	}

}
