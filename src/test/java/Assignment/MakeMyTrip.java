package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MakeMyTrip {

	public WebDriver driver;
	@BeforeClass
	public void before() {

		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void method() throws InterruptedException {

		if(driver.findElement(By.xpath("//span[@class='commonModal__close']")).isDisplayed())
		{
			driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		}

		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		Thread.sleep(1000);

		WebElement from=driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.click();
		from.sendKeys("Delhi");

		List<WebElement> fromoptions=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		selectFromDropDown(fromoptions,"Delhi");
		/*
		 * for (WebElement option : options) { if(option.getText().contains("Delhi")) {
		 * option.click(); break; } }
		 */
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		
		Thread.sleep(1000);

		List<WebElement> Tooptions=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		selectFromDropDown(Tooptions,"Dubai");

		/*
		 * for (WebElement option : options) { if(option.getText().contains("Dubai")) {
		 * option.click(); break; } }
		 */

	String month="February 2025";
	String date="12";
	
	while(true)
	{
		String mon=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']//div")).getText();
		
		if(mon.equals(month))
		{
			break;
		}
		driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	}
	
	List<WebElement> allDates=driver.findElements(By.xpath("//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day']"));
	
	for(WebElement dt:allDates)
	{
		if(dt.getText().contains(date))
		{
			dt.click();
			break;
		}
	}
	
	driver.findElement(By.id("toCity")).click();
	Thread.sleep(2000);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement Planning= driver.findElement(By.xpath("//div[@class='makeFlex column intlFlightTile-autosuggest']//p[text()='Planning an international holiday?']"));
	js.executeScript("arguments[0].scrollIntoView();", Planning);
	//Thread.sleep(1000);
	Planning.click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Anytime ']")).click();
	
	String month1="December, 2024";
	
	
	
	List<WebElement> allDates1=driver.findElements(By.xpath("//ul[@class='monthList']//li"));
	
	for(WebElement dt1:allDates1)
	{
		if(dt1.getText().contains(month1))
		{
			dt1.click();
			break;
		}
	}
	
	driver.findElement(By.xpath("//button[text()='Apply']")).click();
	
	List<WebElement> allamount = driver.findElements(By.xpath("//div[@class='textRight']//p[@class='priceDp blackFont fontSize14']"));
	
	double lowerprice = Double.MAX_VALUE;
	for (WebElement amount : allamount) {
		String pricetext = amount.getText().replace("₹", "").trim();
		double price = Double.parseDouble(pricetext);
		
		if(price < lowerprice) {
			lowerprice = price;
			amount.click();
			System.out.println("lowerprice");
		}
	}
	
	
	}
	


	public static void selectFromDropDown(List<WebElement> options, String value) {

		for (WebElement option : options) {
			if(option.getText().contains(value)) {
				option.click();
				break;
			}
		}

	}
}