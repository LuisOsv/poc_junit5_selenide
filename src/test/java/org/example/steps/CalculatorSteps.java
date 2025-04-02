package org.example.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalculatorSteps {
    @When("I sum {int} and {int}")
    public void iAddAnd(Integer firstNumber, Integer secondNumber) {

        $x("//button[@id=" + firstNumber + "]")
                .shouldBe(visible)
                .click();

        $("button#add")
                .click();


        $x("//button[@id=" + secondNumber + "]")
                .shouldBe(visible)
                .click();

        $("button#equal")
                .click();
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(Integer expectedResult) {
        $("input#output")
                .shouldHave(visible)
                .shouldHave(Condition.attribute("value",String.valueOf(expectedResult)));
    }

    @When("I multiply {int} and {int}")
    public void iMultiplyAnd(int firstNumber, int secondNumber) {
        $x("//button[@id=" + firstNumber + "]")
                .shouldBe(visible)
                .click();

        $("button#multiply")
                .click();

        $x("//button[@id=" + secondNumber + "]")
                .shouldBe(visible)
                .click();

        $("button#equal")
                .click();

    }
}
