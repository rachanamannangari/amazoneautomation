package com.amazone.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazone.pom.Cellphonepage;
import com.amazone.pom.Menupage;

public class Menutest {
	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS );
		Menupage page=new  Menupage(driver);
		page.getScreeshot();
		page.openBestsellers();
		page.openFashion();
		page.openElectronics();

		Cellphonepage page1= new Cellphonepage(driver);
		page1.openCellphone();
		page1.filter("samsungmob","$100 to $200");
        page1.driverClose();
	}
}

