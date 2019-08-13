package Testing;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.junit.After;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Testing
{
	public static WebDriver driver;
	@BeforeClass
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/bindumadhavitammireddy/Downloads/chromedriver");
		  driver = new ChromeDriver();
		  driver.navigate().to("https://www.bunnings.com.au/"); 
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			try {
				FileUtils.copyFile(scrFile, new File("~/proects/yourPath.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}
	@Test
	public void scrollbar()
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

			
	}
	@Test
	public void changeStore()
	{
		 driver.findElement(By.cssSelector("#RefreshHeader > header > div.header_top.hide-from-print > div.header_top_content > div.js-header-store_container > div > div > a > span")).click();
		 driver.findElement(By.xpath("//*[@id=\"RefreshHeader\"]/header/div[2]/div[1]/div[4]/div/div[2]/div[2]/div/ul/li[2]/a")).click();
		 try {
				screenshot(driver, "bunning1") ;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	@Test
	public void header_information()
	{
	driver.findElement(By.cssSelector("#RefreshHeader > header > div.header_top.hide-from-print > div.header_top_content > div.header_secondary-menu > ul > li:nth-child(1) > a > span")).click();
	driver.findElement(By.cssSelector("#RefreshHeader > header > div.header_top.hide-from-print > div.header_top_content > div.header_secondary-menu > ul > li:nth-child(3) > a > span")).click();
	driver.findElement(By.cssSelector("#RefreshHeader > header > div.header_top.hide-from-print > div.header_top_content > div.header_secondary-menu > ul > li:nth-child(2) > a > span")).click();
	}

	@Test
	public void image_Links()
	{
	driver.findElement(By.cssSelector("#content-layout_inside-anchor > div.home-gift-cards-banner-wrapper > div > a:nth-child(1)")).click();
	driver.navigate().back();
	}
	@Test
	public void recall_information()
	{
	driver.findElement(By.cssSelector("#slick-slide04 > button")).click();
	driver.findElement(By.cssSelector("#body_2_carouselrefreshcontent_0_TrackingLinkFindOutMore")).click();
	driver.navigate().back();
	}
	
	public void screenshot(WebDriver driver,String path)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("yourPath.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterClass
	public static void closing()
	{
		 try {
			 Thread.sleep(3000);
		 }
		 catch(Exception e) {
			 System.out.print(e);
		 }
		 driver.close();
		 driver.quit();
	}
	
}