package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
	public Properties propF;
	String baseURL; 
	
	//Browser Initialization
	@BeforeTest
	public void initBrowser() throws IOException {
		propF = new Properties();
		String srcPropertiesPath = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
		FileInputStream fis = new FileInputStream(srcPropertiesPath);
		propF.load(fis);
		String browserName = propF.getProperty("browser");
		baseURL = propF.getProperty("url");
		if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://google.com");
		}else if(browserName.equalsIgnoreCase("Firefox")) {			
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("no further DriveBrowsers ready");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		
	}
	
	@AfterSuite
	public void closingBrowser() {
		//driver.close();
	}

}
