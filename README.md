## Author
- **Suryakumar Bansode**
- GitHub: https://github.com/SuryakumarBansode83
- Email: e_surya_in@yahoo.com

## License
This project is licensed under the **MIT License** – see the LICENSE file for details.

## Disclaimer
Unauthorized copying, distribution, or use of this code without proper attribution is prohibited.

# Selenium 4 Automation Scripts

This repository contains a collection of automation scripts using **Selenium 4** for web testing and browser automation. These scripts are designed to work with various browsers like Chrome, Firefox, and Edge.

## Features:

- **Handle multiple tabs**
  - Selenium 4 provides enhanced window/tab handling with the newWindow() method, making it easier to manage multiple tabs. You can open, switch, close, and navigate between multiple tabs or windows efficiently.
  - Selenium 4 introduces driver.switchTo().newWindow(WindowType.TAB) to open a new tab directly.
    ```bash
    driver.switchTo().newWindow(WindowType.TAB); → Opens a new tab.
    driver.getWindowHandle(); → Gets the handle of the current tab.
    driver.switchTo().window(handle); → Switches between tabs.
  - You can also open a new separate window instead of a tab.
    ```bash
      WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
      newWindow.get("https://www.google.com");
    
- **GeoLocation scripts**
  - Selenium 4 introduces Chrome DevTools Protocol (CDP), which allows us to mock geolocation data. This is useful for testing location-based features such as geo-restricted content, maps, and localized searches.
  - Selenium 4 allows setting latitude, longitude, and accuracy using the Emulation.setGeolocationOverride method.
  - This will reset the browser to use the real device location.
    ```bash
        devTools.send(Emulation.clearGeolocationOverride());
  - City	    Latitude	Longitude
    New York	40.7128	    -74.0060
    London	    51.5074	     -0.1278
    Tokyo	    35.6895	    139.6917
    Sydney	   -33.8688	    151.2093

- **Network tab handling in selenium**
  - Selenium 4 introduced Chrome DevTools Protocol (CDP) support, which allows us to interact with the browser's Network Tab directly. This is useful for monitoring network requests, capturing responses, modifying requests, and handling authentication.
  - Using Selenium 4 with CDP, you can:
    - Capture network requests & responses (e.g., API calls, resource loads). 
    - Block specific network requests (e.g., block ads, images). 
    - Simulate different network conditions (e.g., slow 3G, offline mode). 
    - Monitor console logs & performance data. 
    - Intercept and modify requests (e.g., change headers, authentication tokens). 
    - Capture request timings & analyze response codes.
    
- **Relative locators**
  - Selenium 4 introduced Relative Locators (formerly known as Friendly Locators) to find web elements based on their position relative to other elements. This makes it easier to locate elements dynamically without relying on complex XPath or CSS selectors.
    ```bash
    The RelativeLocator.withTagName() method helps locate elements that are above, below, to the left, to the right, or near another element.
  - Method	             Description
    above(element)	     Finds an element located above the given element.
    below(element)	     Finds an element located below the given element.
    toLeftOf(element)	   Finds an element to the left of the given element.
    toRightOf(element)	 Finds an element to the right of the given element.
    near(element)	     Finds an element near the given element (default distance: 50px).
  - When elements don't have unique locators (like id or class). 
  - When elements are dynamically generated, making it hard to use fixed locators. 
  - When improving readability and maintainability of test scripts.

- **Full page screenshot, specific element screenshot and Specific portion screenshot**
  - Selenium 4 provides better support for full-page screenshots, element-specific screenshots, and cropped screenshots of a specific portion. Let's explore all these features step by step.
  - Selenium 4 introduced full-page screenshot support for browsers like Firefox. getFullPageScreenshotAs(OutputType.FILE) only works in Firefox.
  - Selenium 4 allows capturing a specific web element instead of the entire page. The .getScreenshotAs(OutputType.FILE) method captures only the specified element.
  - If you want to take a screenshot of a specific area (not just an element).
  - Selenium 4 makes taking screenshots more flexible and powerful. Whether you need a full-page screenshot, an element screenshot, or a specific cropped portion, Selenium 4 provides built-in methods to make it easy.

## Getting Started:

1. Clone this repository:
   ```bash
   https://github.com/SuryakumarBansode83/Selenium4-Automation-Scripts.git
