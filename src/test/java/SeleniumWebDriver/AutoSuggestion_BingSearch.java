package SeleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion_BingSearch {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");

		List<WebElement> options=driver.findElements(By.xpath("//li[@class='sa_sg']//span"));

		for (WebElement option : options) {
			if(option.getText().equals("selenium tutorial")) {
				option.click();
				break;
			}
		}
	}

}