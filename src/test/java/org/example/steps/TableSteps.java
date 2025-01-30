package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
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

        List<String> columnHeaders = $$("div[role='row'] span[role='columnheader']")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .shouldHave(CollectionCondition.itemWithText("Memory")
                        .because("Memory column not found"))
                .texts();

        int index = IntStream.range(0, columnHeaders.size())
                .filter(i -> columnHeaders.get(i).equals("Memory"))
                .findFirst()
                .orElse(-1);

        String memoryUsageText = $$("span[role='cell']")
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .find(Condition.text(browserName).because("Browser not found"))
                .closest("div")
                .find("span[role='cell']", index)
                .text();

        assertThat(memoryUsageText, containsString("MB"));
    }

}