package com.qa.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class BrowserInit {

	static WebDriver driver;
	@Test(groups= {"sanity","regression"})
	public void runBrowser() {
		BrowserInit bi=new BrowserInit();
		bi.initialization("ff");
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("9581014982");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).sendKeys("9642255573");
		driver.findElement(By.name("login")).submit();
		String url=driver.getCurrentUrl();
		String PageTitle=driver.getTitle();
		String pageSource=driver.getPageSource();
		//driver.findElement(By.name("login")).click();
		//driver.close();
		System.out.println("----------------------------------");
		System.out.println("url-->"+url);
		System.out.println("PageTitle-->"+PageTitle);
		
		//System.out.println("pageSource-->"+pageSource);
		driver.close();
	}
	public WebDriver initialization(String browser) 
	{
		if(browser.equalsIgnoreCase("chrome")) 
		{
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ff")) {
			System.out.println("---------------------------");
			
			driver=new FirefoxDriver();
			System.out.println("---------------------------");

		}
		else if(browser.equalsIgnoreCase("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		return driver;
	}

}
