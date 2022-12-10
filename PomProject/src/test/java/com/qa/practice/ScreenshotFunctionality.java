package com.qa.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ScreenshotFunctionality {
	String path="C:\\Users\\arao\\eclipse-workspace\\PomProject\\src\\main\\java\\com\\qa\\outputFiles";
	@Test
	public void taskeScreenshot() {
	BrowserInit bi=new BrowserInit();
	WebDriver driver=bi.initialization("ff");
	driver.get("http://demo.guru99.com/test/newtours/");
	File feature=driver.findElement(By.xpath("//img[@alt='Featured Destination: Aruba']")).getScreenshotAs(OutputType.FILE);
	File FeatDestFile=new File(path+"//Featuretest.png");
	try {
		FileUtils.copyFile(feature, FeatDestFile);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	TakesScreenshot ts=(TakesScreenshot) driver;
	File file=ts.getScreenshotAs(OutputType.FILE);
	File DestFile=new File(path+"//test.png");
	try {
		FileUtils.copyFile(file, DestFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
