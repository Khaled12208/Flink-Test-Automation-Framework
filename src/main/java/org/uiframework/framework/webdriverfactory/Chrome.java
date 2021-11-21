package org.uiframework.framework.webdriverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.uiframework.framework.testconfiguration.TestConfiguration;

public class Chrome implements Browser {

    // This Class is the Chrome Browser initializer

    private WebDriver driver;
    private ChromeOptions options;
    private DesiredCapabilities capabilities;



    @Override
    public WebDriver GetBrowser(TestConfiguration config) throws Exception {
        try {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(SetBrowserOption(config));
            return driver;

        } catch (Exception e) {
            throw new Exception(" Please Make Sure that the Chrome Browser is installed in your system : \n "+e.fillInStackTrace());

        }

    }

    private ChromeOptions SetBrowserOption(TestConfiguration config)
    {
        options = new ChromeOptions();
        capabilities= new DesiredCapabilities();
        if(config.getExecutionMode().toString().equalsIgnoreCase("HEADLESS"))
        {
            options.addArguments("--headless");
        }
        if(config.getWindowType().toString().equalsIgnoreCase("PRIVATE"))
        {
            options.addArguments("--incognito");

        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return  options.merge(capabilities);

    }
}
