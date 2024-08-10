package StockMarketTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class commonMethod {

	//static WebDriver driver;
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


	//1)
	public static String methodElement1(String xpath,WebDriver driver) {

		try {
			Nextearningsreport=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Next earnings report value is available: "+Nextearningsreport);

		}catch(Exception e){
			Nextearningsreport="Value is not available";
			System.out.println("Next earnings report value is available: "+Nextearningsreport);
		}
		return Nextearningsreport;
	}
	public static String methodValue1(String xpath,WebDriver driver) {

		try {
			Value1=driver.findElement(By.xpath(xpath)).
					getText(); 
			System.out.println("value 1 is available: "+Value1);

		}catch(Exception e){ 
			Value1="Value is not available";
			System.out.println("Value1: "+Value1); 
		}
		return Value1;
	}

	//2)
	public static String methodElement2(String xpath,WebDriver driver) {

		try {
			Volume=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Volume value is available: "+Volume);

		}catch(Exception e){
			Volume="Value is not available";
			System.out.println("Volume value is available: "+Volume);
		}
		return Volume;
	}

	public static String methodValue2(String xpath,WebDriver driver) {

		try {
			Value2=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("value 2 is available: "+Value2);

		}catch(Exception e){ 
			Value2="Value is not available";
			System.out.println("value 2: "+Value2); 
		}
		return Value2;
	}

	//3)
	public static String methodElement3(String xpath,WebDriver driver) {

		try {
			AverageVolume=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Average Volume value is available: "+AverageVolume);

		}catch(Exception e){
			AverageVolume="Value is not available";
			System.out.println("AverageVolume value is available: "+AverageVolume);
		}
		return AverageVolume;
		
	}

	public static String methodValue3(String xpath,WebDriver driver) {

		try {
			Value3=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("value 3 is available: "+Value3);

		}catch(Exception e){ 
			Value3="Value is not available";
			System.out.println("value 3: "+Value3); 
		}
		return Value3;
	}

	//4)
	public static String methodElement4(String xpath,WebDriver driver) {

		try {
			Marketcapitalization=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Market capitalization value is available: "+Marketcapitalization);

		}catch(Exception e){
			Marketcapitalization="Value is not available";
			System.out.println("Market capitalization value is available: "+Marketcapitalization);
		}
		return Marketcapitalization;
	}

	public static String methodValue4(String xpath,WebDriver driver) {

		try {
			Value4=driver.findElement(By.xpath(xpath)).getText(); 
			System.out.println("value 4 is available: "+Value4);

		}catch(Exception e){ 
			Value4="Value is not available";
			System.out.println("value 4: "+Value4); 
		}
		return Value4;
	}

	//5)
	public static String methodElement5(String xpath,WebDriver driver) {

		try {
			Dividendyield=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Dividend yield value is available: "+Dividendyield);

		}catch(Exception e){
			Dividendyield="Value is not available";
			System.out.println("Dividend yield value is available: "+Dividendyield);
		}
		return Dividendyield;
	}

	public static String methodValue5(String xpath,WebDriver driver) {

		try {
			Value5=driver.findElement(By.xpath(xpath)).getText(); 
			System.out.println("value 5 is available: "+Value5);

		}catch(Exception e){ 
			Value5="Value is not available";
			System.out.println("value 5: "+Value5); 
		}
		return Value5;
	}

	//6)
	public static String methodElement6(String xpath,WebDriver driver) {

		try {
			Pricetoearnings=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Price to earnings Ratio value is available: "+Pricetoearnings);

		}catch(Exception e){
			Pricetoearnings="Value is not available";
			System.out.println("Price to earnings value is available: "+Pricetoearnings);
		}
		return Pricetoearnings;
	}

	public static String methodValue6(String xpath,WebDriver driver) {

		try {
			Value6=driver.findElement(By.xpath(xpath)).getText(); 
			System.out.println("value 6 is available: "+Value6);

		}catch(Exception e){ 
			Value6="Value is not available";
			System.out.println("value 6: "+Value6); 
		}
		return Value6;
	}

	//7)
	public static String methodElement7(String xpath,WebDriver driver) {

		try {
			BasicEPS=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Basic EPS value is available: "+BasicEPS);

		}catch(Exception e){
			BasicEPS="Value is not available";
			System.out.println("Basic EPS value is available: "+BasicEPS);
		}
		return BasicEPS;
	}

	public static String methodValue7(String xpath,WebDriver driver) {

		try {
			Value7=driver.findElement(By.xpath(xpath)).getText(); 
			System.out.println("value 7 is available: "+Value7);

		}catch(Exception e){ 
			Value7="Value is not available";
			System.out.println("value 7: "+Value7); 
		}
		return Value7;
	}

	//8)
	public static String methodElement8(String xpath,WebDriver driver) {

		try {
			Sharesfloat=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Shares float value is available: "+Sharesfloat);

		}catch(Exception e){
			Sharesfloat="Value is not available";
			System.out.println("Shares float value is available: "+Sharesfloat);
		}
		return Sharesfloat;
	}

	public static String methodValue8(String xpath,WebDriver driver) {

		try {
			Value8=driver.findElement(By.xpath(xpath)).getText(); 
			System.out.println("value 8 is available: "+Value8);

		}catch(Exception e){ 
			Value8="Value is not available";
			System.out.println("value 8: "+Value8); 
		}
		return Value8;
	}

	//9)
	public static String methodElement9(String xpath,WebDriver driver) {

		try {
			Beta=driver.findElement(By.xpath(xpath)).getText();
			System.out.println("Beta value is available: "+Beta);

		}catch(Exception e){
			Beta="Value is not available";
			System.out.println("Beta value is available: "+Beta);
		}
		return Beta;
	}

	public static String methodValue9(String xpath,WebDriver driver) {

		try {
			Value9=driver.findElement(By.xpath(xpath)).getText(); 
			System.out.println("value 9 is available: "+Value9);

		}catch(Exception e){ 
			Value9="Value is not available";
			System.out.println("value 9: "+Value9); 
		}
		return Value9;
	}

}