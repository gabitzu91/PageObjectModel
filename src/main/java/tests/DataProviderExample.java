package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.utils.PropertiesFileProcessor;
import Selenium.utils.BaseTest;
import pageObjects.LoginPage;
import pageObjects.MenuPage;

public class DataProviderExample extends BaseTest{
	/*
	 * int[] number = new int[6]
	 * 		 number = {1,4,3,7,8,9}
	 * 		 index =   0 1 2 3 4 5
	 * number[2]=->3
	 * 
	 * int[][] number = new int[4][3]
	 * 		   number = {{1,4,2},{2,4,5},{3,2,1},{9,8,7}}
	 * 			index =     0		1		2		3
	 * 			index		  0 1 2	  0 1 2   0 1 2	  0 1 2
	 * number[2][0]==>3
	 * number[3][2]=->7
	 */
	
	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.Properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.Properties");
	
	@DataProvider(name="testDataForLogin")
	public Object[][] loginTestData(){
		Object[][] data = new Object[4][3];
		
		data[0][0] = USER;
		data[0][1] = PASS;
		data[0][2] = true;
		
		data[1][0] = "UserGresit";
		data[1][1] = PASS;
		data[1][2] = false;
		
		//LoginPage login = new LoginPage(driver);

		data[2][0] = USER;
		data[2][1] = PASS;
		data[2][2] = true;
		//data[2][2] = login.successLoginMsg;
		
		data[3][0] = USER;
		data[3][1] = "ParolaGresita";
		data[3][2] = false;
		//data[3][2] = login.errorLoginMsg;
		
		return data;
	}
	
	@Test(dataProvider="testDataForLogin")
	public void loginTest(String username, String password, boolean expected) throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		//menu.navigateTo(menu.loginLink);
		menu.click(menu.loginLink);
		login.loginInApp(username,password);
		Thread.sleep(500);//de la el e acel Interrupted...
		if(expected) {
			assertTrue(login.checkMsgIsDisplayed(login.successLoginMsg));
			Thread.sleep(3000);
			//login.logoutFromApp();
			login.click(login.logoutBtn);
		}else {
			assertTrue(login.checkMsgIsDisplayed(login.errorLoginMsg));
			Thread.sleep(3000);
			//login.logoutFromApp();
			login.click(login.closeLoginPopUp);
		}
		
	}

}
