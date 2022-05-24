package org.example.stepDefinition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import org.example.pages.P01_register;
import java.util.Random;
import static org.example.stepDefinition.Hooks.driver;

public class D01_registerStepDef {
    P01_register register = new P01_register(driver);
    Random rand = new Random(); //instance of random class
    int upperbound = 1000;
    int int_random = rand.nextInt(upperbound);
    String Email="amany.atef@gamil.com";
    String pass= "123456";
    //SC1- User could register with valid data
    @When("user Enter valid data and click on register button")
    public void UserCanRegister()
    {
        register.NavigateToRegistrationPage();
        register.RegistrationSteps(Email,pass);
    }

    @Then("system redirects to registration confirmation page and  display success notification")
    public void ValidateConfirmationPage() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        String actualResult =register.SuccessMsgLoc.getText();
        String rgba =register.SuccessMsgLoc.getCssValue("color");
        soft.assertEquals("Your registration completed",actualResult);
        soft.assertEquals("rgba(76, 177, 124, 1)",rgba);
        soft.assertAll();
    }

}
