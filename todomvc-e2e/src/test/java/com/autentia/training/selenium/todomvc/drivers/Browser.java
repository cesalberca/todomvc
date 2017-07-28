package com.autentia.training.selenium.todomvc.drivers;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    abstract Browser focus();

}
