package SeleniumWebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleJQueryDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("justAnInputBox")).click();

		//selectChoiceValue(driver,"choice 1");
		//selectChoiceValue(driver,"choice 1","choice 6 1","choice 6 2 3","choice 7","choice 2 2");
		selectChoiceValue(driver,"all");
	}

	public static void selectChoiceValue(WebDriver driver, String... value) {

		List<WebElement> choiceslist=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		if(!value[0].equalsIgnoreCase("all")) {

			for(WebElement item: choiceslist) {
				String text=item.getText();

				for(String val:value) {
					if(text.equals(val)) {

						item.click();
						break;
					}
				}
			}
		}
		else {
			try {

				for(WebElement item: choiceslist) {
					item.click();
				}
			}catch(Exception e) {

			}
		}
	}
}