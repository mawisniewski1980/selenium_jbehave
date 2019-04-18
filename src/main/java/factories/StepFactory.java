package factories;

import extend.PerStoriesWebDriverStepsExt;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.web.selenium.PerStoriesWebDriverSteps;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import steps.OpenHomePagePhpTravelsSteps;

import java.util.Arrays;
import java.util.List;


public class StepFactory {

    private PageFactory pageFactory;
    private Configuration configuration;

    public StepFactory(PageFactory pageFactory, Configuration configuration) {
        this.pageFactory = pageFactory;
        this.configuration = configuration;
    }

    public List<Object> getStepsInstances() {
        return Arrays.asList(
                new PerStoriesWebDriverStepsExt(this.pageFactory.getDriverProvider()),
                new WebDriverScreenshotOnFailure(this.pageFactory.getDriverProvider(), this.configuration.storyReporterBuilder()),
                new OpenHomePagePhpTravelsSteps(this.pageFactory));
    }

}
