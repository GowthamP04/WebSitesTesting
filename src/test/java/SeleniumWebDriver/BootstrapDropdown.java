package SeleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List<WebElement> producttype=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		selectFromDropDown(producttype,"Loans");

		/*
		 * for (WebElement product : producttype) {
		 * if(product.getText().equals("Loans")) { product.click(); break; } }
		 */

		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement> products=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		selectFromDropDown(products,"Personal Loan");

		/*
		 * for (WebElement product1 : products) {
		 * if(product1.getText().equals("Personal Loan")) { product1.click(); break; } }
		 */
	}

	public static void selectFromDropDown(List<WebElement> options, String value) {

		for (WebElement option : options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}

	}
}