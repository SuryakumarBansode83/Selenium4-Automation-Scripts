/*
Author      - Suryakumar Bansode
Description - To interact with the Network Tab in Chrome using Selenium 4 (Java),
              you need to use the DevTools Protocol. Selenium 4 allows us to interact
              with browser internals such as network requests,
              performance metrics, and more.
            - Capture Network Traffic - CDP allows you to monitor network traffic,
              intercept requests, and manipulate responses.
*/

package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;

import java.util.Optional;

public class GetNetworkRequests {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Create a DevTools session
        DevTools devTools = ((ChromeDriver) driver).getDevTools();

        // Start a session with DevTools
        devTools.createSession();

        // Enable the network domain with parameters
        devTools.send(Network.enable(Optional.of(100000), Optional.of(100000), Optional.of(100000))); // Parameters for buffer sizes

        // Listener for network requests
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request URL: " + request.getRequest().getUrl());
        });

        // Listener for network responses
        devTools.addListener(Network.responseReceived(), response -> {
            System.out.println("Response URL: " + response.getResponse().getUrl());
            System.out.println("Response Status Code: " + response.getResponse().getStatus());
        });

        // Navigate to a website
        driver.get("https://www.youtube.com");

        // Wait for a few seconds to capture network traffic
        try {
            Thread.sleep(5000); // Sleep to ensure the network traffic is captured
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
