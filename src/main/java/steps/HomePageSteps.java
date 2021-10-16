package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.HomePage;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Then("Verify Click Element {}")
    public void verifyElement(String input){homePage.clickElement(homePage.example.findElement(By.partialLinkText(input)));}

    @Then("I choose getir type {}")
    public void typeChoose(String type){homePage.clickGetirType(type);}

    @Then("I click Giriş Yap")
    public void logInStep(){homePage.clickElement(homePage.logIn);}

    @Then("I Click Kayıt Ol")
    public void signInStep(){homePage.clickElement(homePage.signUp);}

    @Then("I Log in to country area code {}")
    public void area(String areaCode){
        homePage.clickElement(homePage.flagLog);
        homePage.loopAndClick(homePage.countrys,areaCode);}

    @Then("I enter number {}")
    public void enterNumber(String number){homePage.fillInput(homePage.numberArea,number);}

    @Then("I enter Name and Surname {}")
    public void enterName(String name){homePage.fillInput(homePage.nameArea,name);}

    @Then("I enter mail {}")
    public void enterMail(String name){homePage.fillInput(homePage.mailArea,name);}

    @Then("I enter password {}")
    public void enterPassword(String name){homePage.fillInput(homePage.passwordArea,name);}

    @Then("I check user text")
    public void checckText(){homePage.clickElement(homePage.checkOfferText);}

    @Then("I read user text")
    public void readText(){homePage.clickElement(homePage.userText);}

    @Then("I sign up to country area code {}")
    public void areaSign(String areaCode){
        homePage.clickElement(homePage.flagSign);
        homePage.country(areaCode);}

    @Then("I select to product type {}")
    public void productTypeSelect(String typeName){homePage.loopAndClick(homePage.productTypeList,typeName);}

    @Then("Select to product {}")
    public void productSelect(String productName){homePage.loopAndClick(homePage.productList,productName);}

    @Then("I click to getir")
    public void clickGetir(){homePage.clickElement(homePage.getir);}

    @Then("I click to getirYemek")
    public void clickGetirYemek(){homePage.clickElement(homePage.getirYemek);}

    @Then("I click to getirBüyük")
    public void clickGetirBuyuk(){homePage.clickElement(homePage.getirBuyuk);}

    @Then("I click to getirSu")
    public void clickGetirSu(){homePage.clickElement(homePage.getirSu);}

    @Then("This product add to box")
    public void clickAddBox(){homePage.clickElement(homePage.addBox);}

    @Then("Food type menu to {} slide")
    public void slideFood(String direction){homePage.slide(direction);}

    @Then("I select food type {}")
    public void selectFoodType(String foodType){homePage.loopAndClick(homePage.foodTypeList,foodType);}


}
