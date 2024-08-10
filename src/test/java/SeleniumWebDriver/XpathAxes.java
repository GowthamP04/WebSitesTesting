package SeleniumWebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?next=https%3A%2F%2Fwww.facebook.com%2F&locale=en_GB&display=page");
		//driver.get("https://google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//1)find the sign up btn from the registration form present in facebbok application (child)
		//String btn=driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[11]/button")).getText();
		//System.out.println(btn);

		//2)locate firstname from sign up in facebook (parent)
		//String firstname=driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']/parent::*/parent::*/child::div[1]/div/div[1]")).getText();
		//System.out.println(firstname);

		//3)identify the password from mobile number filled in facebook - (following)
		//String pass=driver.findElement(By.xpath("//input[@name='reg_email__']/following::input[2]")).getText();
		//System.out.println(pass);

		//4)identify the  mobile number from password filled in facebook - (following)
		//String mobile=driver.findElement(By.xpath("//input[@id='password_step_input']/preceding::input[2]")).getText();
		//System.out.println(mobile);
		
		//5)locate surname from female radio btn in facebok (ancestor)
		//String surname=driver.findElement(By.xpath("//input[@id='u_0_4_wd']/ancestor::div[2]/div[1]/div/div[2]")).getText();
		//System.out.println(surname);
		
		//6)identify search text box from google search btn present in google search home page - (parent)
		WebElement google=driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']/parent::*/parent::*/parent::*/div[1]"));
		google.sendKeys("hi");
		google.sendKeys(Keys.ENTER);
		
		//7)identify today's deals link from search text box present in amazon home page-(following)
		WebElement deal=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/following::a[contains(text(),\"Today's Deals\")]"));
		
		//7)identify Hello, sign in link from search text box present in amazon home page-(following)
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/following::span[contains(text(),'Hello, sign in')]"));

		//identify mobile link which part of menu bar- (descendant)
		
		driver.quit();
	}

}