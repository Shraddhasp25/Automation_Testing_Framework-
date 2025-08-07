package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFiles {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("C:\\Users\\Prasanna Chougule\\eclipse-workspace\\AutomationFramework\\TestAutomationFramework\\src\\test\\resources\\CongifFiles\\config.properties");
		Properties p = new Properties();
		
		p.load(fr);
		
		System.out.print(p.getProperty("testURL"));
	}
	

}
