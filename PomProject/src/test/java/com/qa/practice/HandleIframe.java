package com.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleIframe {
	@Test
	public void IFrameHandleing() {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_frameborder");
		WebElement iframe=driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(iframe);
		WebElement innerframe=driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
		driver.switchTo().frame(innerframe);
		String innterFrameText=driver.findElement(By.tagName("h1")).getText();
		System.out.println(innterFrameText);
		/*
		 * driver.switchTo().parentFrame(); String
		 * firstframetext=driver.findElement(By.tagName("p")).getText();
		 * System.out.println(firstframetext);
		 */
		driver.switchTo().defaultContent();
		String OuterText=driver.findElement(By.id("framesize")).getText();
		System.out.println(OuterText);
	}
}