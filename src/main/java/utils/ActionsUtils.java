package utils;

import enums.JSCommands;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    private WebDriverProvider driverProvider;
    private Actions actions;

    public ActionsUtils(WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
        this.actions = new Actions(this.driverProvider.get());
    }

    private Actions getActions() {
        return actions;
    }

    private WebDriverProvider getDriverProvider() {
        return driverProvider;
    }

    private void jSExectutor(String command) {
       ((JavascriptExecutor) this.getDriverProvider().get()).executeScript(command);
    }

    private void jSExectutor(String command, WebElement element) {
       ((JavascriptExecutor) this.getDriverProvider().get()).executeScript(command, element);
    }

    public ActionsUtils scrollToBottom() {
        this.jSExectutor(JSCommands.SCROLLTOBOTTOM2.getCommand());
        return this;
    }

    public ActionsUtils scrollTo(WebElement element) {
        this.jSExectutor(JSCommands.SCROLLTO.getCommand(), element);
        return this;
    }

}
