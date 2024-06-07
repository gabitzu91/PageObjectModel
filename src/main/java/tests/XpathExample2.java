package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Selenium.utils.BaseTest;

public class XpathExample2 extends BaseTest{

	@Test
	public void xpathExample() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//parent
		/*
		 * selectam un element pe baza elementului copil
		 * 1.--> folosind parent::
		 * 2.--> folosind /..
		 * 
		 */
		
		//1.--> folosind parent::
		driver.findElement(By.xpath("//a[@href='#popup_login']/parent::li[@class='menu_user_login']")).click();
		
		//2.--> folosind /..
		WebElement loginForm = driver.findElement(By.xpath("//ul//div[contains(@class, 'login_field')]/..\r\n"
				+ ""));
		jse.executeScript("arguments[0].setAttribute('style', 'background:pink ;border:10px solid green')", 
				loginForm);
		
		//child
		WebElement user = driver.findElement(By.xpath("//ul//form/child::div/child::input[@name='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				user);
		user.sendKeys("Testceva");
		
		/*
		 * 
		 * 
		 * 
		 * */
		
		WebElement pass = driver.findElement(By.xpath("//ul//input[@name='redirect_to']/following-sibling::div[contains(@class, 'pass')]/child::input"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				pass);
		pass.sendKeys("Nimic");
		
		WebElement forgotPass = driver.findElement(By.xpath("//ul//div[contains(@class, 'submit_field')]/preceding-sibling::div/child::a[@class='forgot_password']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange ;border:10px solid green')", 
				forgotPass);
		
		WebElement rememberMe = driver.findElement(By.xpath("//a[text()='123-456-7890']/following::input[@id='rememberme']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange ;border:10px solid green')", 
				rememberMe);
		rememberMe.click();
		
		WebElement loginBtn = driver.findElement(By.xpath("//div[@class='top_panel_middle']/preceding::input[@value='Login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange ;border:10px solid green')", 
				loginBtn);
		loginBtn.click();
		
	}
}
