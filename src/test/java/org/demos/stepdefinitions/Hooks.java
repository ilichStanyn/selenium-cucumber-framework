package org.demos.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.demos.utils.Browsers;
import org.demos.utils.ManagerBrowser;
import org.demos.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;

public class Hooks {
    static WebDriver driver;
    static ScreenshotUtils screenshot;


    @Before
    public void setUp() {
        if (driver == null) {
            String browser = System.getProperty("browser", Browsers.CHROME.name());
            //Logs.debug("Instanciando el navegador");
            driver = ManagerBrowser.getDriver(browser);
            screenshot = new ScreenshotUtils(driver);
            //screenshot.cleanScreenshotDirectory();
        }

    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            String scName = scenario.getName() + "-failed";
            screenshot.takeScreeshot(scName, "failed");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            //Logs.debug("Cerrando la instancia del navegador");
            String status = scenario.isFailed() ? "failed" : "passed";
            screenshot.takeScreeshot(scenario.getName(), status);
            driver.quit();
            driver = null;
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }
}
