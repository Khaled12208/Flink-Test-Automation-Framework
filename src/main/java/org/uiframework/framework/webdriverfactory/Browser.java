package org.uiframework.framework.webdriverfactory;

import org.openqa.selenium.WebDriver;
import org.uiframework.framework.testconfiguration.TestConfiguration;

public interface Browser  {

    WebDriver GetBrowser(TestConfiguration config) throws Exception ;

}
