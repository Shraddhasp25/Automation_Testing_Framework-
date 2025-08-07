package Test_Cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;

public class PageLogin extends BaseTest{
	
	@Test(dataProvider = "TestData")
	public void pageLogin(String Username, String Password) throws InterruptedException
	{
		driver.findElement(By.linkText(loc.getProperty("Sign_In_Link"))).click();;
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("email_Testbox"))).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("next_Button"))).click();
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("password_Textbox"))).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.id(loc.getProperty("Sign_In_Btn"))).click();
		Thread.sleep(2000);
		
		
	}
	
	@DataProvider(name = "TestData")
	public Object[][] tdata()
	{
		return new Object[][]
		{
			{"shraddhasp20@gmail", "test123Autom"},
			{"shrad20@gmail.com", "test123Automation"},
			{"shrasp20@gmail.com", "test1ation"},
			{"shraddhasp20@gmail.com", "test123Automation"}
			
		};
	}
		
}
