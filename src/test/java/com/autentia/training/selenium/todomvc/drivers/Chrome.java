package com.autentia.training.selenium.todomvc.drivers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class Chrome extends Browser {

    public Chrome() {
        System.setProperty("webdriver.chrome.driver", new DriverResourceLocator().getChromeDriverLocation());
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        setDriver(new ChromeDriver(chromeOptions));
    }

    @Override
    public Browser focus() {
        ((JavascriptExecutor) getDriver()).executeScript("alert('Hi')");
        getDriver().switchTo().alert().accept();
        return this;
    }

}
