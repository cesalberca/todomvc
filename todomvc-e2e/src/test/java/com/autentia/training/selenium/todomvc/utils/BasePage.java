package com.autentia.training.selenium.todomvc.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.autentia.training.selenium.todomvc.utils.Config.BASE_URL;

public class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void visit(String url) {
        if (url.startsWith("http")) {
            driver.get(url);
        } else {
            driver.get(BASE_URL + url);
        }
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

}
