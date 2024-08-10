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


public class StockMarket1 {

	public WebDriver driver;
	String Nextearningsreport;
	String Value1;
	String Volume;
	String Value2;
	String AverageVolume;
	String Value3;
	String Marketcapitalization;
	String Value4;
	String Dividendyield;
	String Value5;
	String Pricetoearnings;
	String Value6;
	String BasicEPS;
	String Value7;
	String Sharesfloat;
	String Value8;
	String Beta;
	String Value9;
	ArrayList<String> FinalData = new ArrayList<String>();
	int i;


	@BeforeClass
	public void before() {

		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://in.tradingview.com/chart/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void test1() throws IOException, InterruptedException {

		//driver.findElement(By.xpath("//*[@id='header-toolbar-intervals']/button/div/div")).click();
		//driver.findElement(By.xpath("//span[text()='1 month']")).click();
		//Thread.sleep(1000);

		//driver.findElement(By.xpath("//div[@class='dropdown-S_1OCXUK']//div[normalize-space()='Days']")).click();
		//List<WebElement> options=driver.findElements(By.xpath("//div[@class='accessible-NQERJsv9 menuItem-RmqZNwwp item-jFqVJoPk']"));
		//System.out.println("total :"+options.size());
		/*
		 * for (WebElement opt : options) { if(opt.getText().equals("3 months")) {
		 * opt.click(); break; } }
		 */

		List<String> data=new ArrayList<>(Arrays.asList("ITC","IRFC","PFC"));

		for(int i=0;i<data.size();i++) {
			FinalData.add("Stock Name: "+data.get(i)+"<"); 
			method(data.get(i));
		}
		System.err.println("---"+FinalData);
		WriteAndPrintExcel.writemethod(FinalData);


	}

