package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){


        $("[class*='month-select']").selectOptionByValue(month);
        $("[class*='year-select']").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day).click();
    }
}
