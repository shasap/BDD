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

    public void sortDesktopByZtoA() {
        // click on desktop
        clickOnElement(_deskop);
        // check current url contains desktops
        driver.getCurrentUrl().contains("desktops");
        // Select dropdown position and select ZtoA
        Select position = new Select(driver.findElement(_sortDesktop));
        position.selectByValue("6");
        // Array list to store actual string value
        ArrayList<String> actualArrayList = new ArrayList<>();

        //ArrayList to store actual Web element value
        ArrayList<WebElement>elementList = new ArrayList<WebElement>(driver.findElements(By.className("product-title")));
        // To print actual web element ArrayList
        System.out.println("Actual list displayed after sorting Z to A : ");
        for (WebElement we: elementList) {
            actualArrayList.add(we.getText());
        }
        System.out.println(actualArrayList);

        // To print expected Web element Array list (correct Z to A order)

        //Arraylist for expected product title - we are going to store in string (new String Arraylist)
        ArrayList<String>expectedSortedList = new ArrayList<>();
        // Now we have to add product title to expectedSortedList from actual arrayList
        // We use for each loop
        for (String s:actualArrayList) {
            expectedSortedList.add(s);
        }
        // Now Sort expectedSortedList in alphabetical order( if it is not already in alphabetical order)
        Collections.sort(expectedSortedList);
        // Reverse alphabetical order (Z to A)
        Collections.reverse(expectedSortedList);
        // Print expected sorted Z to A list
        System.out.println("Expected list after Z to A should be : ");
        System.out.println(expectedSortedList);

        // Verify product display in Z to A order
        Assert.assertEquals(actualArrayList,expectedSortedList,"List element not sorted in Z to A order");

    }
}
