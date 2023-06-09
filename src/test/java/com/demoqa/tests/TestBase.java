package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextBoxRegistrationPage;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("baseUrl");
        String[] browserAndItsVersion = System.getProperty("browser").split(":");
        Configuration.browser = browserAndItsVersion[0];
        Configuration.browserVersion = browserAndItsVersion[1];
        Configuration.browserSize = System.getProperty("browserSize");
        String selenoidUrl = System.getProperty("selenoidUrl");
        String selenoidLogin = System.getProperty("selenoidLogin");
        String selenoidPass = System.getProperty("selenoidPass");
        Configuration.remote = String.format("https://%s:%s@%s", selenoidLogin, selenoidPass, selenoidUrl);
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
