package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {

	public WebDriver driver;
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//locatori/webelements
	/*
	 * driver.findElement(By.linkText("Login"))
	 * */
	public By loginLink = By.linkText("Login");
	public By contactsLink = By.linkText("CONTACTS");
	
	//WebElement loginButton = driver.findElement(By.linkText("Login"));
	//WebElement contactsButton = driver.findElement(By.linkText("CONTACTS"));
	
	//metode specifice functionalitatii pe care o au
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	//navigateTo(contactsLink)
	//navigateTo(loginLink)
	
	/*public void navigateToLogin() {
		loginButton.click();
	}
	public void navigateToContacts() {
		loginButton.click();
	}*/
}
