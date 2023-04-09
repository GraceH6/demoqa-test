package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextboxTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/text-box");
        $("#userName").setValue("Abay");
        $("#userEmail").setValue("abay@kunanbayev.com");
        $("#currentAddress").setValue("Semey");
        $("#permanentAddress").setValue("anotherWorld");
        $("#submit").click();

        $("#output").shouldHave(text("Abay"), text("abay@kunanbayev.com"),
                text("Semey"), text("anotherWorld"));
    }

}
