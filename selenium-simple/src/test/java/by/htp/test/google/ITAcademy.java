package by.htp.test.google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ITAcademy {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "e:\\driver\\chromedriver.exe";

	public static void main(String[] args) {

		System.setProperty(CHROME, CHROME_PATH);
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.it-academy.by/?set_city=84");
		driver.manage().window().maximize();

		WebElement learningMenuItem = driver
				.findElement(By.xpath("/html/body/div[1]/asside/div/div/div[2]/div[2]/ul/li[1]/a/span"));

		Actions actions = new Actions(driver);
		actions.moveToElement(learningMenuItem).build().perform();

		List<WebElement> subMenuTitles = driver
				.findElements(By.xpath("/html/body/div[1]/main/section[1]/section[1]/div/ul/li"));

		WebElement preCourses = null;

		for (WebElement element : subMenuTitles) {

			WebElement title = element.findElement(By.xpath("a/span"));
			System.out.println(title.getText().replaceAll("\\u00AD", ""));

			List<WebElement> subSub = element.findElements(By.xpath("ul/li"));
			for (WebElement el : subSub) {
				WebElement t = el.findElement(By.xpath("a"));
				String tit = t.getText();
				System.out.println("   - " + tit);
				if (tit.equals("Подготовительные курсы")) {
					preCourses = t;
				}
			}
		}

		if (preCourses != null) {
			preCourses.click();
			List<WebElement> course = driver
					.findElements(By.xpath("/html/body/div[1]/main/section[2]/div/div/section[1]/div"));
			for (WebElement e : course) {

				System.out.println(e.findElement(By.xpath("h2")).getText());
				try {
					WebElement dd = e.findElement(By.xpath("div[3]/div/div[1]/div"));
					System.out.println(dd.getText());
				} catch (NoSuchElementException ex) {
					System.out.println("No start date");
				}
			}
		}

		driver.close();
	}

}
