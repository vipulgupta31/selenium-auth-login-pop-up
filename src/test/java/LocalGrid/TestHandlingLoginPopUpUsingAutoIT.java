package LocalGrid;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestHandlingLoginPopUpUsingAutoIT extends BaseTest {

	@Test
	public void testHandlingLoginPopUpUsingAutoIT() throws InterruptedException, IOException {

		String url = "http://the-internet.herokuapp.com/basic_auth";
		System.out.println("Navigating to the url");
		driver.get(url);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		System.out.println("Running Login.exe executable file");
		Runtime.getRuntime().exec("<path_to_executable_in_AutoIT_folder>//Login.exe");

		Thread.sleep(2000);

		String title = driver.getTitle();
		System.out.println("The page title is : " + title);

		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println("The text present in page is : " + text);

	}

}
