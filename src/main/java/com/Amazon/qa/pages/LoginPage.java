package com.Amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	//page factory or object repository
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit]")
	WebElement LoginBtn;
	
		
	@FindBy(xpath="//button[contains(text(),'sign up']")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions:
	
	public String validateLoginpageTitle(){
		return driver.getTitle();
	}
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed(); 
				
	}
	
	public HomePage login(String un,String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
	   LoginBtn.click();
	   return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
