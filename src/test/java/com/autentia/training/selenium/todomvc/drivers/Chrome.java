package com.autentia.training.selenium.todomvc.drivers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.autentia.training.selenium.todomvc.config.Config.DEBUG;

public final class Chrome extends Browser {

    public Chrome() {
        System.setProperty("webdriver.chrome.driver", new DriverResourceLocator().getChromeDriverLocation());

        final ChromeOptions chromeOptions = new ChromeOptions();

        if (!DEBUG) {
            chromeOptions.addArguments("--headless");
        }

        setDriver(new ChromeDriver(chromeOptions));

        if (DEBUG) {
            this.focus();
        }
    }

    @Override
    public Browser focus() {
        ((JavascriptExecutor) getDriver()).executeScript("alert('Hi')");
        getDriver().switchTo().alert().accept();
        return this;
    }

}
