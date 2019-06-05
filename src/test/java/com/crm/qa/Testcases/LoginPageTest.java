package com.crm.qa.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@BeforeMethod
	public void setup() throws IOException {
		intialization();
		loginpage = new LoginPage();	
		}
	
	
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String Title = loginpage.ValidatePageTitle();
		
		Assert.assertEquals(Title, "CRMPRO Log In Screen");
	}
	
	@Test(priority = 2)
	public void CRMLogoImageTest() {
	boolean flag = loginpage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() throws IOException {
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	
	
	
	

	
	
	
}
