package com.Amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Amazon.qa.util.TestUtil;

public class TestBase {
	
	 public static WebDriver driver;	
	 public static Properties prop;
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\zohsa\\eclipse-workspace\\testautomation\\src\\main\\java\\com\\Amazon\\qa\\config\\config properties");
			//FileInputStream ip=new FileInputStream("C:\\Users\\zohsa\\eclipse-workspace\\testautomation\\src\\main\\java\\com\\Amazon\\qa\\base\\TestBase.java");
			prop.load(ip);;
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}	
	public static void initialization() {
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/C:\\Farheen\\chromedriver_win32\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver","/C:\\Users\\zohsa\\Desktop\\geckodriver.exe");
			
			 driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS );
		driver.get(prop.getProperty("url"));
		
	   }
		

	
}
