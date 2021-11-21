package org.uiframework.weathershopperpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SunscreensPage extends PageBase {

    // Web Elements Declaration
    private final By cartButton = By.xpath("//ul[@class=\"navbar-nav ml-auto\"]/button[1]");
    private final By pageTitle = By.xpath("//div[1]/div[1]/h2[1]");
    private final By productNames = By.xpath("//div[@class=\"container\"]//p[1]");
    private final By productPrices = By.xpath("//div[@class=\"container\"]//p[2]");
    private final By productImages = By.xpath("//div[@class=\"container\"]//img");
    private final By productsAddButtons = By.xpath("//div[@class=\"container\"]//button");


    // This Constructor is used to init the super web driver on page base
    public SunscreensPage(WebDriver webDriver) {
        super(webDriver);
    }

    // This Constructor is used to init the super web driver on page base
    public WebElement getCartButton() {
        return driver.findElement(cartButton);
    }

    public WebElement getPageTitle() {
        return driver.findElement(pageTitle);
    }

    public List<WebElement> getImages() {
        return driver.findElements(productImages);
    }


    public List<WebElement> getProductsNames() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductsPrices() {
        return driver.findElements(productPrices);
    }

    public List<WebElement> getProductsAddButtons() {
        return driver.findElements(productsAddButtons);
    }
    public void clickCart()
    {
        clickElement(getCartButton());

    }
    public void addToCardLeastExpensiveItemContains(String Keyword)
    {
        List<Integer> arrOfKeywordProductsIndex = new LinkedList<>();
        List<WebElement> productsNames = getProductsNames();
        List<WebElement>productsAddButton = getProductsAddButtons();
        List<WebElement>productsPrices = getProductsPrices();
        for(int i = 0 ; i < productsNames.size() ; i++) {
            if (productsNames.get(i).getText().trim().contains(Keyword))
            {
                arrOfKeywordProductsIndex.add(i);
            }
        }

        if (arrOfKeywordProductsIndex.size()==1)
        {
            clickElement(productsAddButton.get(arrOfKeywordProductsIndex.get(0)));
        }else if(arrOfKeywordProductsIndex.size()>1)
        {
            Integer indexOFLeastExpensive = null;
            List<Integer> prices = new LinkedList<>();
            for(int i = 0 ; i < arrOfKeywordProductsIndex.size() ; i++) {

                String tempPrice=productsPrices.get(arrOfKeywordProductsIndex.get(i)).getText().trim();
                Scanner in = new Scanner(tempPrice).useDelimiter("[^0-9]+");
                prices.add(in.nextInt());
            }
            Integer temp= prices.get(0);
            for(int i = 0 ; i < prices.size() ; i++) {
                if (temp>=prices.get(i))
                {
                    temp= prices.get(i);
                    indexOFLeastExpensive=i;
                }
            }
            clickElement(productsAddButton.get(arrOfKeywordProductsIndex.get(indexOFLeastExpensive)));

        }else
        {
            SoftAssert softAssertion= new SoftAssert();
            softAssertion.assertEquals(Keyword,"No product with keyword: " + Keyword);

        }

    }
    public void addFirstProductToCart()
    {
        List<WebElement>productsAddButton = getProductsAddButtons();
        clickElement(productsAddButton.get(0));
    }

    public int getCardItemsNumber()
    {
        WebElement cart= driver.findElement(cartButton);
        Scanner in = new Scanner(getText(cart)).useDelimiter("[^0-9]+");
        return  in.nextInt();

    }

}
