package SeleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String month = "October";
		String year = "2024";
		String date = "October";
		
		driver.findElement(By.id("date-box")).click();
		
		while(true) {
			
			String monthyear = driver.findElement(By.xpath("(//div[@class='DayNavigator__CalendarHeader-sc-1tlckkc-1 ccLrBz'])[1]")).getText();
			
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			
			if(mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
				break;
			
			else {
				driver.findElement(By.xpath("//div[@id='next']/svg/path")).click();
				
			}

			List<WebElement> alldates=driver.findElements(By.xpath("//span[@class='DayTilesWrapper__DayWrapper-moo2xh-1 loqlv']/span/div"));
			for (WebElement ele : alldates) {
				String dt=ele.getText();
				
				if(dt.equals(date)) {
					ele.click();
					break;
				}
			}
		}
		

	}

}