package com.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {

	@Test(groups= {"sanity","regression"})
	public void verifytheMousehover() {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("http://demo.guru99.com/test/newtours/");
		WebElement flightsLink=driver.findElement(By.linkText("Flights"));
		Actions action=new Actions(driver);
		action.moveToElement(flightsLink).perform();
		driver.close();
	}

}
