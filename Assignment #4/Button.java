package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://leafground.com/pages/Button.html");

		//GetTitle
				System.out.println("Current Page Title is : "+driver.getTitle());
				
				if(driver.getTitle().contains("TestLeaf - Interact with Buttons")) {
					System.out.println("Confirming Page Title is '"+driver.getTitle()+"' matched");
				}else
					System.out.println("Page Title is not matched");
				
				//Button is displayed
				System.out.println("Go to Home Page Button is displayed: "+driver.findElement(By.id("home")).isDisplayed());
				String home=driver.findElement(By.id("home")).getText();
				driver.findElement(By.id("home")).click();
				
				if(driver.getTitle().contains("TestLeaf - Selenium Playground")) {
					System.out.println("Page successfully navigated to '"+driver.getTitle()+"' after click on '"+home+"' button");
				}else
					System.out.println("Page not navigated to 'TestLeaf - Selenium Playground' Page after click on '"+home+"' button");
				
				//Click on Button icon
				driver.findElement(By.xpath("//ul[@class='wp-categories-list']//a[contains(@href,'Button')]")).click();
				
				//Navigate to  TestLeaf - Interact with Buttons Page
				if(driver.getTitle().contains("TestLeaf - Interact with Buttons")) {
					System.out.println("Page successfully navigated to '"+driver.getTitle()+"' after click on button icon");
				}else
					System.out.println("Page Title is not navigated to '"+driver.getTitle()+"' after click on button icon");
				
				//Get Position
				System.out.println(driver.findElement(By.id("position")).getText()+" Button Position "+driver.findElement(By.id("position")).getLocation());
				System.out.println(driver.findElement(By.id("position")).getText()+" Button X Position "+driver.findElement(By.id("position")).getLocation().getX());
				System.out.println(driver.findElement(By.id("position")).getText()+" Button Y Position "+driver.findElement(By.id("position")).getLocation().getY());
				
				//Find button color
				System.out.println(driver.findElement(By.id("color")).getText()+" button color is "+driver.findElement(By.id("color")).getCssValue("background-color"));
				
				//Find the height and width
				System.out.println(driver.findElement(By.id("size")).getText()+" button size is "+driver.findElement(By.id("size")).getSize());
				System.out.println(driver.findElement(By.id("size")).getText()+" button size height is "+driver.findElement(By.id("size")).getSize().getHeight());
				System.out.println(driver.findElement(By.id("size")).getText()+" button size width is "+driver.findElement(By.id("size")).getSize().getWidth());
				
				//driver.close();
	}

}
