package drivers;

import enums.DriverPath;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class Drivers {

    private volatile static Drivers uniqueInstance;

    private Drivers() {}

    public static Drivers getInstance() {
        if (uniqueInstance == null) {
            synchronized (Drivers.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Drivers();
                }

            }
        }
        return uniqueInstance;
    }


    public Drivers setChromeDriver() {
        System.setProperty("browser", "CHROME");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, new File( System.getProperty("user.dir") + DriverPath.CHROME.getPath()).getAbsolutePath());
        return this;
    }

}
