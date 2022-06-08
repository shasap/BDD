package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

        ArrayList<String> actualArrayList=new ArrayList<>();
        actualArrayList.add("Build your own computer");
        actualArrayList.add("Digital Storm VANQUISH 3 Custom Performance PC");
        actualArrayList.add("Lenovo IdeaCentre 600 All-in-One PC");
        System.out.println("actual arraylist");
        for(String actualStr: actualArrayList){
            System.out.println(actualStr);
        }

        ArrayList<String> expectedArrayList=new ArrayList<>();
        expectedArrayList.add("Lenovo IdeaCentre 600 All-in-One PC");
        expectedArrayList.add("Digital Storm VANQUISH 3 Custom Performance PC");
        expectedArrayList.add("Build your own computer");
        System.out.println("expected arraylist");
        for(String expectedStr: expectedArrayList){
            System.out.println(expectedStr);
        }

        Assert.assertEquals(actualArrayList,expectedArrayList,"arraylist elements are not in Z to A  order");

    }
}
