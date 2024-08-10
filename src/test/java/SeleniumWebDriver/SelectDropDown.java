package SeleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectDropDown {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/*
		 * Select country=new Select(
		 * driver.findElement(By.id("Form_getForm_Country")));
		 * country.selectByVisibleText("Australia");
		 *
		 * Select employee=new Select(
		 * driver.findElement(By.id("Form_getForm_NoOfEmployees")));
		 * employee.selectByVisibleText("26 - 50");
		 */
		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		selectOptionfromDropDown(country,"Australia");

		WebElement employee = driver.findElement(By.id("Form_getForm_NoOfEmployees"));
		selectOptionfromDropDown(employee,"26 - 50");

	}

	public static void selectOptionfromDropDown(WebElement ele, String value) {

		Select drp = new Select(ele);

		List<WebElement> options=drp.getOptions();

		for (WebElement option : options) {

			if(option.getText().equals(value)){

				option.click();
				break;
			}
		}

	}

}

