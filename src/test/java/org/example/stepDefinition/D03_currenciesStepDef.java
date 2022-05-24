package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.example.pages.P03_homePage;

import static org.example.stepDefinition.Hooks.driver;

public class D03_currenciesStepDef {
    //SC5- Logged User could switch between currencies US-Euro
    P03_homePage home= new P03_homePage(driver);
    @When("Select currency")
    public void UserSelectCurrency(){
        home.ChangeCurrency();
    }
    @Then("")
    public void Validate_Change_price_currency(){Assert.assertTrue(home.CheckChangeCurrency());}


}
