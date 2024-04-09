package CloudGrid;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestHandlingLoginPopUpUsingCloudGrid extends BaseTest{

	@Test
	public void testHandlingLoginPopUpUsingCloudGrid() 
	{
		String username = "admin";
		String password = "admin";
	
		String URL = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
		driver.get(URL);

		String title = driver.getTitle();
		System.out.println("The page title is : " + title);

		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println("The text present in page is : " + text);

		status = "passed";
		System.out.println("Updated status on LambdaTest");
	}

}
