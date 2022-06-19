package com.amazone.pom;

import java.util.ArrayList;
import java.util.List;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Searchpage {
	WebDriver driver;
	public Searchpage(WebDriver driver)
	{
		this.driver=driver;
	}
	By searchtext= By.id("twotabsearchtextbox");
	By searchbutton =By.xpath("//div[@class='nav-search-submit nav-sprite']");
	//By selectbrand=By.xpath("//ul[@aria-labelledby=\"p_89-title\"]//li");
	By selectbrand=By.xpath("//ul[@aria-labelledby=\"p_89-title\"]//li[contains(@id,p_89)]");
	//ul[@aria-labelledby="p_89-title"]//li
	//By searchresult=By.xpath("//div[contains(@data-asin,'B0')][1]//a[contains(@class,'underline-text')]/span");
	By searchparent= By.xpath("//div[contains(@data-asin,'B0')]");
	By resultlink = By.xpath("//div[contains(@data-asin,'B0')]//a[contains(@class,'underline-text')]/span//parent::a");
	public void searchData(String data)
	{
		driver.findElement(searchtext).sendKeys(data);
		driver.findElement(searchbutton).click();
	}
	public void selectBrand(String data1) throws InterruptedException
	{
		try{
			List<WebElement> brands = driver.findElements(selectbrand);

			for ( WebElement brand : brands) {

				String brandname=	brand.getAttribute("aria-label");
				//brand.findElement(by)
				System.out.println("brandnames are"+ brandname);
				try
				{
					if(brandname==null)
					{

					}
				}

				catch(Exception e)
				{
					e.getStackTrace();
				}
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("scroll(0,300);");
				if(brandname.contains(data1)) {
					Thread.sleep(5000);
					brand.findElement(By.xpath("//li[contains(@aria-label,'Dell')]//a")).click();
					Thread.sleep(5000);


				}


			}
		}

		catch(StaleElementReferenceException e)
		{
			e.getMessage();
		}


	}
	public List<String> searchResult()
	{
		List<WebElement>resultsetdiv= driver.findElements(searchparent);

		System.out.println("resulset are" +resultsetdiv.size());
		List <String>searchname = new ArrayList<String>();

		for (WebElement parentdiv : resultsetdiv) {
			List<WebElement> alldetails = parentdiv.findElements(By.xpath(".//a[contains(@class,'underline-text')]/span"));

			try {
				if(alldetails.size()>0)
				{
					//System.out.println("size of details" +alldetails.size());
					String name=alldetails.get(0).getText();
					System.out.println("laptop name is " +name);
					String rating=alldetails.get(1).getText();
					System.out.println("laptop rating is "+rating);
					String price= alldetails.get(2).getText();
					System.out.println("laptop price is" +price);
					searchname.add(name);


				}
			}catch(IndexOutOfBoundsException e)
			{
				e.getStackTrace();
			}catch(NullPointerException e)
			{
				e.getMessage();
			}




		}
		return searchname;
	}
	public void  validateSearch(List<String>actualset,List<String>expset )

	{
		try {
			Boolean flag=null;
			//for (String dellname : expset)
			for(int cnt1=0;cnt1<=4;cnt1++)
			{
				for(int cnt=0;cnt<actualset.size();cnt++)
				{
					//expset.get(0).contains(s)
					//System.out.println(actualset.size());

					String dellname=expset.get((cnt1));

					//System.out.println("actual result are" +actualset.get(cnt));
					if (actualset.get(cnt).contains(dellname)) {
						flag=true;

					} else {
						flag=false;
					}


				}
				if (flag==true) {
					System.out.println("test is passed");

				} else {
					System.out.println("test is not passed");
				}
			}



		}catch(NullPointerException e)
		{
			e.getMessage();
		}

	}



	public void clickSearch()
	{
		driver.findElement(resultlink).click();
	}


	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.quit();

	}

}
