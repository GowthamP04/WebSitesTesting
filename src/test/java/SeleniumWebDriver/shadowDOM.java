package SeleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class shadowDOM {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.id("input")).sendKeys("testing");//NoSuchElementException
		
		WebElement root=driver.findElement(By.tagName("book-app"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement shadow=(WebElement) js.executeScript("return arguments[0].shadowRoot", root);
		WebElement appheader=shadow.findElement(By.tagName("app-header"));
		WebElement apptoolbar =appheader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
		WebElement bookinputdecorator =apptoolbar.findElement(By.tagName("book-input-decorator"));
		bookinputdecorator.findElement(By.cssSelector("input#input")).sendKeys("testing");
		bookinputdecorator.sendKeys(Keys.ENTER);
		
		driver.quit();

	}

}