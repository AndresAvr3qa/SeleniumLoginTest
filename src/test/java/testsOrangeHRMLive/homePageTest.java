package testsOrangeHRMLive;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.homePage;
import Pages.loginPage;
import orangeHRMLive.baseT;

public class homePageTest extends baseT{

	
		//Class variables
		static String expectedURL ="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
				
		//Tests
		@Test
		public void homeValidatingLogin() {			
			homePage logInIndex = PageFactory.initElements(driver, homePage.class);	
			String loginTxt = logInIndex.getLogTxt();			
			Assert.assertTrue(loginTxt.contains("Welcome")); //Confirms text output: Welcome userName
			Assert.assertEquals(driver.getCurrentUrl(),expectedURL); //Confirms Home URL
		}
		
		
		
}
