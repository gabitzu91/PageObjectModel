package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Selenium.utils.BaseTest;

public class DropdownTest extends BaseTest{

	@Test(priority=1, groups="ShopFunctionality")
	public void selectByValueTest() {
		app.click(app.menu.shopLink);
		app.shop.selectByValue("date");
		assertEquals(app.shop.getSelectedOption(),"Sort by latest");
	}
	
	@Test(priority=2, groups="ShopFunctionality")
	public void selectByVisibleTextTest() {
		app.click(app.menu.shopLink);
		app.shop.selectByVisibleText("Sort by popularity");
		assertEquals(app.shop.getSelectedOption(),"Sort by popularity");
	}
	
	@Test(priority=3, groups="ShopFunctionality")
	public void selectByIndexTest() {
		app.click(app.menu.shopLink);
		app.shop.selectByIndex(5);
		assertEquals(app.shop.getSelectedOption(),"Sort by price: high to low");
	}
}
