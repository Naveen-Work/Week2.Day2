package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	public static String Separate(String str) {
        String number = "";
        for (int i = 0; i < str.length(); i++) {
               char a = str.charAt(i);
               if (Character.isDigit(a)) {
                     number = number + a;
               }
        }
        return number;   
 }

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
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("2345");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String cmpyname=driver.findElement(By.xpath("(//div[@class='x-grid3-viewport']/div[@class='x-grid3-scroller']//a[@class='linktext'])[1]")).getText();
		String cmpyname1=Separate(cmpyname);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-viewport']/div[@class='x-grid3-scroller']//a[@class='linktext'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(cmpyname1);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String result=driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
			
		
		if(result.equalsIgnoreCase("No records to display")) {
			System.out.println("Lead deleted Successfully and TC Passed");
		}else
		{
			System.out.println("TC is failed");
			driver.quit();
		}		
		
		driver.close();
		}

}
