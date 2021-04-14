package testsOrangeHRMLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.loginPage;
import resources.baseT;


public class loginPageTest extends baseT{
	
	//Class Variables
	static loginPage logInOr;
	

	
	//Test Cases	
	@Test(dependsOnMethods=("loginValidatingSite")) //Based on validatingSite Test Method, will continue or not with login test
	public void loginTest() throws Exception{
		
		logInOr.setUserName(logInOr.getUserPassExcel("UserID").get(0));
		logInOr.setPassword(logInOr.getUserPassExcel("UserID").get(1));
		//logInOr.setUserName(user);
		//logInOr.setPassword(pass);	
		logInOr.clickingOnLogIn();
		System.out.println("login test....");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginValidatingSite() {				
		String expectedURL ="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);	
		System.out.println("correct site here");
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][2];
		data[0][0] = logInOr.pullingUserName();
		data[0][1] = logInOr.pullingPass();		
		
		return data;
	}

	
	//to instantiate loginPage object, before each @test is taking place: includes the data provider above
	@BeforeTest
	public loginPage logInPageObject() {
		logInOr = PageFactory.initElements(driver, loginPage.class);		
		return logInOr;
	}
	
	
}
