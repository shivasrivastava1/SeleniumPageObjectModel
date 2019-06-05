package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
 	}
	
	
	public String ValidatePageTitle()
	{
		return driver.getTitle();
				
	}
	
	public boolean ValidateCRMImage() {
		return crmLogo.isDisplayed();
		
	}
	
	
	public HomePage login(String UN, String PWD) throws IOException {
		username.sendKeys(UN);
		password.sendKeys(PWD);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	

}
