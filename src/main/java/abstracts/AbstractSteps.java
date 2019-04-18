package abstracts;

import factories.PageFactory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public abstract class AbstractSteps {

    private final PageFactory pageFactory;

    public AbstractSteps(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }

    @Given("open the page on $address")
    public void openPage(@Named("address") String address){
        this.pageFactory.getPage().navigateTo(address);
    }

    @Then("check title of the page $title")
    public void checkTitleOfPage(@Named("titile") String title){
        Assert.assertEquals("Check if title is correct: ", title, this.pageFactory.getPage().getTitle());
    }

    @Then("scroll to bottom")
    public void scrollToBottom() {
        this.pageFactory.getPage().scrollToBottom();
    }

    @Then("wait $howMany seconds")
    public void waitTime(@Named("howMany") long howMany) {
        this.pageFactory.getPage().waitTime(howMany);
    }

    @Then("finish test")
    public void finishTest() {

    }

}
