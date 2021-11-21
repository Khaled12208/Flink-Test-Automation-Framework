package org.uiframework.weathershoppertests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uiframework.framework.datahandler.DataFileType;
import org.uiframework.weathershopperpages.HomePage;

public class HomePageTests extends TestBase {

    private HomePage Home;
    private JSONObject data;

    @BeforeClass
    public void readData() throws Exception {
        data = factory.DataFileType(DataFileType.JSON)
                .FromResourceFile("HomePageData/HomeTexts.json")
                .asJSONObject();
        Home = new HomePage(driver);

    }

    @Test
    public void UC01_verify_temperatureBoxTitle()  {
        String title = Home.getCurrentTempTitle().getText().trim();
        Assert.assertEquals(title,data.get("tempTitle"));
    }

    @Test
    public void UC02_verify_temperatureBox_isDisplayed() {
        Assert.assertTrue(Home.getCurrentTempElement().isDisplayed());
    }

    @Test
    public void UC03_verify_moisturizersBoxTitle() {
        String title = Home.getMoisturizersTitle().getText().trim();
        Assert.assertEquals(title,data.get("MonTitle"));
    }

    @Test
    public void UC04_verify_moisturizersBoxDescription() {
        String title = Home.getMoisturizersDescription().getText().trim();
        Assert.assertEquals(title,data.get("MonDesc"));
    }

    @Test
    public void UC05_verify_buyMoisturizers_isEnabled() {
        Assert.assertTrue(Home.getMoisturizersButton().isEnabled());
    }

    @Test
    public void UC06_verify_sunScreensBoxTitle() {
        Home = new HomePage(driver);
        String title = Home.getSunscreensTitle().getText().trim();
        Assert.assertEquals(title,data.get("SunTitle"));
    }

    @Test
    public void UC07_verify_sunScreensBoxDescription() {
        Home = new HomePage(driver);
        String title = Home.getSunscreensDescription().getText().trim();
        Assert.assertEquals(title,data.get("SunDesc"));
    }

    @Test
    public void UC08_verify_buySunScreens_isEnabled() {
        Home = new HomePage(driver);
        Assert.assertTrue(Home.getSunscreensButton().isEnabled());
    }

}
