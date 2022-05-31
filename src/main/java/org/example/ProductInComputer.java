package org.example;

import org.openqa.selenium.By;

public class ProductInComputer extends Utils{

    private By _desktopComputersCategories = By.xpath("//li[@class=\"inactive\"]/a[@href=\"/desktops\"]");
    public void SelectDesktop(){
        //Click Desktop in computers in categories
        clickOnElement(_desktopComputersCategories);
    }
}
