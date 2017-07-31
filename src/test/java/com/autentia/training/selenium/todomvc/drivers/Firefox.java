package com.autentia.training.selenium.todomvc.drivers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Firefox extends Browser {

    public Firefox() {
        System.setProperty("webdriver.gecko.driver", new DriverResourceLocator().getFirefoxDriverLocation());
        setDriver(new FirefoxDriver());
    }

    @Override
    public Browser focus() {
        // window.maximize() throws an error  which won't be fixed until FF55 https://github.com/mozilla/geckodriver/issues/820
        getDriver().manage().window().setSize(new Dimension(1920, 1080));
        return this;
    }

}
