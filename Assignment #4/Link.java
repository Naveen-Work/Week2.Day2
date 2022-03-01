package week2.day2;

import java.time.Duration;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("http://leafground.com/pages/Link.html");

		// GetTitle
		System.out.println("Current Page Title is : " + driver.getTitle());

		if (driver.getTitle().contains("TestLeaf - Interact with HyperLinks")) {
			System.out.println("Confirming Page Title is '" + driver.getTitle() + "' matched");
		} else
			System.out.println("Page Title is not matched");

		// Button is displayed
		WebElement e=driver.findElement(By.partialLinkText("Go to Home Page"));
		String home = e.getText();
		if(e.isDisplayed()==true) {
			System.out.println("Go to Home Page link is displayed: "
					+ e.isDisplayed());		
			driver.findElement(By.partialLinkText("Go to Home Page")).click();
		}else
			System.out.println("Go to Home Page link is displayed: "
					+ e.isDisplayed());
		if (driver.getTitle().contains("TestLeaf - Selenium Playground")) {
			System.out.println(
					"Page successfully navigated to '" + driver.getTitle() + "' after click on '" + home + "' link");
		} else
			System.out.println(
					"Page not navigated to 'TestLeaf - Selenium Playground' Page after click on '" + home + "' ' link");

		// Click on Button icon
		driver.findElement(By.xpath("//ul[@class='wp-categories-list']//a[contains(@href,'Link')]")).click();

		// Navigate to TestLeaf - Interact with Buttons Page
		if (driver.getTitle().contains("TestLeaf - Interact with HyperLinks")) {
			System.out.println("Navigate to '" + driver.getTitle() + " after click on hyperlink icon");
		} else
			System.out.println("Page not navigated is not matched");

		// Find the URL of link
		WebElement Parlink = driver.findElement(By.partialLinkText("Find where am supposed"));
		String str = Parlink.getAttribute("href");
		System.out.println("'"+Parlink.getText() + "' for this url is " + str);

		

		// Go to Home Page (Interact with same link name)
		String str2 = driver
				.findElement(By.xpath(
						"(//a[@href='../home.html' and contains(text(),'Go to Home Page')])[2]//following::label"))
				.getText();
		driver.findElement(By.xpath("(//a[@href='../home.html' and contains(text(),'Go to Home Page')])[2]")).click();
		if (driver.getTitle().contains("TestLeaf - Selenium Playground")) {
			System.out.println("Page successfully navigated to '" + driver.getTitle() + "' after click on '" + home
					+ " " + str2 + "' link");
		} else
			System.out.println("Page not navigated to 'TestLeaf - Selenium Playground' Page");

		// Click on Button icon
		driver.findElement(By.xpath("//ul[@class='wp-categories-list']//a[contains(@href,'Link')]")).click();

		// Navigate to TestLeaf - Interact with Buttons Page
		if (driver.getTitle().contains("TestLeaf - Interact with HyperLinks")) {
			System.out.println("Navigate to '" + driver.getTitle() + " after click on hyperlink icon");
		} else
			System.out.println("Page not navigated is not matched");

		// How many links are available in this page?
		System.out
		.println("Total Links in " + driver.getTitle() + " is: " + driver.findElements(By.tagName("a")).size());

		
		// Verify Broker URL
				WebElement Parlink1 = driver.findElement(By.partialLinkText("Verify am I broken?"));
				String slink = Parlink1.getText();
				Parlink1.click();
				if (driver.getTitle().contains("404")) {
					System.out.println("'" + slink + "': link is broken due to " + driver.getTitle());
				}
				driver.navigate().back();

				//Store all the links
				List<WebElement> bl=driver.findElements(By.tagName("a"));

				//Display total links
				//System.out.println("Total links "+bl.size());

				//Valid and invalid link
				for (int i = 0; i <= bl.size(); i++) {
					try {
						String ll=bl.get(i).getAttribute("href");
						
						URL url = new URL(ll);
						HttpURLConnection connection = (HttpURLConnection) url.openConnection();
						connection.setRequestMethod("GET");
						connection.connect();
						int code = connection.getResponseCode();
						// Condition to check whether the URL is valid or Invalid
						if (code == 200) {
						System.out.println("Valid link:" + ll);
						} else {
						System.out.println("INVALID link:" + ll);
						}          
						} catch (Exception e1) {
						System.out.println(e1.getMessage());
						}
				}
		
		
		
		
		// driver.close();
	}

}
