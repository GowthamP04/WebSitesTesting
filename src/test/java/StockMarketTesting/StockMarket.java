package StockMarketTesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StockMarket {

	public static WebDriver driver;
	static String Nextearningsreport;
	static String Value1;
	static String Volume;
	static String Value2;
	static String AverageVolume;
	static String Value3;
	static String Marketcapitalization;
	static String Value4;
	static String Dividendyield;
	static String Value5;
	static String Pricetoearnings;
	static String Value6;
	static String BasicEPS;
	static String Value7;
	static String Sharesfloat;
	static String Value8;
	static String Beta;
	static String Value9;
	static ArrayList<String> FinalData = new ArrayList<String>();
	int i;
	static String dayEle;
	static String oneMonthEle;
	static String oneYearEle;

	@BeforeClass
	public void before() {

		// WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://in.tradingview.com/chart/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void test1() throws IOException, InterruptedException {

		// driver.findElement(By.xpath("//*[@id='header-toolbar-intervals']/button/div/div")).click();
		// driver.findElement(By.xpath("//span[text()='1 month']")).click();
		// Thread.sleep(1000);

		// driver.findElement(By.xpath("//div[@class='dropdown-S_1OCXUK']//div[normalize-space()='Days']")).click();
		// List<WebElement>
		// options=driver.findElements(By.xpath("//div[@class='accessible-NQERJsv9
		// menuItem-RmqZNwwp item-jFqVJoPk']"));
		// System.out.println("total :"+options.size());
		/*
		 * for (WebElement opt : options) { if(opt.getText().equals("3 months")) {
		 * opt.click(); break; } }
		 */

		List<String> data = new ArrayList<>(Arrays.asList("ITC","IRFC","PFC"));

		for (int i = 0; i < data.size(); i++) {
			FinalData.add("Stock Name: " + data.get(i) + "<");
			method(data.get(i));
		}

		System.err.println("---" + FinalData);
		WriteAndPrintExcel.writemethod(FinalData);

	}

	public void method(String stock) throws InterruptedException, IOException {

		driver.findElement(By.xpath("//div[@class='group-MBOVGQRI']//button[@id='header-toolbar-symbol-search']"))
				.click();
		WebElement text = driver.findElement(By.xpath("//input[@placeholder='Search'][1]"));
		text.clear();
		text.sendKeys(stock);

		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println("Title is : " + title);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("D:\\Eclipse Web\\WebSitesTesting\\screenshots\\" + stock + ".png");
		FileUtils.copyFile(src, trg);
		Thread.sleep(2000);

		ClickMethod1("//div[@class='dateRangeWrapper-BXXUwft2']//div//button//div[text()='1D']");
		Thread.sleep(2000);
		ClickMethod2("//div[@class='dateRangeWrapper-BXXUwft2']//div//button//div[text()='1M']");
		Thread.sleep(2000);
		ClickMethod3("//div[@class='dateRangeWrapper-BXXUwft2']//div//button//div[text()='1Y']");

		getText1("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']");
		getText2("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']");
		getText3("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']");

		double dayValue = Double.parseDouble(dayEle);
		double oneMonthValue = Double.parseDouble(oneMonthEle);
		double oneYearValue = Double.parseDouble(oneYearEle);

		if (dayValue > oneMonthValue) {
			System.out.println("The stock market value has increased from 1 month to this per Day");
		} else if (dayValue < oneMonthValue) {
			System.out.println("The stock market value has decreased from 1 month to this per Day");
		} else {
			System.out.println("The stock market value is the same as value");
		}

		if (oneYearValue > dayValue) {
			System.out.println("The stock market value has increased from 1 year to this per Day");
		} else if (oneYearValue < dayValue) {
			System.out.println("The stock market value has decreased from 1 year to this per Day");
		} else {
			System.out.println("The stock market value is the same as value");
		}
		
	

		Thread.sleep(2000);

		List<WebElement> allelements = driver
				.findElements(By.xpath("//div[@class='sliderRow-k2h4OAz8 dateRange-BXXUwft2 tabs-NGf0gcnH']/button"));

		for (int i = 0; i < allelements.size(); i++) {
			WebElement element = allelements.get(i);
			element.click();

			Thread.sleep(2000);

			TakesScreenshot ts1 = (TakesScreenshot) driver;
			File src1 = ts1.getScreenshotAs(OutputType.FILE);
			File trg1 = new File("D:\\Eclipse Web\\WebSitesTesting\\snapshot\\" + stock + (i + 1) + ".png");
			FileUtils.copyFile(src1, trg1);

		}

		String stockprice = driver.findElement(By.xpath("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']")).getText();
		System.out.println("Stock price: " + stockprice);

		String Nextearningsreport = commonMethod.methodElement1("//span[text()='Next earnings report']", driver);
		String Value1 = commonMethod.methodValue1("(//span[@class='data-cXDWtdxq'])[1]", driver);
		String Volume = commonMethod.methodElement2("//span[text()='Volume']", driver);
		String Value2 = commonMethod.methodValue2("(//span[@class='data-cXDWtdxq'])[2]", driver);
		String AverageVolume = commonMethod.methodElement3("//span[text()='Average Volume (30D)']", driver);
		String Value3 = commonMethod.methodValue3("(//span[@class='data-cXDWtdxq'])[3]", driver);
		String Marketcapitalization = commonMethod.methodElement4("//span[text()='Market capitalization']", driver);
		String Value4 = commonMethod.methodValue4("(//span[@class='data-cXDWtdxq'])[4]", driver);
		String Dividendyield = commonMethod.methodElement5("//span[text()='Dividend yield (indicated)']", driver);
		String Value5 = commonMethod.methodValue5("(//span[@class='data-cXDWtdxq'])[5]", driver);
		String Pricetoearnings = commonMethod.methodElement6("//span[text()='Price to earnings Ratio (TTM)']", driver);
		String Value6 = commonMethod.methodValue6("(//span[@class='data-cXDWtdxq'])[6]", driver);
		String BasicEPS = commonMethod.methodElement7("//span[text()='Basic EPS (TTM)']", driver);
		String Value7 = commonMethod.methodValue7("(//span[@class='data-cXDWtdxq'])[7]", driver);
		String Sharesfloat = commonMethod.methodElement8("//span[text()='Shares float']", driver);
		String Value8 = commonMethod.methodValue8("(//span[@class='data-cXDWtdxq'])[8]", driver);
		String Beta = commonMethod.methodElement9("//span[text()='Beta (1Y)']", driver);
		String Value9 = commonMethod.methodValue9("(//span[@class='data-cXDWtdxq'])[9]", driver);

		FinalData.add(Nextearningsreport + "<" + Volume + "<" + AverageVolume + "<" + Marketcapitalization + "<"
				+ Dividendyield + "<" + Pricetoearnings + "<" + BasicEPS + "<" + Sharesfloat + "<" + Beta);
		FinalData.add(Value1 + "<" + Value2 + "<" + Value3 + "<" + Value4 + "<" + Value5 + "<" + Value6 + "<" + Value7
				+ "<" + Value8 + "<" + Value9);

	}

	public static void ClickMethod1(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void ClickMethod2(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void ClickMethod3(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void getText1(String xpath) {
		dayEle = driver.findElement(By.xpath(xpath)).getText();
	}

	public static void getText2(String xpath) {
		oneMonthEle = driver.findElement(By.xpath(xpath)).getText();
	}

	public static void getText3(String xpath) {
		oneYearEle = driver.findElement(By.xpath(xpath)).getText();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}