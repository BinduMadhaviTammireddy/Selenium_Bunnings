package sel_testing;

import java.io.IOException;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SmokeTest {

public static WebDriver driver;

public static Mymethod method = new Mymethod();

	public static void main(String args[]) throws IOException
	{
		method.setup();
		method.openPage("https://www.bunnings.com.au/"); 
		method.clickCSSSelector("#RefreshHeader > header > div.header_top.hide-from-print > div.header_top_content > div.header_secondary-menu > ul > li:nth-child(1) > a > span");
		method.clickCSSSelector("#RefreshHeader > header > div.header_top.hide-from-print > div.header_top_content > div.header_secondary-menu > ul > li:nth-child(3) > a > span");
		method.clickCSSSelector("#RefreshHeader > header > div.header_top.hide-from-print > div.header_top_content > div.header_secondary-menu > ul > li:nth-child(2) > a > span");
		method.scrollbar(689);
		method.screenshot("abc.png");
		method.previousPage();
		method.clickCSSSelector("#RefreshHeader > header > div.header_middle > div > div.header_navbar.hide-from-print > ul > li:nth-child(1) > a > span");
		method.previousPage();
		method.screenwait();
		method.closeBrowser(); 
	}
	
}   

