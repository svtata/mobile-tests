package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.RemoteConfig;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    private final RemoteConfig remoteConfig;

    public BrowserstackDriver() {
        this.remoteConfig = ConfigFactory.create(RemoteConfig.class);
    }

    @SneakyThrows
    public URL getDeviceUrl() {
        return new URL(remoteConfig.getDriverUrl());
    }

    @Override
    public WebDriver createDriver(@NotNull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", remoteConfig.getBrowserstackUser());
        mutableCapabilities.setCapability("browserstack.key", remoteConfig.getBrowserstackKey());
        mutableCapabilities.setCapability("app", remoteConfig.getApp());
        mutableCapabilities.setCapability("device", remoteConfig.getDevice());
        mutableCapabilities.setCapability("os_version", remoteConfig.getOsVersion());
        mutableCapabilities.setCapability("project", remoteConfig.getProject());
        mutableCapabilities.setCapability("build", remoteConfig.getBuild());
        mutableCapabilities.setCapability("name", remoteConfig.getName());

        return new RemoteWebDriver(getDeviceUrl(), mutableCapabilities);
    }
}
