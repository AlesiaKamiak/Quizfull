//Прочитать с tut.by название главной новости. Кликнуть на главную новость,
//посчитать количество параграфов в тексте новости. 

package by.htp.test.google;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainNews {
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
		driver.get("http://tut.by");
		
		WebElement mainNewsLink = driver.findElement(By.className("entry-anounce"));
		mainNewsLink.click();
		Thread.sleep(2000);

		
		WebElement newsContent = driver.findElement(By.id("article_body"));
		

		List<WebElement> p = newsContent.findElements(By.tagName("p"));
		System.out.println(p.size());
		driver.close();

		

		

	}

}
