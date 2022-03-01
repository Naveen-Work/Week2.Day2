package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://leafground.com/pages/checkbox.html");

		//GetTitle
		System.out.println("Current Page Title is : "+driver.getTitle());

		//isDisplayed
		WebElement checkBoxElement = driver.findElement(By.xpath("(//div[@class='example']//following::input)[1]"));
		String sell=driver.findElement(By.xpath("//label[@for='java' and text()='Select the languages that you know?']//following::div[1]")).getText();
		boolean disp = checkBoxElement.isDisplayed();
		if(disp==true) {
			System.out.println("'"+sell+"' checkbox is displayed");	
		}else
			System.out.println("'"+sell+"' checkbox is not displayed");

		//isEnabled
		boolean enab = checkBoxElement.isEnabled();
		if(enab==true) {
			System.out.println("'"+sell+"' checkbox is enabled");	
		}else
			System.out.println(sell+" checkbox is not enabled");

		//Verify Checkbox not selected
		boolean sel = checkBoxElement.isSelected();
		if(sel==false) {
			System.out.println("'"+sell+"' checkbox is not selected");	
		}else
			System.out.println("'"+sell+"' checkbox is selected");


		//isSelected Checkbox selected
		String c=driver.findElement(By.xpath("//label[@for='java' and text()='Confirm Selenium is checked']//following::div[1]")).getText();
		WebElement checkBoxElement1 = driver.findElement(By.xpath("(//div[@class='example']//following::input)[6]"));
		boolean sel1 = checkBoxElement1.isSelected();
		if(sel1==false) {
			System.out.println("'"+c+"' checkbox is not selected");	
		}else
			System.out.println("'"+c+"' checkbox is selected");
		
		//Deselect checked checkbox
		String a=driver.findElement(By.xpath("//label[@for='java' and text()='DeSelect only checked']//following::div[1]")).getText();
		String b=driver.findElement(By.xpath("//label[@for='java' and text()='DeSelect only checked']//following::div[2]")).getText();
		WebElement checkBoxElement2 = driver.findElement(By.xpath("//label[@for='java' and text()='DeSelect only checked']//following::input[1]"));
		System.out.println("'"+a+"' Checkbox is now selected? "+checkBoxElement2.isSelected());
		boolean sel2 = checkBoxElement2.isSelected();
		WebElement checkBoxElement3 = driver.findElement(By.xpath("//label[@for='java' and text()='DeSelect only checked']//following::input[2]"));
		boolean sel3 = checkBoxElement3.isSelected();
		System.out.println("'"+b+"' Checkbox is now selected? "+checkBoxElement3.isSelected());
		
		if(sel2==false && sel3==false) {			
			checkBoxElement2.click();
			System.out.println("'"+a+"' Checkbox is now unselected.");
			checkBoxElement3.click();
			System.out.println("'"+b+"' Checkbox is now unselected.");
		}else if(sel2==true) {
			checkBoxElement2.click();
			System.out.println("'"+a+"' Checkbox is now unselected.");
		}else if(sel3==true) {
			checkBoxElement3.click();
			System.out.println("'"+b+"' Checkbox is now unselected.");
		}else
		{
			System.out.println("Both '"+a+"' and '"+b+"' check boxes are not selected previously");
		}
		
	}

}
