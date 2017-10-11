package com.autentia.training.selenium.todomvc.drivers;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.net.URL;

class DriverResourceLocator {

    private static final String CHROME_DRIVER_NAME = "chromedriver";
    private static final String MAC_SUFFIX = "mac";
    private static final String WINDOWS_SUFFIX = "win";
    private static final String LINUX_SUFFIX = "lin";

    String getChromeDriverLocation() {
        return getDriverFromResources(getPlatformDriver());
    }

    private String getPlatformDriver() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return CHROME_DRIVER_NAME + "-" + WINDOWS_SUFFIX + ".exe";
        } else if (SystemUtils.IS_OS_MAC) {
            return CHROME_DRIVER_NAME + "-" + MAC_SUFFIX;
        } else if (SystemUtils.IS_OS_LINUX) {
            return CHROME_DRIVER_NAME + "-" + LINUX_SUFFIX;
        } else {
            throw new RuntimeException("Unsupported platform");
        }
    }

    private String getDriverFromResources(String driverName) {
        final URL url = getClass().getClassLoader().getResource(driverName);

        if (url == null) {
            throw new RuntimeException("Driver not found");
        }

        return new File(url.getFile()).getAbsolutePath();
    }

}
