package org.uiframework.weathershopperpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Scanner;

public class HomePage extends PageBase {

    // Web Elements Declaration
    private final By currentTempTitle = By.xpath("//div[1]/div[1]/h2[1]");
    private final By currentTempValue = By.xpath("//div[2]/div[1]/span[1]");
    private final By moisturizersTitle = By.xpath("//div[3]/div[1]/h3[1]");
    private final By moisturizersDescription = By.xpath("//div[3]/div[1]/p[1]");
    private final By moisturizersButton = By.xpath("//div[3]/div[1]/a[1]/button[1]");
    private final By sunscreensTitle = By.xpath("//div[3]/div[2]/h3[1]");
    private final By sunscreensDescription = By.xpath("//div[3]/div[2]/p[1]");
    private final By sunscreensButton = By.xpath("//div[3]/div[2]/a[1]/button[1]");

    // This Constructor is used to init the super web driver on page base
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    // Web Elements Getter
    public WebElement getCurrentTempTitle() {
        return driver.findElement(currentTempTitle);
    }

    public WebElement getCurrentTempElement() {
        return driver.findElement(currentTempValue);
    }

    public WebElement getMoisturizersTitle() {
        return driver.findElement(moisturizersTitle);
    }

    public WebElement getMoisturizersDescription() {
        return driver.findElement(moisturizersDescription);
    }

    public WebElement getMoisturizersButton() {
        return driver.findElement(moisturizersButton);
    }

    public WebElement getSunscreensTitle() {
        return driver.findElement(sunscreensTitle);
    }

    public WebElement getSunscreensDescription() {
        return driver.findElement(sunscreensDescription);
    }

    public WebElement getSunscreensButton() {
        return driver.findElement(sunscreensButton);
    }

    public Integer getCurrentTempValue() {
        String temp =  driver.findElement(currentTempValue).getText();
        Scanner in = new Scanner(temp).useDelimiter("[^0-9]+");
        int integer = in.nextInt();
        return integer;
    }

    // Web Elements Actions
    public void clickBuyMoisturizers() {
        clickElement(getMoisturizersButton());
    }

    public void clickBuySunscreens() {
        clickElement(getSunscreensButton());
    }
}
