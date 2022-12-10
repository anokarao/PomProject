package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()  {
		try {
			prop=new Properties();
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() 
	{
		String browserName="chrome";
		
		if(browserName.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
	}
	

}
