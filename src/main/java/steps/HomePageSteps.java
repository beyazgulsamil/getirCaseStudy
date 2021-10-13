package steps;

import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Then("I choose getir type {}")
    public void typeChoose(String type){homePage.clickGetirType(type);}

    @Then("I click Giriş Yap")
    public void logInStep(){homePage.logIn.click();}
}
