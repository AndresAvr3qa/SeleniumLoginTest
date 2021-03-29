package orangeHRMLive;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseT {
	
	//Global Variables ---------
	public static WebDriver driver;
	public String baseURL ="https://opensource-demo.orangehrmlive.com/";
	
	
	//Browser Initialization
	@BeforeTest
	@Parameters("browser")
	public void initBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://google.com");
		}else if(browser.equalsIgnoreCase("Firefox")) {			
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("no further DriveBrowsers ready");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
	@AfterSuite
	public void closingBrowser() {
		//driver.close();
	}

}
