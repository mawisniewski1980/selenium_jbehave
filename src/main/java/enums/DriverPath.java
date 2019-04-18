package enums;

public enum DriverPath {

    CHROME("/src/lib/chromedriver.exe"),
    FIREFOX("/src/lib/geckodriver.exe");

    String path;

    DriverPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
