package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Framework.utils.PropertiesFileProcessor;
import Selenium.utils.BaseTest;
import pageObjects.LoginPage;
import pageObjects.MenuPage;

public class LoginTest extends BaseTest{

	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.Properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.Properties");
	
	@Test(priority=1, groups="UserManagementFunctionality")
	public void loginTest() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		//menu.navigateTo(menu.loginLink);
		menu.click(menu.loginLink);
		login.loginInApp(USER,PASS);
		Thread.sleep(500);
		assertTrue(login.checkMsgIsDisplayed(login.successLoginMsg));
		Thread.sleep(3000);
		//login.logoutFromApp();
		login.click(login.logoutBtn);
	}
	
	@Test(priority=2, groups="UserManagementFunctionality")
	public void invalidloginTest() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		//menu.navigateTo(menu.loginLink);
		menu.click(menu.loginLink);
		login.loginInApp(USER,"12312313");
		Thread.sleep(500);
		assertTrue(login.checkMsgIsDisplayed(login.errorLoginMsg));
		
	}
}
