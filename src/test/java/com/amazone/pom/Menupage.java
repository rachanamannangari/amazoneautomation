package com.amazone.pom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Menupage {
	WebDriver driver;
	public Menupage(WebDriver driver)
	{
		this.driver=driver;

	}


	By bestseller=By.xpath("//a[contains(text(),'Best Sellers') and contains(@class,'nav-a')]");
	By fashion=By.xpath("//a[contains(text(),'Fashion')]");
	By electronics= By.xpath("//a[contains(text(),'Electronics')]");


	public void getScreeshot() throws IOException
	{
		String title=driver.getTitle();
		System.out.println("title" +title);
		if (title.contains("Amazon.ca")){
			System.out.println("title matching test is passed");

		} else {
			System.out.println("test is not passed");
		}

		TakesScreenshot shot=(TakesScreenshot)driver;
		File evidence = shot.getScreenshotAs(OutputType.FILE);

		File file= new  File("/home/rachanabijoygma/rachana-workspace/Amazoneauto/target/screen.png");
		file.createNewFile();
		FileUtils.copyFile(evidence, file);
	}

	public void openBestsellers()
	{
		driver.findElement(bestseller).click();
		System.out.println("Open best seller page");
		driver.navigate().back();
	}

	public void openFashion()
	{
		driver.findElement(fashion).click();
		System.out.println("open fashion page");
		driver.navigate().back();
	}
	public void openElectronics() throws InterruptedException
	{
		
		driver.findElement(electronics).click();
	}
	public void closeDriver()
	{
		driver.close();
	}
}
