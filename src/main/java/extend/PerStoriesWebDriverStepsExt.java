package extend;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.web.selenium.PerStoriesWebDriverSteps;
import org.jbehave.web.selenium.WebDriverProvider;
import utils.WaitsUtils;

import java.util.concurrent.TimeUnit;

public class PerStoriesWebDriverStepsExt extends PerStoriesWebDriverSteps {

    public PerStoriesWebDriverStepsExt(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    @Override
    @BeforeStories
    public void beforeStories() throws Exception {
        super.beforeStories();
        super.driverProvider.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        super.driverProvider.get().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        super.driverProvider.get().manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        super.driverProvider.get().manage().window().maximize();
    }

    @Override
    @AfterStories
    public void afterStories() throws Exception {
        super.driverProvider.get().manage().deleteAllCookies();
        super.afterStories();
    }


}
