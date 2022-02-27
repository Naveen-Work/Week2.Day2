package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeads {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//label[contains(text(),'First name')])[3]/following::input[@name='firstName']")).sendKeys("test");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-viewport']/div[@class='x-grid3-scroller']//a[@class='linktext'])[1]")).click();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Page is verified Successfully and TC Passed");
		}else
		{
			System.out.println("TC is failed");
			driver.quit();
		}
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TESTLEAFTEST");
		driver.findElement(By.className("smallSubmit")).click();
		String name=driver.findElement(By.xpath("//span[contains(text(),'Company Name')]//following::span[@id='viewLead_companyName_sp']")).getText();
		System.out.println("Company Name is "+name);
		if(name.contains("TESTLEAFTEST")) {
			System.out.println("Company Name matched and TC Passed");
		}else {
			System.out.println("Company Name not matched and TC Failed");
		}
		driver.close();
		}

}
