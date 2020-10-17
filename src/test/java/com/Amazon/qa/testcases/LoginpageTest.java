package com.Amazon.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.qa.base.TestBase;
import com.Amazon.qa.pages.HomePage;
import com.Amazon.qa.pages.LoginPage;


public class LoginpageTest extends TestBase {
	
LoginPage LoginPage;
 HomePage homepage;
public LoginpageTest() { 
   super();
   }
@BeforeMethod
public void setup() { 
initialization();
LoginPage=new LoginPage();

try {
	prop=new Properties();
	
	FileInputStream ip=new FileInputStream("C:\\Users\\zohsa\\eclipse-workspace\\testautomation\\src\\main\\java\\com\\Amazon\\qa\\base\\TestBase.java");
	prop.load(ip);;
}catch (FileNotFoundException e){
	e.printStackTrace();
}catch(IOException e) {
	e.printStackTrace();
	
}

driver.get(prop.getProperty("url"));
}
@Test(priority=1)
public void loginPageTitleTest() {
	String title=LoginPage.validateLoginpageTitle();
	Assert.assertEquals(title,"#1 Free CRM For Any Buisness: Online Customer Relationship Software");
	
   }
@Test(priority=2)
public void crmLogoImageTest() {
	boolean flag=LoginPage.validateCRMImage();
	Assert.assertTrue(flag);
	}
@Test(priority=3)
public void LoginTest() {
	homepage=LoginPage.login(prop.getProperty("username"),prop.getProperty ("password"));
	}
 @AfterMethod
 public void tearDown() {
	 driver.quit();
	 
  }
}