package base;

import com.thoughtworks.gauge.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class BasePageUtil extends BaseTest {

	public static final int DEFAULT_WAIT = 10;

	public static final int MAX_WAIT = 15;


	protected void untilElementAppear(By by, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public WebElement getElementBy(By by) {
		untilElementAppear(by, MAX_WAIT);
		return driver.findElement(by);
	}


	public WebElement clickObjectBy(By by) {

		untilElementAppear(by,DEFAULT_WAIT);
		WebElement element = getElementBy(by);
		element.click();
		return element;
	}

	public WebElement setObjectBy(By by, String text) {
		WebElement element = getElementBy(by);
		element.sendKeys(text);
		return element;
	}

	public WebElement sendKeys(By by, String text) {
		WebElement element = getElementBy(by);
		element.sendKeys(text,Keys.ENTER);
		return element;
	}


	public void setObjectWithJavaScript(By by, String text) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='"+text+"';", element);

	}

	public boolean isElementExist(By by){
		try {
			untilElementAppear(by, DEFAULT_WAIT);
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Step("Wait <seconds> second")
	public void waitBySecondDeb(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	@Step("Hover to <by> element")
	public void hoverToElement(By by){


		WebElement element = getElementBy(by);
		log.info("Element " + element);

		String javaScript = "var evObj = document.createEvent('MouseEvents');"

				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"

				+ "arguments[0].dispatchEvent(evObj);";



		((JavascriptExecutor) driver).executeScript(javaScript, element);


	}

}




