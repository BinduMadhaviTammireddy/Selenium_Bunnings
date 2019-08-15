package sel_testing;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mymethod {
	public static WebDriver driver;
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/bindumadhavitammireddy/Downloads/chromedriver");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void openPage(String url) 
	{
		driver.navigate().to(url);
	}
	
	public void scrollbar(int num)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+num+")");
			
	}
	public void screenwait()
	{
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void closeBrowser()
	{
		 driver.close();
		 driver.quit();
	}
	public void clickCSSSelector(String selector)
	{
		driver.findElement(By.cssSelector(selector)).click();
	}
	public void previousPage()
	{
		driver.navigate().back();
	}
	public void screenshot(String path) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
	    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    File DestFile=new File(path);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);
	}

}
