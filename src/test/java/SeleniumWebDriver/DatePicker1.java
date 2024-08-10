package SeleniumWebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://bookonwardticket.com/dummy-ticket/?gad_source=1&gclid=EAIaIQobChMI5_2Y5NbHhwMVzVgPAh0RlRjQEAMYAyAAEgLAafD_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap dummy-departure-date']")).click();

		Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByVisibleText("Oct");

		Select year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByVisibleText("2027");

		String date = "15";

		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

		for (WebElement dat : alldates) {
			String dt=dat.getText();

			if(dt.equals(date)) {
				dat.click();
				break;
			}
		}

	}

}