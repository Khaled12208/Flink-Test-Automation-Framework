package org.uiframework.weathershopperpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends PageBase{


    private final By PageTitle = By.xpath("//h2[contains(text(),'Checkout')]");


    //This Constructor to init the super constructors
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }


    public WebElement getPageTitleElement() {
        return driver.findElement(PageTitle);
    }

    public String getPageTitle() {
        return getText(getPageTitleElement());
    }
}
