
import drivers.Drivers;
import enums.DriverPath;
import factories.StepFactory;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.executors.DirectExecutorService;
import org.jbehave.core.embedder.executors.SameThreadExecutors;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.steps.StepFinder;
import org.jbehave.web.selenium.*;
import factories.PageFactory;
import org.openqa.selenium.chrome.ChromeDriverService;
import steps.OpenHomePagePhpTravelsSteps;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

import static java.util.Arrays.sort;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


public class ConfigStories extends JUnitStories {

    private final WebDriverProvider webDriverProvider;
    private SeleniumContext seleniumContext;
    private ContextView contextView;

    public ConfigStories() {

        Drivers.getInstance().setChromeDriver();
        this.webDriverProvider = new PropertyWebDriverProvider();
        this.seleniumContext = new SeleniumContext();
        this.contextView = new ContextView.NULL();

        this.configuredEmbedder().useExecutorService(new DirectExecutorService().create(configuredEmbedder().embedderControls()));
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();

        return new SeleniumConfiguration()
                .useSeleniumContext(this.seleniumContext)
                .useWebDriverProvider(this.webDriverProvider)
                .useStepMonitor(new SeleniumStepMonitor(this.contextView, this.seleniumContext, new SilentStepMonitor()))
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStepFinder(new StepFinder())
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        PageFactory pageFactory = new PageFactory(this.webDriverProvider);
        StepFactory stepFactory = new StepFactory(pageFactory, configuration());

        return new InstanceStepsFactory(configuration(), stepFactory.getStepsInstances());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/java").getFile(), asList("**/*.story"), null);
    }


}
