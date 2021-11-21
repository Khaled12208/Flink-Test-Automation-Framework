package org.uiframework.weathershopperpages;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;


public class PageBase {

    // Global variables for all pages
    public WebDriver driver;
    public JavascriptExecutor js;

    // Constructor to init all web driver and js excutor
    public PageBase(WebDriver webDriver) {

        this.driver = webDriver;
        this.js = ((JavascriptExecutor) driver);

    }


    // Click on Element
    public void clickElement(WebElement Element) {

        Element.click();
    }

    // Send Text to Element
    public void SendKeys(WebElement Element, String values) {

        Element.sendKeys(values.trim());
    }

    // Send Text to Element
    public void SendKeys(WebElement Element, Keys modifierKey) {

        Element.sendKeys(modifierKey);
    }

    // Handling Drop Selection by value
    public void SelectByValue(WebElement Element, String values) {
        Select s = new Select(Element);
        s.selectByValue(values);

    }

    // Handling Drop Selection by Index
    public void SelectByIndexe(WebElement Element, int values) {
        Select s = new Select(Element);
        s.selectByIndex(values);

    }

    // Handling Drop Selection by Visual Text
    public void selectByVisualText(WebElement Element, String values) {
        Element.click();
        Select s = new Select(Element);
        s.selectByVisibleText(values);
    }

    // Extracting text from web Element
    public String getText(WebElement Element) {

        return Element.getText();

    }

    // Check if Element is Displayed
    public boolean isDisplayed(WebElement Element) {

        return Element.isDisplayed();

    }

    public void changeWindowsSizeTo(String WindowWidth, String WindowHeight) {
        Dimension WindowDimension = new Dimension(Integer.parseInt(WindowWidth), Integer.parseInt(WindowHeight));
        driver.manage().window().setSize(WindowDimension);
    }

    public int getWindowsWidth(WebDriver driver) {
        return driver.manage().window().getSize().width;
    }

    public int getWindowsHigh(WebDriver driver) {
        return driver.manage().window().getSize().height;
    }

    public void AssertCurrentURLis(String URL) {
        Assert.assertTrue(URL.equalsIgnoreCase(driver.getCurrentUrl()));

    }

    public void AssertPostionOfElement(WebElement Elment, int x, int y) {
        Assert.assertEquals(x, Elment.getLocation().getX());
        Assert.assertEquals(y, Elment.getLocation().getY());
    }


    public void AssertCurrentWidowSizeis(String URL) {
        driver.getCurrentUrl().equalsIgnoreCase(URL);
    }

    public void NavigateBack() {
        driver.navigate().back();

    }

    public Boolean verifyImgActive(WebElement img) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(img.getAttribute("src"));
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {

            return false;
        } else {

            return true;
        }

    }
}
