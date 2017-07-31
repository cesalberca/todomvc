package com.autentia.training.selenium.todomvc.drivers;

import java.io.File;
import java.net.URL;

class DriverResourceLocator {

    private static final String CHROME_DRIVER_NAME = "chromedriver";
    private static final String FIREFOX_DRIVER_NAME = "geckodriver";

    String getChromeDriverLocation() {
        return getDriverFromResources(CHROME_DRIVER_NAME);
    }

    String getFirefoxDriverLocation() {
        return getDriverFromResources(FIREFOX_DRIVER_NAME);
    }

    private String getDriverFromResources(String driverName) {
        final URL url = getClass().getClassLoader().getResource(driverName);

        if (url == null) {
            throw new RuntimeException("Driver not found");
        }

        return new File(url.getFile()).getAbsolutePath();
    }

}
