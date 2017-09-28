package com.autentia.training.selenium.todomvc.utils;

import com.autentia.training.selenium.todomvc.config.Config;
import com.autentia.training.selenium.todomvc.drivers.Browser;
import com.autentia.training.selenium.todomvc.drivers.Chrome;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static com.autentia.training.selenium.todomvc.config.Config.DEBUG;
import static com.autentia.training.selenium.todomvc.config.Config.ENV;

public class WebDriverParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return Objects.equals(parameterContext.getParameter().getType(), WebDriver.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        if ("prod".equals(ENV)) {
            try {
                final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                return new RemoteWebDriver(new URL(Config.HUB_URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        final Browser browser = DEBUG ? new Chrome().focus() : new Chrome();
        return browser.getDriver();
    }

}
