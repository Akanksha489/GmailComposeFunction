package ComposeMail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Compose {
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.gmail.com");
	
	//writing email address
	driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("$Enter-email-address here$");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/div[2]")).click();
	
	WebElement password= driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
	WebDriverWait wait= new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(password));
	password.sendKeys("$enter-pasword$");
	driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/div[2]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//Click on Compose button
	driver.findElement(By.xpath("//div[text()='Compose']")).click();
	
	//Enter the sender mail id 
	driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("$Enter-sender's-mail-id-here$");
	
	//Enter the subject of the mail
	driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium Script Demo");
	
	//Enter the body of the mail
	driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("This is a demo Selenium script for sending an email with attachment");
	
	//Attach the file
	driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys("$Enter-the-path-of-the-attachment-here$");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//Click on send button
	driver.findElement(By.xpath("//div[text()='Send']")).click();
	//mail with attachment sent successfully
	
	}
	}
