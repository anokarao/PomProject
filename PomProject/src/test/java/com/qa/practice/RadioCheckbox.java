package com.qa.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioCheckbox {

	@Test(groups= {"sanity","regression"})
	public void verifytheRadio() {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("https://demo.guru99.com/test/radio.html");
		WebElement option1=driver.findElement(By.id("vfb-7-1"));
		WebElement option2=driver.findElement(By.id("vfb-7-2"));
		WebElement option3=driver.findElement(By.id("vfb-7-3"));
		System.out.println("option3 is selected-->"+option3.isSelected());
		option2.click();
		System.out.println("option2 is selected-->"+option2.isSelected());
		WebElement checkbox1=driver.findElement(By.id("vfb-6-0"));
		WebElement checkbox2=driver.findElement(By.id("vfb-6-1"));
		WebElement checkbox3=driver.findElement(By.id("vfb-6-2"));
		System.out.println("checkbox1 is selected-->"+checkbox1.isSelected());
		System.out.println("checkbox2 is selected-->"+checkbox2.isSelected());
		checkbox1.click();
		checkbox3.click();

		System.out.println("checkbox1 is selected-->"+checkbox1.isSelected());
		System.out.println("checkbox3 is selected-->"+checkbox3.isSelected());
		driver.close();
	}

}
