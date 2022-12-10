package com.qa.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AlertPopupHandling {

	@Test(groups= {"sanity","regression"})
	public void alertHandling() {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys("");
		driver.switchTo().alert().getText();
		driver.close();

	}

}
