package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.MobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    private static boolean videoEnabled = false;

    @BeforeAll
    static void beforeAll() {
        String property = System.getProperty("env", "local");
        if (property.equals("remote")) {
            Configuration.browser = BrowserstackDriver.class.getName();
            videoEnabled = true;
        } else if (property.equals("local")) {
            Configuration.browser = MobileDriver.class.getName();
        } else {
            throw new RuntimeException("Illegal env variable");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
        if (videoEnabled) {
            Attach.addVideo(sessionId);
        }
    }
}
