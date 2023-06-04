package com.demoqa.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationComponent {

    SelenideElement
            table = $(".table-responsive"),
            greeting = $("#example-modal-sizes-title-lg");

    public void verifyGreeting() {
        greeting.shouldBe(Condition.visible).shouldHave(text("Thanks for submitting the form"));
    }
    public void verifyResult(String key, String value) {
        table.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
