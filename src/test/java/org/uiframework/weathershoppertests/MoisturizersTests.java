package org.uiframework.weathershoppertests;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uiframework.framework.datahandler.DataFileType;
import org.uiframework.weathershopperpages.HomePage;
import org.uiframework.weathershopperpages.MoisturizersPage;

import java.io.IOException;
import java.util.List;

public class MoisturizersTests extends TestBase {

    private MoisturizersPage moisturizersPage;
    private HomePage homePage;

    @BeforeClass
    public void initPages()
    {
        homePage = new HomePage(driver);
        moisturizersPage = new MoisturizersPage(driver);
    }


    @Test
    public void UC01_verify_pageTitle() throws Exception {
        JSONObject data= factory.DataFileType(DataFileType.JSON)
                .FromResourceFile("MoisturizersPageData/PageTitle.json")
                .asJSONObject();
        homePage.clickBuyMoisturizers();
        String title = moisturizersPage.getPageTitle().getText().trim();
        Assert.assertEquals(title,data.get("PageTitle"));
    }

    @Test
    public void UC02_verify_cartButtonIsEnabled()  {
        Assert.assertTrue(moisturizersPage.getCartButton().isEnabled());
    }

    @Test
    public void UC03_verify_productImagesNotBroken() throws IOException {
        List<WebElement> productsList = moisturizersPage.getImages();
        for (WebElement product : productsList){
            Assert.assertTrue(moisturizersPage.verifyImgActive(product));
        }

    }

    @Test
    public void UC04_verify_cartCounter() {
        moisturizersPage.addFirstProductToCart();
        Assert.assertNotNull(moisturizersPage.getCardItemsNumber());

    }

}
