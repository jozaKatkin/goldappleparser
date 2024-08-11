package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {

    private static final ThreadLocal<WebDriver> DRIVER_STORAGE = new ThreadLocal<>();

    public static WebDriver initDriver() {
        if (DRIVER_STORAGE.get() == null) {
            DRIVER_STORAGE.set(setDriverConfigs());
            setUpImplicitWait();
        }
        return DRIVER_STORAGE.get();
    }

    private static WebDriver setDriverConfigs() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
//        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=2560x1440");
        return new ChromeDriver(options);
    }

    private static void setUpImplicitWait() {
        DRIVER_STORAGE.get()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(5));
    }

    public static void quitWebDriver() {
        DRIVER_STORAGE.get().close();
        DRIVER_STORAGE.get().quit();
        DRIVER_STORAGE.remove();
    }

    public static void killAllDrivers() {
        while (DRIVER_STORAGE.get() != null) {
            DRIVER_STORAGE.get()
                    .quit();
        }
    }
}
