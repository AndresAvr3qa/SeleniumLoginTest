package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class homePage {
	
	WebDriver driver;
	
	//Constructor
	public void homePage(WebDriver driver) {		
		this.driver = driver;
	}
	
	
	
	//Identifying Home/Index WebElements
	@FindBy(how=How.ID, using="welcome") WebElement welcomeTxt;
	
	
	//Methods related to Home/Index Page
	
	public String getLogTxt() {
		String successLog = welcomeTxt.getText();
		return successLog;
	}
	
	

}
