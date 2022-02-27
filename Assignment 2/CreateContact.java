package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("NaveenAA");		
		driver.findElement(By.id("lastNameField")).sendKeys("KumarAA");		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("TEST1");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("TEST2");
		driver.findElement(By.name("departmentName")).sendKeys("ITI");
		driver.findElement(By.id("createContactForm_description")).sendKeys("TESTING CREATE CONTACT");
		driver.findElement(By.name("primaryEmail")).sendKeys("Test@gmail.com");
		Select s=new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		s.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("ADDING NOTES EDIT AND UPDATE");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		System.out.println("Page Title is "+driver.getTitle());
		
	}

}
