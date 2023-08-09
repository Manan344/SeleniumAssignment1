package com.envision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//Base code with methods to launch browser, navigate to URL and quit browser
public class BaseCode {
    public WebDriver driver;

    public void openBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "driverexecutables/chromedriver.exe");
            driver = new ChromeDriver();        //Launch chrome browser
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "driverexecutables/msedgedriver.exe");
            driver = new EdgeDriver();          //Launch edge browser
        }

        driver.manage().window().maximize();    //Maximize the window

    }

    public void openURL(String url) {            //method to open URL
        driver.navigate().to(url);
    }

    public void closeBrowser() {                 //method to close current browser window
        driver.close();
    }

    public void closeAllWindows() {              //method to close all tabs/windows
        driver.quit();
    }


}
