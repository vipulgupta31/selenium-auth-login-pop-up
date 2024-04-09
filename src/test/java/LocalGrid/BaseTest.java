package LocalGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

	public static WebDriver driver;
	
	String username = "admin";
	String password = "admin";

	@BeforeClass
	public void setDriver() {
		driver = new ChromeDriver();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
}
