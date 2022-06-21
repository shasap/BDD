package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager extends Utils {
    //object of loadProperty classs so that you can read data from your testconfig file
    LoadProperty loadProperty = new LoadProperty();
    DesiredCapabilities caps = new DesiredCapabilities();

    public final String AUTOMATE_USERNAME = loadProperty.getProperty("bsUsername");
    public final String AUTOMATE_ACCESS_KEY = loadProperty.getProperty("bsAccessKey");
    public final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    //locally  run cloud= false browserStack(cloud) = true
    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));

    //boolean cloud = true;


    //Select Browser
    String browserName = "chrome";
    //String browserName = System.getProperty("browser");


    // Open Browser Method
    public void openUrlInBrowser() {
        //cloude = true then run in the cloud
        if (cloud) {
            System.out.println("running cloud");

            //applying conditional loop for different browser options

            if (browserName.equalsIgnoreCase("Chrome")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "11");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");

            }
            else if(browserName.equalsIgnoreCase("firefox")){
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "Catalina");
//                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "99.0");
//                caps.setCapability("browserstack.local", "false");
//                caps.setCapability("browserstack.selenium_version", "4.0.0");
            }
            else if (browserName.equalsIgnoreCase("edge")){
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "Monterey");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "99.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");

            }
            else {
                System.out.println("Your browser stack browser name is wrong or there is a connection issue");
            }

            try {
                driver = new RemoteWebDriver(new URL(BrowserStackURL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
            else{

                System.out.println("runnig Locally................");
                if (browserName.equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Drivers\\chromedriver_102.exe");
                    //Open Chrome
                    driver = new ChromeDriver();  // import chrome web-Driver dependency (In 'POM' file)
                } else if (browserName.equalsIgnoreCase("Firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src\\test\\java\\Drivers\\geckodriver.exe");
                    // Open Firefox
                    driver = new FirefoxDriver();
                } else if (browserName.equalsIgnoreCase("Edge")) {
                    System.setProperty("webdriver.edge.driver", "src\\test\\java\\Drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                } else {
                    System.out.println("Either your browser name is wrong or not provided : " + browserName);
                }
            }

            //Duration to be wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //if this line 'RED' ,Click on bulb and select first option

            //Maximize the screen
            driver.manage().window().maximize();

            //Open Web page
            driver.get("https://demo.nopcommerce.com/");

        }


    // Close Browser Method

    public void closeBrowser() {

        // Close browser
        driver.quit();

    }
}


