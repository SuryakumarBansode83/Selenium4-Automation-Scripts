/*
Author      - Suryakumar Bansode
Description - Use relative locators
            - below locator
*/

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        WebElement txtUserName = driver.findElement(By.name("user-name"));
        WebElement txtPassword = driver.findElement(
                with(By.tagName("input")).below(txtUserName));
        WebElement btnSubmit = driver.findElement(
                with(By.tagName("input")).below(txtPassword));
        txtUserName.sendKeys("standard_user");
        txtPassword.sendKeys("secret_sauce");
        btnSubmit.click();
        Thread.sleep(10000);
        driver.quit();
    }
}