package com.qa.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenLinks {
	@Test(groups= {"regression"})
	public void verifyBrokenLinks() {
		BrowserInit bi=new BrowserInit();
		WebDriver driver=bi.initialization("chrome");
		String homepage="https://www.guru99.com/selenium-tutorial.html";
		driver.get(homepage);
		List<WebElement> li=driver.findElements(By.tagName("a"));
		for(WebElement elm:li) {
			String url=elm.getAttribute("href");
			System.out.println(url);
			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				 continue;
				 }
					/*
					 * 
					 * if(!url.startsWith(homepage)){
					 * System.out.println("URL belongs to another domain, skipping it."); continue;
					 * }
					 */
					 
			verifytheURL(url);
		}
		
		driver.close();
	}
	
	public void verifytheURL(String url) {
		int respCode = 200;
		
		try {
			URL urlLink=new URL(url);
			HttpURLConnection huc =(HttpURLConnection) urlLink.openConnection();
			huc.setConnectTimeout(200);
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			if(respCode >= 400){
				System.out.println(url+" is a broken link");
			}
			else{
				System.out.println(url+" is a valid link");
			}

			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

}
