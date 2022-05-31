package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class Registration extends Utils {

    private By _gender = By.id("gender-male");
    private By _firstName = By.xpath("//input[@name='FirstName']");
    private By _lastName = By.id("LastName");
    private By _dayOfBirth = By.name("DateOfBirthDay");
    private By _month = By.name("DateOfBirthMonth");
    private By _year = By.name("DateOfBirthYear");
    private By _email = By.id("Email");
    private By _password = By.name("Password");
    private By _confirmPassword = By.name("ConfirmPassword");
    private By _register = By.id("register-button");

    public void userShouldBeAbleToRegisterSuccessfully(){

        // verify user is on registration page
           driverWaitsUntilContainsUrl(10,"https://demo.nopcommerce.com/register?returnUrl=%2F");

        // select gender
        clickOnElement(_gender);

        // enter firstname
        typeText(_firstName,"Peter");

        //enter lastname
        typeText(_lastName,"Parker");

        // enter day of birth
        Select birthDay = new Select(driver.findElement(_dayOfBirth));
        birthDay.selectByValue("6");

        // enter Month
        Select month = new Select(driver.findElement(_month));
        month.selectByVisibleText("February");

        // enter year
        Select year = new Select(driver.findElement(_year));
        year.selectByValue("1991");

        // enter email
        typeText(_email,"demo"+randomDate()+"@nopcommerce.com");

        // enter password
        typeText(_password,"Test123");

        // enter confirm password........
        typeText(_confirmPassword,"Test123");

        // click register
        clickOnElement(_register);

    }

}
