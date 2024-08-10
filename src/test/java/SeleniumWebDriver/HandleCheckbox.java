package SeleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckbox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1.select specific check box
		//driver.findElement(By.id("//input[@id='sunday']")).click();
		
		//2.select all the check box
		List<WebElement> checkboxs=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		/*
		 * for(int i=0;i<checkboxs.size();i++) { checkboxs.get(i).click(); }
		 */
		//for each loop
		/*
		 * for (WebElement check : checkboxs) { check.click(); }
		 */
		//select multiple checkbox by choice
		/*
		 * for (WebElement check : checkboxs) { String
		 * checkboxname=check.getAttribute("id");
		 * 
		 * if(checkboxname.equals("monday") || checkboxname.equals("sunday")) {
		 * check.click(); } }
		 */
		
		//select last 2 checkbox
		for(int i=checkboxs.size()-2;i<checkboxs.size();i++) {
			checkboxs.get(i).click();
		}
	}
}