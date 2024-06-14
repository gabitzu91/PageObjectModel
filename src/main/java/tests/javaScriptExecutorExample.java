package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Selenium.utils.BaseTest;

public class javaScriptExecutorExample extends BaseTest{
	
	@Test
	public void example1() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		/*jse.executeScript("", obj1, obj2, obj3);//obiect...args {obj1, obj2, obj3}
												//index				0	1		2
		jse.executeScript("arguments[1]", obj1, obj2, obj3);*/
	/*	
		//alternativa pentru click() cel din Selenium
		jse.executeScript("arguments[0].click()", app.getWebElement(app.menu.searchIcon));
		//alternativa pentru sendKeys()
		jse.executeScript("arguments[0].value='Storm'", app.getWebElement(app.menu.searchInput));
		jse.executeScript("arguments[0].click()", app.getWebElement(app.menu.searchIcon));
	*/	
	/*	jse.executeScript("arguments[0].click();"
				+ "arguments[1].value='Storm';"
				+ "arguments[0].click()", 
				app.getWebElement(app.menu.searchIcon), 
				app.getWebElement(app.menu.searchInput));
		*/
		
		//caz in care nu merge cu Selenium, insa nu poate fi refolosit
		jse.executeScript("document.getElementsByClassName('icon-search')[0].click();"
				+ "document.getElementsByClassName('search_field')[0].value='cooking';"
				+ "document.getElementsByClassName('icon-search')[0].click()");
	}

}
