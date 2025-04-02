package org.example.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;

public class StoreSteps {

    public static String productName;

    @When("I add one product to shopping cart")
    public void iAddOneProductToShoppingCart() {
        SelenideElement randomProduct = $$("h4.card-title")
                .shouldHave(CollectionCondition.sizeGreaterThan(0)
                        .because("Product list is empty"))
                .first();
        productName = randomProduct.getText();
        randomProduct.click();

        $("a[onclick*='addToCart']")
                .shouldBe(Condition.visible.because("Add to cart button is not visible"))
                .click();
        switchTo().alert().accept();
    }


    @And("I go to shopping cart page")
    public void iGoToShoppingCartPage() {
        $("a#cartur")
                .shouldBe(Condition.clickable.because("Shopping cart button is not visible"))
                .click();

        $$("tr.success td:nth-child(2)")
                .shouldHave(CollectionCondition.sizeGreaterThan(0)
                        .because("Shopping cart is empty"))
                .shouldHave(CollectionCondition.itemWithText(productName)
                        .because("Product is not in the shopping cart"));
    }
}
