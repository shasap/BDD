package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NikeProducts extends Utils{

    LoadProperty loadProperty = new LoadProperty();
    private By _nikeProduct = By.cssSelector("h2");

    public void productsContainNikeTitle(){
        // expected URL contain the name of the product, user have searched
        String expectedURL = loadProperty.getProperty("productName");

        // Actual URL using .getCurrentUrl method
        String actualURL = driver.getCurrentUrl();

        // Verify actual URL contain searched product name
        Assert.assertTrue(actualURL.contains(expectedURL),"URL does not contain Nike");

        List<WebElement> productTitle = driver.findElements(_nikeProduct);

        // use 'for loop' from 1st product to size of list, ie. 0 to n number of product
        // we use productTitle.size() to get number of items in list

        for (int i = 0; i < productTitle.size(); i++) {

            // store product name in new string
            String nikeProducts = productTitle.get(i).getText();

            // verify new string contain product name
            Assert.assertTrue(nikeProducts.contains(loadProperty.getProperty("productName")), "Product title does not contain Nike word.");

        }
    }
}
