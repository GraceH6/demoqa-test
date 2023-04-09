package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1860x1040";
        executeJavaScript("$('footer').remove()");
    }
}
