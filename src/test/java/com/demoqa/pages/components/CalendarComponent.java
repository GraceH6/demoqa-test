package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        String dayPickerLocator = String.format(".react-datepicker__day--0" + day);
        $(dayPickerLocator).click();
    }
}
