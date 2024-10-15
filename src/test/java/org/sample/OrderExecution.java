package org.sample;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderExecution {
	public class Rerun {
		WebDriver driver;
		@BeforeClass
		private  void openChrome() {
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			
		}
		
		@BeforeMethod
		private void starttime() {
			driver.get("https://www.facebook.com/login");
			driver.manage().window().maximize();
			Date d = new Date();
			System.out.println("Start time:"+d);
		}
		
		@Test(priority=0)
		private void logIn() {
			 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Virat@gmail.com");
			 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("virat");
			 driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
			 System.out.println("login passed");
			
		}
		@AfterMethod
		private void endTime() {
			Date d = new Date();
			System.out.println("End time:"+d);
		}
		
		
		@Test(priority=1)
		private void AgainlogIn() {
			 driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Dhonichennai");
			 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("dhoni");
			 driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
			 Assert.assertTrue(false, "Againlogin");
			 System.out.println("login passed");
			
		}
		


	}
}
