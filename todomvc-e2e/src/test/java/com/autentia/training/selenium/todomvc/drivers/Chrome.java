package com.autentia.training.selenium.todomvc.drivers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Chrome extends Browser {

    public Chrome() {
        System.setProperty("webdriver.chrome.driver", new DriverResourceLocator().getChromeDriverLocation());
        setDriver(new ChromeDriver());
    }

    @Override
    public Browser focus() {
        ((JavascriptExecutor) getDriver()).executeScript("alert('Hi')");
        getDriver().switchTo().alert().accept();
        return this;
    }

}
