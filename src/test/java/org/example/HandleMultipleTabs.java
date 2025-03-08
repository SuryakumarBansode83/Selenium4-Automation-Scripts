/*
Author      - Suryakumar Bansode
Description - Handle multiple tabs
*/

package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleTabs {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//        Open the website - first tab
        driver.get("https://www.saucedemo.com/v1/");
        System.out.println("First tab title: " + driver.getTitle());
//        Open new tab
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://www.selenium.dev/");
        System.out.println("New Tab Title: " + newTab.getTitle());
//        Switch back to first tab
//        getWindowHandles - Gets all open tabs/windows
        String originalTab = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(originalTab);
        System.out.println("User switched back to: " + driver.getTitle());
//        Close the browser
        driver.quit();
    }
}
