package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserVerification {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://leafground.com/pages/Edit.html");

		//GetTitle
		System.out.println("Current Page Title is : "+driver.getTitle());

		if(driver.getTitle().contains("TestLeaf - Interact with Edit Fields")) {
			System.out.println("Confirming Page Title is '"+driver.getTitle()+"'  matched");
		}else
			System.out.println("Page Title is not matched");

		//GetCurrentURL
		System.out.println("Current Page URL is : "+driver.getCurrentUrl());

		//GetPageSource
		System.out.println("The Page Source is : "+driver.getPageSource());

		//GetAttribute
		System.out.println("Get Attribute is : "+driver.findElement(By.xpath("//label[@for='uname' and contains(text(),'Get default text entered')]//following-sibling::input")).getAttribute("Value"));

		//GetText
		System.out.println("Get Text is : "+driver.findElement(By.xpath("//label[@for='uname' and contains(text(),'Get default text entered')]")).getText());

		//Clear the text
		WebElement clrtext = driver.findElement(By.xpath("//label[@for='uname' and contains(text(),'Clear the text')]//following-sibling::input"));
		clrtext.clear();

		//Field is enabled
		if(driver.findElement(By.xpath("//label[@for='uname' and contains(text(),'Clear the text')]//following-sibling::input")).isEnabled()) {
			System.out.println("'"+clrtext.getAttribute("Value")+"': Field is editable");
		}else
			System.out.println("'"+clrtext.getAttribute("Value")+"': Field is editable");

		//Field is disabled	
		WebElement cnffield =driver.findElement(By.xpath("//label[@for='disabled']//following-sibling::input")); 
		if(cnffield.isEnabled()) {
			System.out.println("'"+driver.findElement(By.xpath("//label[@for='disabled']")).getText()+"': Field is editable");
		}else
			System.out.println("'"+driver.findElement(By.xpath("//label[@for='disabled']")).getText()+"': Field is not editable");		

		//GetCssValue
		System.out.println("Background color is : "+driver.findElement(By.xpath("//label[@for='disabled']//following-sibling::input")).getCssValue("background-color"));

		//driver.close();
	}

}
