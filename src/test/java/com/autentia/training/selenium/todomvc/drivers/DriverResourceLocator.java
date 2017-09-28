package com.autentia.training.selenium.todomvc.drivers;

import java.io.File;
import java.net.URL;

class DriverResourceLocator {

    private static final String CHROME_DRIVER_NAME = "chromedriver";

    String getChromeDriverLocation() {
        return getDriverFromResources(CHROME_DRIVER_NAME);
    }

    private String getDriverFromResources(String driverName) {
        final URL url = getClass().getClassLoader().getResource(driverName);

        if (url == null) {
            throw new RuntimeException("Driver not found");
        }

        return new File(url.getFile()).getAbsolutePath();
    }

}
