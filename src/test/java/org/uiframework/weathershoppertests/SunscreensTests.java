package org.uiframework.weathershoppertests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.uiframework.framework.datahandler.DataFileType;
import org.uiframework.weathershopperpages.HomePage;
import org.uiframework.weathershopperpages.SunscreensPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SunscreensTests extends TestBase  {

    private HomePage homePage;
    private SunscreensPage sunscreensTests;


    @BeforeClass
    public void initPages()
    {
        homePage = new HomePage(driver);
        sunscreensTests = new SunscreensPage(driver);
    }


    @Test
    public void UC01_verify_pageTitle() throws Exception {
        HashMap<String,String> data= factory.DataFileType(DataFileType.PROP)
                .FromResourceFile("SunscreensPageData/PageTitle.properties")
                .asHashMap();
        homePage.clickBuySunscreens();
        String title = sunscreensTests.getPageTitle().getText().trim();
        Assert.assertEquals(title,data.get("PageTitle"));
    }

    @Test
    public void UC02_verify_cartButtonIsEnabled()  {
        Assert.assertTrue(sunscreensTests.getCartButton().isEnabled());
    }

    @Test
    public void UC03_verify_productImagesNotBroken() throws IOException {
        List<WebElement> productsList = sunscreensTests.getImages();
        for (WebElement product : productsList){
            Assert.assertTrue(sunscreensTests.verifyImgActive(product));
        }

    }

    @Test
    public void UC04_verify_cartCounter() {
        sunscreensTests.addFirstProductToCart();
        Assert.assertNotNull(sunscreensTests.getCardItemsNumber());

    }

}
