package Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Techassesment {
private static WebDriver driver;
private static String baseUrl;

public static void main(String[] args) throws Exception {


		String username = "priyankafadnavis1220@gmail.com";
		String password = "Sumeet@1691";
		ComposeMail(username,password);
		}
		
		public static void ComposeMail(String username,String password) throws Exception {
		
		String emailsubject="Incubyte";
		String tomailid ="jyotikumari@paratussystems.com";
		String mailbody ="Automation QA test for Incubyte";
		System.setProperty("webdriver.chrome.driver","F:\\priyankawork\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://mail.google.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("username");
		WebElement link_Home = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		Actions builder = new Actions(driver);
		org.openqa.selenium.interactions.Action mouseOverHome = builder.moveToElement(link_Home).build();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		/*Verify login */
		String title = "Gmail";
		if (driver.getTitle().contains(title)){
		System.out.println("Logged in sucessfully !!!"+driver.getTitle());
		}
		else {
		System.out.println("Unable to loggin :-( "+driver.getTitle());
		}
		/* Compose email */
		driver.findElement(By.xpath("//div[@class='z0']/div")).click();
		
		/* Enter email details */
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td//img[2]")).click();
		driver.findElement(By.className("vO")).sendKeys(tomailid);
		driver.findElement(By.className("aoT")).sendKeys(emailsubject);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='1']")));
		WebElement printbody = driver.switchTo().activeElement();
		printbody.sendKeys(mailbody);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
		if (driver.findElement(By.xpath("//div[@class='y6']//b[text()='"+emailsubject+"']")) != null)
			{
			System.out.println("Wowww.. Email sent sucessfully!!!");
			}
		else
			{
			System.out.println("Failed to send email !!!");
			}
		Thread.sleep(2000);
		driver.quit();
}
}