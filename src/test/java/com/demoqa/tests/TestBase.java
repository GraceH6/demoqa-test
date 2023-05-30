package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.TextBoxRegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();
    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}
