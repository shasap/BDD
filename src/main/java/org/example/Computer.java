package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;



public class Computer extends Utils {
    private By _deskop = By.xpath("//h2 /a[@href=\"/desktops\" ]");
    private By _sortDesktop = By.id("products-orderby");
    private By _actualProductList = By.cssSelector("[class=\"product-title\"]");

    public void sortDesktopByZtoA(){
        // click on desktop
        clickOnElement(_deskop);
        // check current url contains desktops
        driver.getCurrentUrl().contains("desktops");
        // Select dropdown position and select ZtoA
        Select position = new Select(driver.findElement(_sortDesktop));
        position.selectByValue("6");
        // Actual array list
        List<WebElement>actualList = driver.findElements(_actualProductList);
        for (int i = 0; i <actualList.size() ; i++) {
            String actualProductTitleAfterSorting = actualList.get(i).getText();
            System.out.println("Actual product title is "+actualProductTitleAfterSorting);
        }

    }
}
