package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage {
	
	
	WebDriver driver;
	
	
	//Constructor
	public void loginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	//Identifying Login WebElements	
	@FindBy(how=How.XPATH, using="//input[@id='txtUsername']") WebElement userNameTextField;
	@FindBy(how=How.ID, using="txtPassword") WebElement passwordField;
	@FindBy(how=How.ID, using="btnLogin") WebElement logInBtn;
	@FindBy(how=How.XPATH, using="//div[@id='content']/div[2]/span") WebElement credentialsTxt;
	
	
	
	//Methods related to LoginPage
	
	//Filling user name field
	public void setUserName(String userName) {		
		userNameTextField.sendKeys(userName);
	}
	
	//Filling password field
	public void setPassword(String pass) {		
		passwordField.sendKeys(pass);
	}
	
	//Action > LogIn
	public void clickingOnLogIn() {		
		logInBtn.click();
	}
	
	public String pullingUserName() {
		String userName = credentialsTxt.getText().split("e :")[1].strip().split(" ")[0];
		return userName;
	}
	
	public String pullingPass() {
		String pass = credentialsTxt.getText().split("d :")[1].strip().split(" ")[0];
		return pass;
	}
	
	
	
	
	
	
	
	

}
