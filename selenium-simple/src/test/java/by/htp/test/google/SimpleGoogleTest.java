package by.htp.test.google;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleGoogleTest {
	
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "e:\\driver\\chromedriver.exe";
	private WebDriver driver;
	
	@Before
	public void initDriver() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
	}
	
	@Test
	public void testSearchFileExists() throws InterruptedException {
		driver.get("http://google.com");
		WebElement searchField  = driver.findElement(By.name("q"));
		Assert.assertNotNull(searchField);
		
		Thread.sleep(5000);
		
		searchField.sendKeys("Java");
		searchField.submit();
		
		List<WebElement>searchResults = driver.findElements(By.className("g"));
		
		String resultTabTitle = driver.getTitle();
		
		
		
		System.out.println(resultTabTitle);
		
		searchField.sendKeys("python");
		
		
		
	}

}
