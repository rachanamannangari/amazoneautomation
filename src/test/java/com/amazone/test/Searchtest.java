package com.amazone.test;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazone.pom.Searchpage;

public class Searchtest {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca");
		
		Searchpage page= new Searchpage(driver);
		page.searchData("laptop");
		page.selectBrand("Dell");
		List<String> expectedset=page.searchResult();
		dataConnect connect=new dataConnect();
		connect.getConnection();
		List<String> dataset = connect.selectData();
	
		page.validateSearch(dataset,expectedset);
		page.clickSearch();
		
		
		
		page.closeBrowser();
		
		

	}

}
