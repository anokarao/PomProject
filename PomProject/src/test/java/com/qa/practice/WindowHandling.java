package com.qa.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WindowHandling {

	@Test(groups= {"sanity","regression"})
	public void windowHandle() {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.linkText("Click Here")).click();
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		while(itr.hasNext()) {
			String childwindow=itr.next();
			if(!childwindow.equals(mainWindow)) {
				driver.switchTo().window(childwindow);
				System.out.println(driver.getTitle());
				driver.findElement(By.name("btnLogin")).click();
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.close();
	}

}
