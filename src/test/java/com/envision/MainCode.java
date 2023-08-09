package com.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainCode extends BaseCode {

    public String loginURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeTest
    public void launchBrowser() {
        openBrowser("chrome");
        openURL("https://opensource-demo.orangehrmlive.com/");
    }

    //1. Valid/Positive Scenario
    @Test
    public void validLogin() throws InterruptedException {
        Thread.sleep(3000);
        WebElement uName = driver.findElement(By.name("username"));
        uName.sendKeys("Admin");        //Enter username

        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys("admin123");       //Enter password

        WebElement clickLogin = driver.findElement(By.xpath("//button[text()=' Login ']"));
        clickLogin.click();                         //Click on Login button

        Thread.sleep(3000);

        WebElement myInfo = driver.findElement(By.xpath("//span[text()='My Info']"));
        myInfo.click();

        Thread.sleep(3000);



        System.out.println("User landed on the following page " + driver.getCurrentUrl());
        System.out.println("Title of the Page is : " + driver.getTitle());
        Assert.assertFalse(driver.getCurrentUrl().equals(loginURL), "login failed");


    }


    //2. Invalid Login Scenario
    @Test
    public void invalidLogin() throws InterruptedException {
        Thread.sleep(3000);

        WebElement uName1 = driver.findElement(By.name("username"));
        uName1.sendKeys("test");        //Enter invalid username

        WebElement pwd1 = driver.findElement(By.name("password"));
        pwd1.sendKeys("test123");       //Enter invalid password

        WebElement clickLogin1 = driver.findElement(By.xpath("//button[text()=' Login ']"));
        clickLogin1.click();                        //Click on login button

        System.out.println("User landed on the following page " + driver.getCurrentUrl());

        Thread.sleep(3000);

        WebElement checkUserField = driver.findElement(By.xpath("//input[@name='username']"));
        Assert.assertFalse(checkUserField.isDisplayed(), "User is still on the login page");

        //StaleElementReferenceException
//        Assert.assertFalse(uName1.isDisplayed(), "User is still on the login page");

        WebElement error = driver.findElement(By.xpath("//p[text()= 'Invalid credentials']"));
        Assert.assertFalse(error.isDisplayed(), "Login failed");



    }

//    @AfterTest
//    public void quitBrowser() {
//        closeBrowser();
//    }


}