	public void method(String stock) throws InterruptedException, IOException {

		driver.findElement(By.xpath("//div[@class='group-MBOVGQRI']//button[@id='header-toolbar-symbol-search']")).click();
		WebElement text=driver.findElement(By.xpath("//input[@placeholder='Search'][1]"));
		text.clear();
		text.sendKeys(stock);

		Actions a = new Actions(driver);
		a.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String title=driver.getTitle();
		System.out.println("Title is : "+title);

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\GO20382992\\eclipse-workspace\\StackMarket\\screenshots\\"+stock+".png");
		FileUtils.copyFile(src, trg);
		Thread.sleep(2000);
		
		WebElement Day =driver.findElement(By.xpath("//div[@class='dateRangeWrapper-BXXUwft2']//div//button//div[text()='1D']"));
		Day.click();
		Thread.sleep(2000);
		WebElement month =driver.findElement(By.xpath("//div[@class='dateRangeWrapper-BXXUwft2']//div//button//div[text()='1M']"));
		month.click();
		Thread.sleep(2000);
		WebElement year =driver.findElement(By.xpath("//div[@class='dateRangeWrapper-BXXUwft2']//div//button//div[text()='1Y']"));
		year.click();

		WebElement day=driver.findElement(By.xpath("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']"));
		WebElement oneMonth=driver.findElement(By.xpath("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']"));
		WebElement oneYear=driver.findElement(By.xpath("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']"));

		String dayEle=day.getText();
		String oneMonthEle=oneMonth.getText();
		String oneYearEle=oneYear.getText();

		double dayValue=Double.parseDouble(dayEle);
		double oneMonthValue=Double.parseDouble(oneMonthEle);
		double oneYearValue=Double.parseDouble(oneYearEle);


		if(dayValue > oneMonthValue) {
			System.out.println("The stock market value has increased from 1 month to this per Day");
		}
		else if(dayValue < oneMonthValue) {
			System.out.println("The stock market value has decreased from 1 month to this per Day");
		}
		else {
			System.out.println("The stock market value is the same as value");
		}

		if(oneYearValue > dayValue) {
			System.out.println("The stock market value has increased from 1 year to this per Day");
		}
		else if(oneYearValue < dayValue) {
			System.out.println("The stock market value has decreased from 1 year to this per Day");
		}
		else {
			System.out.println("The stock market value is the same as value");
		}
	
		Thread.sleep(2000);
	
		List<WebElement> allelements=driver.findElements(By.xpath("//div[@class='sliderRow-k2h4OAz8 dateRange-BXXUwft2 tabs-NGf0gcnH']/button"));

		for(int i=0;i<allelements.size();i++) {
		WebElement element=allelements.get(i);
		element.click();

			Thread.sleep(2000);

			TakesScreenshot ts1=(TakesScreenshot)driver;
			File src1=ts1.getScreenshotAs(OutputType.FILE);
			File trg1=new File("C:\\Users\\GO20382992\\eclipse-workspace\\WebSitesTesting\\snapshot\\"+stock +(i+1)+".png");
			FileUtils.copyFile(src1, trg1);

		String stockprice=driver.findElement(By.xpath("//span[@class='highlight-maJ2WnzA price-qWcO4bp9']")).getText();
		System.out.println("Stock price: "+stockprice);

		//1)
		try {
			Nextearningsreport=driver.findElement(By.xpath("//span[text()='Next earnings report']")).getText();
			System.out.println("Next earnings report value is available: "+Nextearningsreport);

		}catch(Exception e){
			Nextearningsreport="Value is not available";
			System.out.println("Next earnings report value is available: "+Nextearningsreport);
		}

		try {
			Value1=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[1]")).
			getText(); System.out.println("value 1 is available: "+Value1);

		}catch(Exception e){ 
			Value1="Value is not available";
			System.out.println("Value1: "+Value1); 
		}

		//2)
		try {
			Volume=driver.findElement(By.xpath("//span[text()='Volume']")).getText();
			System.out.println("Volume value is available: "+Volume);

		}catch(Exception e){
			Volume="Value is not available";
			System.out.println("Volume value is available: "+Volume);
		}

		try {
			Value2=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[2]")).
					getText(); System.out.println("value 2 is available: "+Value2);

		}catch(Exception e){ Value2="Value is not available";
		System.out.println("value 2: "+Value2); 
		}

		//3)
		try {
			AverageVolume=driver.findElement(By.xpath("//span[text()='Average Volume (30D)']")).getText();
			System.out.println("Average Volume value is available: "+AverageVolume);

		}catch(Exception e){
			AverageVolume="Value is not available";
			System.out.println("AverageVolume value is available: "+AverageVolume);
		}

		try {
			Value3=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[3]")).
					getText(); System.out.println("value 3 is available: "+Value3);

		}catch(Exception e){ 
			Value3="Value is not available";
			System.out.println("value 3: "+Value3); 
		}
		//4)
		try {
			Marketcapitalization=driver.findElement(By.xpath("//span[text()='Market capitalization']")).getText();
			System.out.println("Market capitalization value is available: "+Marketcapitalization);

		}catch(Exception e){
			Marketcapitalization="Value is not available";
			System.out.println("Market capitalization value is available: "+Marketcapitalization);
		}

		try {
			Value4=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[4]")).getText(); 
			System.out.println("value 4 is available: "+Value4);

		}catch(Exception e){ 
			Value4="Value is not available";
			System.out.println("value 4: "+Value4); 
		}

		//5)
		try {
			Dividendyield=driver.findElement(By.xpath("//span[text()='Dividend yield (indicated)']")).getText();
			System.out.println("Dividend yield value is available: "+Dividendyield);

		}catch(Exception e){
			Dividendyield="Value is not available";
			System.out.println("Dividend yield value is available: "+Dividendyield);
		}

		try {
			Value5=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[5]")).getText(); 
			System.out.println("value 5 is available: "+Value5);

		}catch(Exception e){ 
			Value5="Value is not available";
			System.out.println("value 5: "+Value5); 
		}

		//6)
		try {
			Pricetoearnings=driver.findElement(By.xpath("//span[text()='Price to earnings Ratio (TTM)']")).getText();
			System.out.println("Price to earnings Ratio value is available: "+Pricetoearnings);

		}catch(Exception e){
			Pricetoearnings="Value is not available";
			System.out.println("Price to earnings value is available: "+Pricetoearnings);
		}

		try {
			Value6=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[6]")).getText(); 
			System.out.println("value 6 is available: "+Value6);

		}catch(Exception e){ 
			Value6="Value is not available";
			System.out.println("value 6: "+Value6); 
		}

		//7)
		try {
			BasicEPS=driver.findElement(By.xpath("//span[text()='Basic EPS (TTM)']")).getText();
			System.out.println("Basic EPS value is available: "+BasicEPS);

		}catch(Exception e){
			BasicEPS="Value is not available";
			System.out.println("Basic EPS value is available: "+BasicEPS);
		}

		try {
			Value7=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[7]")).getText(); 
			System.out.println("value 7 is available: "+Value7);

		}catch(Exception e){ 
			Value7="Value is not available";
			System.out.println("value 7: "+Value7); 
		}

		//8)
		try {
			Sharesfloat=driver.findElement(By.xpath("//span[text()='Shares float']")).getText();
			System.out.println("Shares float value is available: "+Sharesfloat);

		}catch(Exception e){
			Sharesfloat="Value is not available";
			System.out.println("Shares float value is available: "+Sharesfloat);
		}

		try {
			Value8=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[8]")).getText(); 
			System.out.println("value 8 is available: "+Value8);

		}catch(Exception e){ 
			Value8="Value is not available";
			System.out.println("value 8: "+Value8); 
		}

		//9)
		try {
			Beta=driver.findElement(By.xpath("//span[text()='Beta (1Y)']")).getText();
			System.out.println("Beta value is available: "+Beta);

		}catch(Exception e){
			Beta="Value is not available";
			System.out.println("Beta value is available: "+Beta);
		}

		try {
			Value9=driver.findElement(By.xpath("(//span[@class='data-cXDWtdxq'])[9]")).getText(); 
			System.out.println("value 9 is available: "+Value9);

		}catch(Exception e){ 
			Value9="Value is not available";
			System.out.println("value 9: "+Value9); 
		}

		FinalData.add(Nextearningsreport+"<"+Volume+"<"+AverageVolume+"<"+Marketcapitalization+"<"+Dividendyield+"<"+Pricetoearnings+"<"+BasicEPS+"<"+Sharesfloat+"<"+Beta);
		FinalData.add(Value1+"<"+Value2+"<"+Value3+"<"+Value4+"<"+Value5+"<"+Value6+"<"+Value7+"<"+Value8+"<"+Value9);
		}
	}

	@AfterClass
	public void tearDown() {
		if(driver !=null) {
			driver.quit();
		}
	}
}