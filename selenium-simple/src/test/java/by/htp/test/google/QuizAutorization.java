/*
 4 Авторизоваться на сайте quzful.net. Зайти в настройки профиля. Оредактировать профиль следующим образом:
- в разделе «Личные данные» заполнить поля: имя, фамилия, год рождения, сайт, компания. Выбрать страну, город, верный часовой пояс. Заполнить поле «О себе».
- в разделе «Уведомления» убрать отметку для полей «Включить уведомления» и «Получать рассылку».
- в разделе «Конфиденциальность» выбрать пункт «Только я» для настройки видимости профиля.
- *При редактировании личного профиля на сайте загрузить аватар (выполнять при наличии сил и желания программировать дальше  ).
*/

package by.htp.test.google;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class QuizAutorization {

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
		driver.get("http://www.quizful.net/LoginAction.loginForm?registered=");

		WebElement loginField = driver.findElement(By.name("loginForm.login"));
		Assert.assertNotNull(loginField);
		loginField.sendKeys("AlesMe");

		WebElement passwordField = driver.findElement(By.name("loginForm.password"));
		Assert.assertNotNull(passwordField);
		passwordField.sendKeys("12345");

		WebElement enterButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/form/p/input"));
		enterButton.click();
		Thread.sleep(1000);

		WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[1]/b"));
		profileButton.click();

		WebElement profileSettings = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div[1]/div[2]/div/a"));
		profileSettings.click();

		// Personal information

		WebElement open = driver.findElement(By.xpath("//*[@id=\"profile-personal-form\"]/div[2]/img"));
		open.click();

		WebElement persFormNameField = driver.findElement(By.name("personalForm.name"));
		if (persFormNameField.getAttribute("value").isEmpty() == true) {
		} else {
			persFormNameField.clear();
		}
		persFormNameField.sendKeys("Ales");

		WebElement persFormSurnameField = driver.findElement(By.name("personalForm.surname"));
		if (persFormSurnameField.getAttribute("value").isEmpty() == true) {
		} else {
			persFormSurnameField.clear();
		}
		persFormSurnameField.sendKeys("Me");

		WebElement persYearField = driver.findElement(By.name("personalForm.birthyear"));
		if (persYearField.getAttribute("value").isEmpty() == true) {
		} else {
			persYearField.clear();
		}
		persYearField.sendKeys("2000");

		WebElement siteField = driver.findElement(By.name("personalForm.site"));
		if (siteField.getAttribute("value").isEmpty() == true) {
		} else {
			siteField.clear();
		}
		siteField.sendKeys("tut.by");

		WebElement companyField = driver.findElement(By.name("personalForm.company"));
		if (companyField.getAttribute("value").isEmpty() == true) {
		} else {
			companyField.clear();
		}
		companyField.sendKeys("tut");

		WebElement countryField = driver.findElement(By.name("personalForm.countryId"));
		countryField.click();
		Select chooseCountry = new Select(driver.findElement(By.name("personalForm.countryId")));
		chooseCountry.selectByVisibleText("Беларусь");

		WebElement cityField = driver.findElement(By.name("personalForm.cityId"));
		cityField.click();
		Select chooseCity = new Select(driver.findElement(By.name("personalForm.cityId")));
		chooseCity.selectByVisibleText("Минск");

		WebElement zoneField = driver.findElement(By.name("personalForm.zone"));
		zoneField.click();
		Select chooseZone = new Select(driver.findElement(By.name("personalForm.zone")));
		chooseZone.selectByVisibleText("Россия/Москва(GMT+4)");

		WebElement aboutField = driver.findElement(By.name("personalForm.about"));
		if (aboutField.getAttribute("value").isEmpty() == true) {
		} else {
			aboutField.clear();
		}
		aboutField.sendKeys("A good person");

		WebElement savePers = driver.findElement(By.name("personalForm.save"));
		savePers.click();

		WebElement settings = driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div[1]/div[2]/div/a"));
		settings.click();

		// Notifications
		// проверяем, стоит ли галочка

		WebElement notification = driver.findElement(By.xpath("//*[@id=\"profile-notifications-form\"]/div[1]/img"));
		notification.click();

		List<WebElement> notificationEnabled = driver
				.findElements(By.name("notificationsForm.notificationsEnabled"));
		Assert.assertTrue(notificationEnabled.get(0).isSelected());
	//	Assert.assertFalse(notificationEnabled.get(1).isSelected());
//
//		List<WebElement> deliveryEnabled = driver.findElements(By.name("notificationsForm.deliveryEnabled"));
//		Assert.assertTrue(deliveryEnabled.get(0).isSelected());
//		Assert.assertTrue(deliveryEnabled.get(1).isSelected());
//		
		// WebElement notificationEnabled =
		// driver.findElement(By.name("notificationsForm.notificationsEnabled"));
		// notificationEnabled.click();
		// WebElement deliveryEnabled =
		// driver.findElement(By.name("notificationsForm.deliveryEnabled"));
		// deliveryEnabled.click();

		// Privacy

		WebElement privacy = driver.findElement(By.xpath("//*[@id=\"profile-privacy-form\"]/div[1]/img"));
		privacy.click();
		WebElement meOnly = driver.findElement(By.name("privacyForm.profileVisibility"));
		meOnly.click();
		WebElement save = driver.findElement(By.name("privacyForm.save"));
		save.click();

	}
}
