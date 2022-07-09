// Importing the required libraries
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumGSearch {

	public static void main(String[] args) {

		//Invoking browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rajesh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver chromedriver=new ChromeDriver();
	    
		// Open Google.com in a Chrome browser
		chromedriver.get("https://www.google.com/");
		
	    //identify element of search box and add the value to search and ENTER
	    WebElement Gsearchbox = chromedriver.findElement(By.name("q"));
	    Gsearchbox.sendKeys("Playtech BGT Sports");
	    Gsearchbox.sendKeys(Keys.RETURN);
	    
		// Explicit wait condition for search results
	    WebDriverWait webdwait = new WebDriverWait(chromedriver, Duration.ofSeconds(10));
	    
	    // identify element with link text
	    WebElement m =chromedriver.findElement(By.partialLinkText("Playtech BGT"));
	    m.click();    
//		System.out.println(chromedriver.getTitle());
	    webdwait.until(ExpectedConditions.titleIs("Playtech :: Playtech BGT Sports finalises executive team"));

	    // Check if the age verification pop-up is displayed
	    boolean AgeVerPopUp  = chromedriver.findElements(By.id("age-verification")).isEmpty();
	    
	    if(false == AgeVerPopUp)
	    {
	    	// Wait till page loads ?
	    	// Select Date
	    	Select dropDdDate = new Select(chromedriver.findElement(By.name("day")));
	    	dropDdDate.selectByVisibleText("11");
	    	// Select Month
	    	Select dropDdMonth = new Select(chromedriver.findElement(By.name("month")));
	    	dropDdMonth.selectByVisibleText("11");
	    	// Select Year
	    	Select dropDdYear = new Select(chromedriver.findElement(By.name("year")));
	    	dropDdYear.selectByVisibleText("1995");
	    
	    	// Click enter to go to page
	    	WebElement EnterSite = chromedriver.findElement(By.xpath("//button[text()='Enter Site']"));
	    	EnterSite.click();
	    }
	    else
	    {
	    	// No pop up for age verification is displayed..
	    	// continue with out any age details fill
	    }
	    
	    // Finding the logo -- image
	    WebElement imageLogo = chromedriver.findElement(By.xpath("//img[@title='Playtech']"));
	    Boolean logoPresent = (Boolean) ((JavascriptExecutor)chromedriver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", imageLogo);
	    
	    // Logo presence status 
	    if(logoPresent)
	    {
	    	System.out.println("Logo is found in the page");
	    	
	    	// TODO : To find the logo position is present in the top left
	    	//chromedriver.verifyElementPositionLeft 
	    }
	    else
	    {
	    	System.out.println("No Logo is found in the current page");
	    }
		chromedriver.close();
	}
}
