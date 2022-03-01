package week2.day2;

import java.time.Duration;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://leafground.com/pages/Image.html");

		// GetTitle
		System.out.println("Current Page Title is : " + driver.getTitle());

		// Image is displayed
		WebElement e2 = driver
				.findElement(By.xpath("//label[@for='home' and contains(text(),'home page')]//following::img[1]"));
		String home = driver.findElement(By.xpath(
				"//label[@for='home' and contains(text(),'home page')]//following::img[1]//preceding-sibling::label"))
				.getText();
		if (e2.isDisplayed() == true) {
			System.out.println("Go to Home Page Image link is displayed: " + e2.isDisplayed());
			e2.click();
		} else {
			System.out.println("Go to Home Page Image link is displayed: " + e2.isDisplayed());
		}
		if (driver.getTitle().contains("TestLeaf - Selenium Playground")) {
			System.out.println(
					"Page successfully navigated to '" + driver.getTitle() + "' after click on '" + home + "' link");
		} else
			System.out.println(
					"Page not navigated to 'TestLeaf - Selenium Playground' Page after click on '" + home + "' ' link");

		// Navigate back to previous page - Click on Image Icon
		driver.findElement(By.xpath("//ul[@class='wp-categories-list']//a[contains(@href,'Image')]")).click();

		// Navigate to TestLeaf - Interact with Buttons Page
		if (driver.getTitle().contains("TestLeaf - Interact with Images")) {
			System.out.println("Navigated to '" + driver.getTitle() + "after click on hyperlink icon");
		} else
			System.out.println("Page not navigated is not matched");
		
		//Broken Image
		
		WebElement e1 = driver
				.findElement(By.xpath("//label[@for='position' and contains(text(),'Am I Broken Image')]//following-sibling::img"));
		String link1 = driver.findElement(By.xpath(
				"//label[@for='position' and contains(text(),'Am I Broken Image')]")).getText();
		if (e1.isDisplayed() == false) {
			System.out.println("'"+link1+"' Image link is not displayed: " + e1.isDisplayed());
		} else {
			System.out.println("'"+link1+"' Image link is displayed: " + e1.isDisplayed());
			e1.click();
		}
		
		//Store all the Image links
		List<WebElement> links=driver.findElements(By.tagName("img"));
		
		//Display total Image links
		System.out.println("Total image links"+links.size());
		
		//Valid and invalid image
		for (int i = 0; i <= links.size(); i++) {
		try {
			String ll=links.get(i).getAttribute("src");
			
			URL url = new URL(ll);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int code = connection.getResponseCode();
			// Condition to check whether the URL is valid or Invalid
			if (code == 200) {
			System.out.println("Valid Image:" + ll);
			} else {
			System.out.println("INVALID Image:" + ll);
			}          
			} catch (Exception e) {
			System.out.println(e.getMessage());
			}
			}
		
		
		//Keyboard click on image
		WebElement e3 = driver
				.findElement(By.xpath("//label[@for='position' and contains(text(),'Click me')]//following::img"));
		String home1 = driver.findElement(By.xpath(
				"//label[@for='position' and contains(text(),'Click me')]"))
				.getText();
		if (e3.isDisplayed() == true) {
			System.out.println("Go to Home Page Image link is displayed: " + e3.isDisplayed());
			e3.click();
		} else {
			System.out.println("Go to Home Page Image link is displayed: " + e3.isDisplayed());
		}
		if (driver.getTitle().contains("TestLeaf - Selenium Playground")) {
			System.out.println(
					"Page successfully navigated to '" + driver.getTitle() + "' after click on '" + home1 + "' link");
		} else
			System.out.println(
					"Page not navigated to 'TestLeaf - Selenium Playground' Page after click on '" + home1 + "' ' link");
		}
	}

