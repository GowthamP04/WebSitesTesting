package SeleniumWebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckDropDownSort {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement drpele=driver.findElement(By.name("category_id"));
		
		Select drpselect =new Select(drpele);
		List<WebElement> options=drpselect.getOptions();
		
		ArrayList originallist=new ArrayList();
		ArrayList temperatorylist=new ArrayList();
		
		for (WebElement option : options) {
			originallist.add(option.getText());
			temperatorylist.add(option.getText());
		}
		System.out.println("original list "+originallist);
		System.out.println("temperatory list "+temperatorylist);
		
		Collections.sort(temperatorylist);
		
		System.out.println("original list "+originallist);
		System.out.println("temperatory list "+temperatorylist);
		
		if(originallist.equals(temperatorylist)) {
			System.out.println("Drop down sorted");
		}
		else {
			System.out.println("Drop down unsorted");
		}
		driver.quit();
	}
	
}