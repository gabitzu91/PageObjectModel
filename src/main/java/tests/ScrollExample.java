package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Selenium.utils.BaseTest;

public class ScrollExample extends BaseTest{
	
	//@Test
	public void scrollByAmmount() {
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 800).perform();
		
		app.scrollVertically(800);
		app.scrollHorizontally(800);
	}
	
	//@Test
	public void scrollToElement() {
		Actions action = new Actions(driver);
		action.scrollToElement(app.getWebElement(app.home.chooseBookText)).perform();
		//action.moveToElement(app.getWebElement(app.home.chooseBookText)).perform(); //predefinita din Selenium
		
	}

	@Test
	public void scrollDownOrTop() throws InterruptedException{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.HOME).perform();
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		
	}
}
