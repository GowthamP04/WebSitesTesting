package WebSites;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YouTube {

	public WebDriver driver;

	@BeforeClass
	public void before() {

		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void test() {

		driver.findElement(By.xpath("//yt-formatted-string[text()='Movies']")).click();
		String movies = "//a[@id='thumbnail']//*[@class='style-scope ytd-thumbnail']//img";
		List<WebElement> movieRows =driver.findElements(By.xpath(movies));

		for (WebElement row : movieRows) {
			String certificate = row.findElement(By.xpath("//*[@class='badge badge-style-type-simple style-scope ytd-badge-supported-renderer style-scope ytd-badge-supported-renderer']")).getText();
			if ("U".equals(certificate)) {
				String title = row.findElement(By.id("video-title")).getText();
				System.out.println(title);
				String url = row.findElement(By.xpath("//img[@class='yt-core-image yt-core-image--fill-parent-height yt-core-image--fill-parent-width yt-core-image--content-mode-scale-aspect-fill yt-core-image--loaded']"))
						.getAttribute("href");
				System.out.println(url);

			}
		}
	}
	/*
	 * try { 
	 * // Step 1: Scrape "U" certificate movies from the movie database
	 * website driver.get("https://www.example.com/movies");
	 *
	 * List<WebElement> movieRows =
	 * driver.findElements(By.cssSelector(".movie-row")); 
	 * List<String> uCertificateMovies = new ArrayList<>();
	 *
	 *
	 * for (WebElement row : movieRows) { 
	 * String title =row.findElement(By.cssSelector(".movie-title")).getText(); 
	 * 
	 * String certificate = row.findElement(By.cssSelector(".movie-certificate")).getText();
	 * 
	 *
	 * if ("U".equals(certificate)) { uCertificateMovies.add(title); } }
	 *
	 * // Step 2: For each "U" certificate movie, get likes and comments from
	 * YouTube List<String[]> movieData = new ArrayList<>(); for (String movie :
	 * uCertificateMovies) { String youtubeUrl =
	 * "https://www.youtube.com/results?search_query=" + movie + "+trailer";
	 * driver.get(youtubeUrl);
	 *
	 * WebElement firstVideo = driver.findElement(By.cssSelector("a#video-title"));
	 * firstVideo.click();
	 *
	 * // Wait for the video page to load Thread.sleep(5000);
	 *
	 * WebElement likesElement =
	 * driver.findElement(By.cssSelector("yt-formatted-string#text")); String likes
	 * = likesElement.getAttribute("aria-label");
	 *
	 * WebElement commentsElement =
	 * driver.findElement(By.cssSelector("yt-formatted-string.count-text")); String
	 * comments = commentsElement.getText();
	 *
	 * movieData.add(new String[]{movie, likes, comments}); }
	 *
	 * // Step 3: Write the data to an Excel sheet writeDataToExcel(movieData);
	 *
	 * } catch (Exception e) { e.printStackTrace(); } finally { // Close the
	 * WebDriver driver.quit(); } }
	 *
	 * private static void writeDataToExcel(List<String[]> data) throws IOException
	 * { Workbook workbook = new XSSFWorkbook(); Sheet sheet =
	 * workbook.createSheet("U Certificate Movies");
	 *
	 * Row headerRow = sheet.createRow(0); Cell headerCell1 =
	 * headerRow.createCell(0); Cell headerCell2 = headerRow.createCell(1); Cell
	 * headerCell3 = headerRow.createCell(2); headerCell1.setCellValue("Title");
	 * headerCell2.setCellValue("Likes"); headerCell3.setCellValue("Comments");
	 *
	 * int rowIndex = 1; for (String[] movie : data) { Row row =
	 * sheet.createRow(rowIndex++); row.createCell(0).setCellValue(movie[0]);
	 * row.createCell(1).setCellValue(movie[1]);
	 * row.createCell(2).setCellValue(movie[2]); }
	 *
	 * try (FileOutputStream fileOut = new
	 * FileOutputStream("U_Certificate_Movies.xlsx")) { workbook.write(fileOut); }
	 *
	 * workbook.close(); }
	 */



	@AfterClass
	public void teardown() {
		if(driver !=null) {
			driver.quit();
		}
	}
}