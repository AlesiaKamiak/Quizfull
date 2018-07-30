//Выполнить регистрацию на сайте quzful.net в качестве корпоративного сотрудника. 
package by.htp.test.google;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuizfulNet {
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
		driver.get("http://www.quizful.net/test");
		
	WebElement registration = driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[3]/a"));
	registration.click();
	Thread.sleep(2000);

	WebElement loginField = driver.findElement(By.name("registrationForm.login"));
	Assert.assertNotNull(loginField);
	loginField.sendKeys("asdfg");
	
	WebElement passwordField = driver.findElement(By.name("registrationForm.password"));
	Assert.assertNotNull(passwordField);
	passwordField.sendKeys("12345");

	WebElement rePasswordField = driver.findElement(By.name("registrationForm.repassword"));
	Assert.assertNotNull(rePasswordField);
	rePasswordField.sendKeys("12345");
	
	WebElement emailField = driver.findElement(By.name("registrationForm.email"));
	Assert.assertNotNull(emailField);
	emailField.sendKeys("1@tut.by");
	
	WebElement corporateCheckbox = driver.findElement(By.id("corporate-help"));
	corporateCheckbox.click();
	
	
	WebElement captchaElement = driver.findElement(By.name("registrationForm.captcha"));
	captchaElement.click();
	while(captchaElement.getAttribute("value").length()!=5) {
		Thread.sleep(100);
	}


	WebElement reg = driver.findElement(By.name("ok"));
	reg.click();
	
	System.out.println("Done");


	

	
	
	
		}

}
