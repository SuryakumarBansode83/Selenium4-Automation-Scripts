/*
Author      - Suryakumar Bansode
Description - Take full page screenshot
            - Take screenshot of specific element
            - Take screenshot of specific portion like header, footer
*/

package org.example;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class FullPageScreenshot {
    public static void main(String[] args) throws IOException, InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/");
        WebElement txtUserName = driver.findElement(By.name("user-name"));
        WebElement txtPassword = driver.findElement(
                with(By.tagName("input")).below(txtUserName));
        WebElement loginBox = driver.findElement(By.className("login-box"));
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
//  Take the screenshot of the specific element
        File elementOnly = txtUserName.getScreenshotAs(OutputType.FILE);
//  Take the screenshot of section on page like header, footer etc
        File loginSection = loginBox.getScreenshotAs(OutputType.FILE);
//  Take full page screenshot from top to bottom.
//  Note: Full page screenshot works only with Firefox.
        File fullScreenShot = driver.getFullPageScreenshotAs(OutputType.FILE);
//  Save the screenshot to a file
        FileUtils.copyFile(elementOnly, new File("Element_screenshot.png"));
        FileUtils.copyFile(loginSection, new File("Section_screenshot.png"));
        FileUtils.copyFile(fullScreenShot, new File("FullPage_screenshot.png"));
        driver.quit();
    }
}