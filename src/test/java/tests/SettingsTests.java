package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.appium.java_client.AppiumBy.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SettingsTests extends TestBase {
    @Test
    void checkTitleInSettings() {
        back();
        step("Expand menu below", () -> {
            $(id("org.wikipedia.alpha:id/menu_icon")).click();
        });
        step("Click on \"Settings\"", () -> {
            $(id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
        });
        step("Check page title", () -> {
            $(xpath(".//*[@text='Settings']")).shouldBe(visible);
        });
    }

    @Test
    void searchLanguageInSettings() {
        back();
        step("Expand menu below", () -> {
            $(id("org.wikipedia.alpha:id/menu_icon")).click();
        });
        step("Click on \"Settings\"", () -> {
            $(id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
        });
        step("Open language settings", () -> {
            $(xpath(".//*[@text='Wikipedia languages']")).click();
        });
        step("Click on \"Add language\"", () -> {
            $(xpath(".//*[@text='ADD LANGUAGE']")).click();
        });
        step("Click on search icon", () -> {
            $(id("org.wikipedia.alpha:id/menu_search_language")).click();
        });
        step("Enter \"Deutsch\"", () -> {
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Deutsch");
        });
        step("", () -> {
            $(id("org.wikipedia.alpha:id/localized_language_name")).shouldBe(text("Deutsch"));
        });
    }
}