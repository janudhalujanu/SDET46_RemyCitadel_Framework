package com.Owner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Owner {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		//owner Register

		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Damon Salvotor");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Damon");
		driver.findElement(By.xpath("//input[@id='mobible']")).sendKeys("8766787867");
		//driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Damon@gmail.com");
		//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Damon123");
		driver.findElement(By.xpath("//input[@id='c_password']")).sendKeys("Damon123");
		driver.findElement(By.name("register")).click();
		String verify = driver.findElement(By.xpath("//div[text()='Registration successfull. Now you can login']")).getText();
		//owner login
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("jyo");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("jyo");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//Owner Apartment egister
		driver.findElement(By.xpath("//a[text()='Individual Home Registration']")).click();
		
		driver.findElement(By.id("fullname")).sendKeys("chotu");
		driver.findElement(By.id("mobile")).sendKeys("1234567898");
		driver.findElement(By.id("alternat_mobile")).sendKeys("9876543212");
		driver.findElement(By.id("email")).sendKeys("chotu123@gmail.com");
		driver.findElement(By.id("plot_number")).sendKeys("101");
		driver.findElement(By.id("rooms")).sendKeys("2BHK");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("state")).sendKeys("karnataka");
		driver.findElement(By.id("city")).sendKeys("banglore");
		driver.findElement(By.id("rent")).sendKeys("1000");
		driver.findElement(By.id("sale")).sendKeys("4");
		driver.findElement(By.id("deposit")).sendKeys("45000");
		driver.findElement(By.id("accommodation")).sendKeys("2 attach bath room single hall 2 bed room");
		driver.findElement(By.id("description")).sendKeys("only for family");
		driver.findElement(By.id("landmark")).sendKeys("Banglore near Askoka hotel 560065");
		driver.findElement(By.id("address")).sendKeys("Banglore jayanagar karnataka corporation circle");
		WebElement Text = driver.findElement(By.id("vacant"));
		Select S=new Select(Text);
		S.selectByVisibleText("Vacant");
		driver.findElement(By.xpath("(//input[@id='image'])[1]")).sendKeys("C:\\Users\\HP\\Desktop\\Web technology\\image\\shiva-1594171271.jpg");
		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		

	}

}
