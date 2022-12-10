package com.qa.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindElelemnts {

	@Test(groups= {"sanity"})
	public void testFindElements() {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("https://demo.guru99.com/test/ajax.html");
		List<WebElement> WEList=driver.findElements(By.xpath("//input[@type='radio']"));
		for(WebElement ele:WEList) {
			System.out.println(ele.getAttribute("value"));
		}
		driver.findElement(By.xpath("(//a[@title='Home'])[1]")).click();
		driver.close();

	}

}
