package SeleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadowDOM1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://shop.polymer-project.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement root=driver.findElement(By.tagName("shop-app"));
		WebElement shadow1= getshadowDom(root, driver);
		WebElement ironpages=shadow1.findElement(By.tagName("iron-pages"));
		WebElement shophome= ironpages.findElement(By.name("home"));
		WebElement shadow2= getshadowDom(shophome, driver);
		
		shadow2.findElement(By.cssSelector("div:nth-child(2) > shop-button >a")).click();

	}
	 static WebElement getshadowDom(WebElement element, WebDriver driver) {
		 
		 JavascriptExecutor js =(JavascriptExecutor)driver;
			WebElement shadow=(WebElement) js.executeScript("return arguments[0].shadowRoot", element);
			return shadow;
	 }
}