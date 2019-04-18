package abstracts;

import factories.UtilsFactory;
import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import utils.ActionsUtils;
import utils.WaitsUtils;

import java.util.List;
import java.util.Set;

public abstract class AbstractPage extends WebDriverPage {

    private final UtilsFactory utilsFactory;

    public AbstractPage(WebDriverProvider driverProvider) {
        super(driverProvider);
        this.utilsFactory = new UtilsFactory(super.getDriverProvider());
    }

    @Override
    protected WebDriverProvider getDriverProvider() {
        return super.getDriverProvider();
    }

    @Override
    protected Actions getActions() {
        return super.getActions();
    }

    @Override
    public void get(String url) {
        super.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return super.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return super.findElement(by);
    }

    @Override
    public String getPageSource() {
        return super.getPageSource();
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public void quit() {
        super.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return super.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return super.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return super.switchTo();
    }

    @Override
    public Navigation navigate() {
        return super.navigate();
    }

    @Override
    public Options manage() {
        return super.manage();
    }

    @Override
    public Keyboard getKeyboard() {
        return super.getKeyboard();
    }

    @Override
    public Mouse getMouse() {
        return super.getMouse();
    }

    @Override
    public Object executeScript(String s, Object... args) {
        return super.executeScript(s, args);
    }

    @Override
    public Object executeAsyncScript(String s, Object... args) {
        return super.executeAsyncScript(s, args);
    }

    @Override
    public Capabilities getCapabilities() {
        return super.getCapabilities();
    }

    public void navigateTo(String url){
        this.navigate().to(url);
    }

    public void navigateForward(){
        this.navigate().forward();
    }

    public void navigateBack(){
        this.navigate().back();
    }

    public void navigateRefresh(){
        this.navigate().refresh();
    }

    public WaitsUtils getWaitsUtils() {
        return this.utilsFactory.getWaits();
    }

    public ActionsUtils getActionsUtils() {
        return this.utilsFactory.getActions();
    }

    public void scrollToBottom() {
        this.getActionsUtils().scrollToBottom();
    }

    public void scrollTo(WebElement element) {
        this.getActionsUtils().scrollTo(element);
    }

    public void waitTime(long time) {
        this.getWaitsUtils().waitTime(time);
    }
}
