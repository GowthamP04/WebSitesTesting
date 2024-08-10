package Assignment;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MakeMyTripTest {

	static WebDriver driver;

@BeforeClass
public void setUp() {
 driver.get("https://www.makemytrip.com/");
 driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
 public void testInternationalTripPlanning() throws InterruptedException {
 closePopupIfPresent();
 navigateToInternationalFlights();
 planInternationalHoliday("Dubai", "December, 2024");
 verifyFlightDetails();
 }

 public void closePopupIfPresent() {
try {
 WebElement closeButton = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
 if (closeButton.isDisplayed()) {
 closeButton.click();
 }
 } catch (Exception e) {

 System.out.println("Popup not present");
 }
}

 public void navigateToInternationalFlights() {
 driver.findElement(By.xpath("//span[@class='flightsSprite fltSwipIcon']")).click();
 driver.findElement(By.cssSelector("#toCity")).click();
 }

 public void planInternationalHoliday(String destination, String month) throws InterruptedException {
 scrollToElement(By.xpath("//div[@class='makeFlex column intlFlightTile-autosuggest']//p[text()='Planning an international holiday?']"));
 clickElement(By.xpath("//div[@class='makeFlex column intlFlightTile-autosuggest']//p[text()='Planning an international holiday?']"));
 clickElement(By.xpath("//span[text()='ANYWHERE']"));
 selectDestination(destination);
 }

public void scrollToElement(By locator) {
 WebElement element = driver.findElement(locator);
JavascriptExecutor js = (JavascriptExecutor) driver;
 js.executeScript("arguments[0].scrollIntoView();", element);
 }

 public void clickElement(By locator) throws InterruptedException {
WebElement element = driver.findElement(locator);
try {
 element.click();
 Thread.sleep(1000);
 }
 catch(Exception e) {
 JavascriptExecutor js = (JavascriptExecutor) driver;
 js.executeScript("arguments[0].click();", element);
 }
}

 public void selectDestination(String destination) throws InterruptedException {
 Thread.sleep(1000);
 WebElement destinationInput = driver.findElement(By.xpath("(//input[@placeholder='Enter City'])[2]"));
 destinationInput.click();
 destinationInput.sendKeys(destination);
 Thread.sleep(2000);
 driver.findElement(By.xpath("//span[text()='" + destination + ", United Arab Emirates']")).click();
 }

 public void selectTravelMonth(String month) {
 driver.findElement(By.xpath("//span[text()='Anytime ']")).click();
 driver.findElement(By.xpath("//span[text()='" + month + "']")).click();
 driver.findElement(By.xpath("//button[text()='Apply']")).click();
 driver.findElement(By.xpath("//button[text()='Search']")).click();
 }

 public void selectCheapestFlight() throws InterruptedException {
 String[] weekend = {"01", "07", "08", "14", "15", "21", "22", "28", "29"};
 ArrayList<Integer> prices = getPricesForDates(weekend);
 int minValue = prices.isEmpty() ? getMinDataFromCalendar() : Collections.min(prices);
 String formattedPrice = formatToCurrency(minValue);
 driver.findElement(By.xpath("//p[contains(text(),'" + formattedPrice + "')]")).click();
 driver.findElement(By.xpath("(//a[text()='VIEW FLIGHTS'])[1]")).click();
 switchToNewWindow();
 }

 public ArrayList<Integer> getPricesForDates(String[] dates) {
 ArrayList<Integer> prices = new ArrayList<>();
 for (String date : dates) {
 try {
 String priceText = driver.findElement(By.xpath("//p[text()='" + date + "']/following-sibling::p")).getText();
 prices.add(parsePrice(priceText));
} catch (Exception e){
	//System.out.println("Date not found, continue with next date");
}
 }
 return prices;
 }

 public int parsePrice(String priceText) {
 String numericString = priceText.replace("₹", "").replace(",", "").trim();
 return Integer.parseInt(numericString);
 }

 public int getMinDataFromCalendar() {
ArrayList<Integer> prices = new ArrayList<>();
 List<WebElement> data = driver.findElements(By.cssSelector(".calPrice"));
 for (WebElement element : data) {
 prices.add(parsePrice(element.getText()));
 }
return Collections.min(prices);
}

 public String formatToCurrency(int number) {//18227 - 18,227
 NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
String formattedNumber = currencyFormatter.format(number);
 return formattedNumber.contains(".") ? formattedNumber.substring(0, formattedNumber.indexOf('.')).replace("₹", "").trim() : formattedNumber.replace("₹", "").trim();
 }

 public void switchToNewWindow() {
 String mainWindowHandle = driver.getWindowHandle();
 Set<String> allWindowHandles = driver.getWindowHandles();
 for (String windowHandle : allWindowHandles) {
 if (!mainWindowHandle.equalsIgnoreCase(windowHandle)) {
 driver.switchTo().window(windowHandle);
 }
 }
 }

 public void verifyFlightDetails() {
 try {
driver.findElement(By.cssSelector(".bgProperties.overlayCrossIcon.icon20")).click();
 int count = driver.findElements(By.cssSelector(".boldFont.blackText.airlineName ")).size();
 Assert.assertTrue(count >= 1);
 } catch (Exception e) {
 System.out.println("Page is not loaded ");
 }
 }

@AfterClass
 public void tearDown() {
 driver.quit();
 }
}