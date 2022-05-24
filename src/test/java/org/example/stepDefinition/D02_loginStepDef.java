package org.example.stepDefinition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import org.example.pages.P02_login;
import static org.example.stepDefinition.Hooks.driver;

public class D02_loginStepDef {
    SoftAssert soft =new SoftAssert();
    P02_login login = new P02_login(driver);

    //SC2- User could log in with valid email and password
    @When("^user Enter valid data in \"(.*)\" and \"(.*)\"$")
    public  void UserCanLogin(String Email ,String Password) {
        login.LoginSteps(Email,Password);
    }

    @Then("system redirects to Home page and system display Account tab")
    public void SuccessAssertion()
    {
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/","System Redirects successfully to home page");
        Boolean Flag=login.AccountTAbLoc.isDisplayed();
        soft.assertTrue(Flag,"Account tab displayed successfully");
        soft.assertAll();
    }
}


