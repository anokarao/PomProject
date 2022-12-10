package com.qa.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectClass {

	@Test(groups= {"sanity","regression"})
	public void verifyTheSelect() throws InterruptedException {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement cityDropdown=driver.findElement(By.xpath("//select[@name='country']"));
		Select sel=new Select(cityDropdown);
		System.out.println("dropdown is multiple-->"+sel.isMultiple());
		System.out.println("selected option-->"+sel.getFirstSelectedOption().getText());
		sel.selectByValue("ANDORRA");
		System.out.println("selected option-->"+sel.getFirstSelectedOption().getText());
		sel.selectByVisibleText("AZERBAIJAN");
		System.out.println("selected option-->"+sel.getFirstSelectedOption().getText());
		driver.navigate().to("https://output.jsbin.com/osebed/2");
		WebElement fruits=driver.findElement(By.id("fruits"));
		Select selfruits=new Select(fruits);
		System.out.println("fruits is multiple-->"+selfruits.isMultiple());
		List<WebElement> fruitList=selfruits.getOptions();
		for(WebElement fruit:fruitList) {
			System.out.println(fruit.getText());
			if(fruit.getText().equalsIgnoreCase("Apple")) {
				fruit.click();
			}
			else if(fruit.getText().equalsIgnoreCase("Grape")) {
				fruit.click();
				
			}
		}
		List<WebElement> selectedfruitList=selfruits.getAllSelectedOptions();
		for(WebElement fruit:selectedfruitList) {
			System.out.println("selected option is-->"+fruit.getText());
		}
		Thread.sleep(10000);
		selfruits.deselectAll();
		List<WebElement> deselectedfruitList=selfruits.getAllSelectedOptions();
		for(WebElement fruit:deselectedfruitList) {
			System.out.println("selected option is-->"+fruit.getText());
		}
		driver.close();

	}

}
