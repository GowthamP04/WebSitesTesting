package SeleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutocompleteGooglePlaceDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement searchbox=driver.findElement(By.id("autocomplete"));
		Thread.sleep(1000);
		searchbox.clear();
		Thread.sleep(1000);
		searchbox.sendKeys("Toronto");
		
		String text;
		
		do {
			searchbox.sendKeys(Keys.ARROW_DOWN);
			text=searchbox.getAttribute("value");
			
			if(text.equals("Toronto,ON,USA")) {
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
			
			Thread.sleep(3000);
			
		}while(!text.isEmpty());
	
	}

}