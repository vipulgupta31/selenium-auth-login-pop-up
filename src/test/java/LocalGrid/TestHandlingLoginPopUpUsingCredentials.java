package LocalGrid;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestHandlingLoginPopUpUsingCredentials extends BaseTest {

	@Test
	public void testHandlingLoginPopUpUsingCredentials() {
		String URL = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
		driver.get(URL);

		String title = driver.getTitle();
		System.out.println("The page title is : " + title);

		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println("The text present in page is : " + text);

	}

}
