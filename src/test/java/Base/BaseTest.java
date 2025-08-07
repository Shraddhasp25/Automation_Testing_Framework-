package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	public static Properties loc = new Properties();
	public static FileReader fr1;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		if(driver == null)
		{
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\CongifFiles\\config.properties");
			prop.load(fr);
			
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\CongifFiles\\Locators.properties");
			loc.load(fr1);
		}
		
		if(prop.getProperty("Browser").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testURL"));
		}
		
		else if(prop.getProperty("Browser").equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testURL"));
		}
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		System.out.print("Tear down successful");
	}
}
