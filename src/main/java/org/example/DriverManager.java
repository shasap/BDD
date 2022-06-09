package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils{
    //Select Browser
    String browserName = "firefox";

    // Open Browser Method
    public void openUrlInBrowser(){
        if (browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Drivers\\chromedriver_102.exe");
            //Open Chrome
            driver = new ChromeDriver();  // import chrome web-Driver dependency (In 'POM' file)
        } else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","src\\test\\java\\Drivers\\geckodriver.exe");
            // Open Firefox
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver","src\\test\\java\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else{
            System.out.println("Either your browser name is wrong or not provided : "+browserName);
        }


        //Duration to be wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //if this line 'RED' ,Click on bulb and select first option

        //Maximize the screen
        driver.manage().window().maximize();

        //Open Web page
        driver.get("https://demo.nopcommerce.com/");

    }


    // Close Browser Method

    public void closeBrowser(){

        // Close browser
        driver.quit();

    }

}
