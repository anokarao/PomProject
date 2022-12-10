package com.qa.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DynamicTableHandling {

	@Test(groups= {"sanity","regression"})
	public void dynamictblhandle() {
		
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("http://demo.guru99.com/popup.php");

		driver.close();
	}

}
