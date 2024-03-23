package helper;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {

	public static Properties prop;
	public static WebDriver driver;

	static {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resource/env.properties");

			prop = new Properties();

			try {
				prop.load(file);
			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setup() {
		String browserName = prop.getProperty("browser");

		switch (browserName) {

		case "chrome":

			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			driver = new ChromeDriver(option);
			break;

		case "Firefox":
			FirefoxOptions option1 = new FirefoxOptions();
			option1.addArguments("--incognito");
			driver = new FirefoxDriver(option1);
			break;

		case "Edge":
			EdgeOptions option2 = new EdgeOptions();
			option2.addArguments("--incognito");
			driver = new EdgeDriver(option2);
			break;

		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	public void selectDropDown(WebElement ele, String value, String type) {

		Select s = new Select(ele);

		switch (type) {

		case "visibleText":
			s.selectByVisibleText(value);
			break;

		case "visbibleIndex":
			s.selectByIndex(Integer.parseInt(value));
			break;

		case "visbleValue":
			s.selectByValue(value);
			break;
		}

	}

	public void actionMethod(WebElement ele, String methodType) {

		Actions a = new Actions(driver);

		switch (methodType) {

		case "mouseHover":
			a.moveToElement(ele).build().perform();
			break;

		case "click":
			a.click(ele).build().perform();
			break;

		}
	}

	public void bootStrapDropDown(List<WebElement> list, String value) {

		for (WebElement ele : list) {

			String eleText = ele.getText();

			if (eleText.equals(value)) {

				ele.click();

				break;
			}
		}
	}

	public void executorClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].click();", ele);
	}

	
	public void expcilitWait(int timeout, WebElement ele, String condition) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		switch (condition) {

		case "clickable":
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			break;

		case "visible":
			wait.until(ExpectedConditions.visibilityOf(ele));
			break;

		case "alert":
			wait.until(ExpectedConditions.alertIsPresent());
			break;

		}

	}

	public void handleAlert(String type) {

		expcilitWait(10, null, "alert");

		Alert a = driver.switchTo().alert();

		switch (type) {

		case "select":
			a.accept();
			break;

		case "cancel":
			a.dismiss();
			break;

		}
	}

	public void clickOnElement(WebElement ele) {

		expcilitWait(10, ele, "clicable");

		try {
			ele.click();
		} catch (Exception e) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click", ele);
		}

	}

	public void validateText(WebElement ele, String expected) {

		expcilitWait(10, ele, expected);

		String actualValue = ele.getText();
		assertEquals(actualValue, expected);

	}

	@After
	public void tearDown(Scenario s) throws IOException {
		if (s.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File src = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(src, new File("ScreenShots/" + s.getName() + ".png"));

		}
		driver.quit();
	}

	public void switchFrame(String value, String type) {
		switch (type) {
		case "name":
			driver.switchTo().frame(value);
			break;
		case "index":
			driver.switchTo().frame(Integer.parseInt(value));
			break;
		}
	}

	public void switchWindow(String title) {

		Set<String> allwindow = driver.getWindowHandles();

		for (String s : allwindow) {

			driver.switchTo().window(s);

			String currentTitle = driver.getTitle();
			if (currentTitle.equals(title)) {

				break;
			}
		}

	}
}
