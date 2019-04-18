package factories;

import org.jbehave.web.selenium.WebDriverProvider;
import pages.Home;
import pages.Page;

public class PageFactory {

    private final WebDriverProvider driverProvider;
    private Page page;
    private Home home;

    public PageFactory(WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    public WebDriverProvider getDriverProvider() {
        return driverProvider;
    }

    public Page getPage() {
        if(page == null) {
            page = new Page(driverProvider);
        }
        return page;
    }

    public Home getHome(){
        if (home == null ){
            home = new Home(driverProvider);
        }
        return home;
    }




}
