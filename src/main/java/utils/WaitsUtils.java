package utils;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitsUtils {

    private WebDriverWait waits;

    public WaitsUtils(WebDriverProvider driverProvider) {
        this.waits = new WebDriverWait(driverProvider.get(), 15);
    }

    private WebDriverWait getWaits() {
        return waits;
    }

    public WaitsUtils waitForVisibilityOfElement(WebElement element) {
        //waits.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WaitsUtils waitForVisibilityOfElements(List<WebElement> elements) {
        //waits.until(ExpectedConditions.visibilityOfAllElements(elements));
        return this;
    }

    public WaitsUtils waitForVisibilityOfElement(By locator) {
        //waits.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public WaitsUtils waitForVisibilityOfElements(By locator) {
        //waits.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return this;
    }

    public WaitsUtils waitForLoad() {
        //this.waits.until((ExpectedCondition<Boolean>) webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public WaitsUtils waitTime(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


}
