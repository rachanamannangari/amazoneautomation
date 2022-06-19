package com.amazone.pom;

import java.awt.datatransfer.FlavorListener;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cellphonepage {

	WebDriver driver;
	public Cellphonepage(WebDriver driver)
	{
		this.driver=driver;

	}

	By electronics= By.xpath("//a[contains(text(),'Electronics')]");
	//span[contains(text(),'Cell Phones & Accessories ')]
	By accandcell=By.xpath("//*[@id=\"nav-subnav\"]/a[7]/span");
	By unlockcell=By.xpath("//*[@id=\"nav-subnav\"]/a[7]/span");

	By under25dollar= By.xpath("//*[@id=\"s-refinements\"]/div[16]/ul/li[1]/span/a/span");
	By samsung=By.xpath("//span[contains(text (),'Samsung')]//ancestor::li[contains(@class,'a-spacing-micro')]//child::a");
	By filterprice=By.xpath("//span[contains(text(),'$100 to $200')]//ancestor::ul/li");

	//span[contains(text(),'$100 to $200')]//ancestor::ul/li"
	public void openCellphone()
	{
		driver.findElement(electronics).click();
		driver.findElement(accandcell).click();
		driver.findElement(unlockcell).click();
	}
	public void filter(String samsungmob,String mobileprice)

	{
		try {	
			System.out.println("open samsung mobile");
			driver.findElement(samsung).click();
			List<WebElement> pricelist = driver.findElements(filterprice);
			for (WebElement price : pricelist) {
				System.out.println(price.getText());
				if (price.getText().contains(mobileprice))
				{
					System.out.println("filter price is" +price.getText());
					price.findElement(By.xpath(".//descendant::a")).click();



					System.out.println("test is passed");
				} else
				{
					System.out.println("test is failed");
				}


			}
		}catch(StaleElementReferenceException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void driverClose()
	{
		driver.close();
	}
}
