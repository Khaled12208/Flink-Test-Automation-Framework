package org.uiframework.weathershoppertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.uiframework.framework.datahandler.DataFileFactory;
import org.uiframework.framework.testconfiguration.*;
import org.uiframework.framework.webdriverfactory.DriverFactory;

import java.time.Duration;


public class TestBase {

    // The webserver configuration
    protected final DataFileFactory factory = new DataFileFactory(TestBase.class);
    protected final TestConfiguration config = new TestConfigurationBuilder()
            .setBrowser(BrowserType.EDGE)
            .setBrowserCustomDimensions(BrowserSize.MAX)
            .setWindowType(ExecutionPrivacy.PUBLIC)
            .setExecutionMode(ExecutionMode.HEADFULL)
            .Build();
    protected WebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void Browser_Init() throws Exception {
        driver = new DriverFactory(config).OpenBrowser();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://weathershopper.pythonanywhere.com/");

    }

    @AfterTest(alwaysRun = true)
    public void Browser_Termination() {
       driver.quit();
    }


}
