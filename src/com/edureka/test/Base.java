package com.edureka.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Base{
	static WebDriver driver;
	@Test(priority=1, dependsOnMethods = {"Login"})
	public void SignUp() {
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("sg_popup_email")).sendKeys("tulikagetsmails@gmail.com");
		driver.findElement(By.id("sg_popup_phone_no")).sendKeys("5087360342");
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block signup-new-submit']")).click();
		
	}
	@Test(priority=0)
	public void Login() throws InterruptedException {
		driver.findElement(By.linkText("Log In")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='si_popup_email']")).sendKeys("tulikagetsmails@gmail.com");
		driver.findElement(By.xpath("//input[@id='si_popup_passwd']")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")).click();
		//Browse all courses
       
		driver.findElement(By.xpath("//*[@id='footauto']/app-root/app-mycourse-main/section/app-header-breadcrumb/section/div/div/div[1]/span[2]/a")).click();
		//Logout
		driver.findElement(By.xpath("//span[@class='webinar-profile-name']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.edureka.co/signout']")).click();
	}
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(35,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//navigate	  
		driver.navigate().to("https://www.edureka.co/");

		driver.manage().window().maximize() ;
	}
}
		