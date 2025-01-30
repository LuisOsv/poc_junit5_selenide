package org.example.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TableSteps {

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        Configuration.headless = true;
        open(url);
    }

    @When("I look for the Memory usage of {string} in the dynamic table")
    public void i_look_for_the_memory_usage_of_in_the_dynamic_table(String browserName) {
        String memoryUsageText = $$("div[role='row']")
                .filter(Condition.text(browserName).because("Not available Browser: " + browserName))
                .first()
                .$$("span[role='cell']")
                .get(2) // Memory usage is in the fifth cell
                .shouldBe(Condition.visible.because("Memory Usage not visible for Browser: " + browserName))
                .getText();
        System.out.println("Memory Usage for " + browserName + ": " + memoryUsageText);
        assertThat(memoryUsageText, containsString("MB"));
    }

}