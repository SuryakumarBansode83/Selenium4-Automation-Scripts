/*
Author      - Suryakumar Bansode
Description - Execute your test case as you are in different location
            - You can simulate different geolocations while testing by using
              CDP (Chrome Dev Protocols). This allows you to set latitude,
              longitude and accuracy to mimic real world locations.
 */
package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class HandleGeoLocation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        Start Dev Tools session
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
//        Set geolocation (Example: New York City, USA)
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(40.7128),  // Latitude
                Optional.of(-74.0060), // Longitude
                Optional.of(100)       // Accuracy in meters
        ));
//        Open a website to check location-based contents
        driver.get("https://where-am-i.org/");
        Thread.sleep(3000);
//        Click on Consent
        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement btnConsent = driver.findElement(By.xpath("(//*[contains(text(),'Consent')])[1]"));
            jse.executeScript("arguments[0].click();", btnConsent);
            jse.executeScript("window.scrollBy(0,250)","");
        } catch (Exception e) {
            System.out.println("Consent page not found, continuing.." + e.getMessage());
        }
//        Print page title to confirm navigation
        System.out.println("Page Title: " + driver.getTitle());
        Thread.sleep(5000);
//        Close the browser
        driver.quit();
    }
}
