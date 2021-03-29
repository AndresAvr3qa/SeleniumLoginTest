package testsOrangeHRMLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.loginPage;
import orangeHRMLive.baseT;


public class loginPageTest extends baseT{
	
	//Class Variables
	static loginPage logInOr;

	
	//Test Cases	
	@Test(dataProvider="getData", dependsOnMethods=("loginValidatingSite")) //Based on validatingSite Test Method, will continue or not with login test
	public void loginTest(String user, String pass) throws Exception{
		logInOr.setUserName(user);
		logInOr.setPassword(pass);	
		logInOr.clickingOnLogIn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginValidatingSite() {				
		String expectedURL ="https://opensource-demo.orangehrmlive.com/";
		Assert.assertEquals(driver.getCurrentUrl(), expectedURL);	
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
