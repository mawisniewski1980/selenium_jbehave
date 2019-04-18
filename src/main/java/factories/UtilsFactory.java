package factories;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import pages.Home;
import utils.ActionsUtils;
import utils.WaitsUtils;

public class UtilsFactory {

    private WebDriverProvider driverProvider;
    private WaitsUtils waits;
    private ActionsUtils actions;

    public UtilsFactory(WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    public WebDriver getDriver() {
        return this.driverProvider.get();
    }

    public WaitsUtils getWaits() {
        if (waits == null ){
            waits = new WaitsUtils(driverProvider);
        }
        return waits;
    }

    public ActionsUtils getActions() {
        if (actions == null) {
            actions = new ActionsUtils(driverProvider);
        }
        return actions;
    }

}
