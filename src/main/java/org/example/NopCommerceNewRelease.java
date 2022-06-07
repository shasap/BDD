package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class NopCommerceNewRelease extends Utils {
    LoadProperty loadProperty = new LoadProperty();
    private By _commentTitle = By.cssSelector("[class=\"enter-comment-title\"]");
    private By _commentText = By.cssSelector("[class=\"enter-comment-text\"]");
    private By _addComment = By.cssSelector("[name=\"add-comment\"]");
    private By _actualNewsMessage = By.cssSelector("[class=\"result\"]");
    private By _lastCommentTitle = By.cssSelector("[class=\"comment-title\"]");
    private By _lastCommentText = By.cssSelector("[class=\"comment-text\"]");

    public void verifyCommentAddedAtLast(){

        //Expected URL
        String expetectURL = "https://demo.nopcommerce.com/nopcommerce-new-release";

        // Actual URL
        String actualURL = driver.getCurrentUrl();

        // verify URL contain new release
        Assert.assertEquals(actualURL,expetectURL,"URL not contain new release");

        // get actual title
        String actualTitle = driver.getTitle();

        // Actual title
        String expectedTitle = "nopCommerce demo store. nopCommerce new release!";

        // verify actual title with expected title
        Assert.assertEquals(actualTitle,expectedTitle,"nopCommerce new release! title is missing.");

        // enter title
        typeText(_commentTitle,loadProperty.getProperty("commentTitle"));

        // type comment text
        typeText(_commentText,loadProperty.getProperty("commentText"));

        // click add comment
        clickOnElement(_addComment);

        // expected message after clicking 'add comment'
        String expectedNewsMessage = "News comment is successfully added.";

        // actual message after clicking 'add comment'
        String actualNewsMessage = driver.findElement(_actualNewsMessage).getText();

        // verify actual and expected message
        Assert.assertEquals(actualNewsMessage,expectedNewsMessage,"News comment is not added");

        //to assert last comment title

        // find total number of comments
        List<WebElement> commentTitleList =  driver.findElements(_lastCommentTitle);

        // array size is one less than actual comment because array start with zero
        int numberOfComments = commentTitleList.size()-1;
        // print out total number of comments for confirmation
        System.out.println("Total number of comments is "+numberOfComments);

        // use for loop until last comment get printed
        for(int i=0;i<=numberOfComments;i++){
            System.out.println("value of comment title is "+commentTitleList.get(i).getText());
        }
        String actualLastCommentTitle = commentTitleList.get(numberOfComments).getText() ;

        String expectedLastCommentTitle = loadProperty.getProperty("commentTitle");
        Assert.assertEquals(actualLastCommentTitle,expectedLastCommentTitle,"Last comment title is not test");

        // To assert last test text
        List<WebElement> commentTextList =  driver.findElements(_lastCommentText);
        int totalNumberOfText = commentTextList.size()-1;
        System.out.println("Total number of text is "+totalNumberOfText);
        for(int i=0;i<=totalNumberOfText;i++){
            System.out.println("value of comment text is "+commentTextList.get(i).getText());
        }
        String actualLastCommentText = commentTextList.get(totalNumberOfText).getText() ;
        String expectedLastCommentText = loadProperty.getProperty("commentText");
        Assert.assertEquals(actualLastCommentText,expectedLastCommentText,"Last comment text is not test successful");


    }
}
