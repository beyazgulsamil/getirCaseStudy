package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import steps.Common;
import utils.Utilities;
import java.util.List;

public class HomePage extends Utilities {
    private RemoteWebDriver driver;
    Common common = new Common();


    @FindBy(css = "[d=\"M24 8.846c0 4.39-3.582 7.948-8 7.948s-8-3.559-8-7.948c0-4.39 3.582-7.948 8-7.948s8 3.558 8 7.948z M0.027 28.896c-0.207 1.16 0.83 2.206 2.116 2.206h27.713c1.327 0 2.324-1.048 2.116-2.206-1.204-6.696-7.884-10.511-15.974-10.511s-14.77 3.815-15.972 10.511h-0z\"]")
    public WebElement logIn;

    @FindBy(css = "[class=\"style__Wrapper-sc-__sc-6ivys6-1 bPrEfU\"] [name=\"user-add\"]")
    public WebElement signUp;

    @FindBy(css = "[data-testid=\"link\"]")
    public List<WebElement> getirTypes;

    @FindBy(css = "[kind=\"transparent\"]")
    public List<WebElement> productTypeList;

    @FindBy(css = "[class=\"style__ProductCard-sc-__sc-mw3qf6-0 jppGuH\"]")
    public List<WebElement> productList;

    @FindBy(css = "[alt=\"GetirSu\"]")
    public WebElement getirSu;

    @FindBy(css = "[alt=\"GetirYemek\"]")
    public WebElement getirYemek;

    @FindBy(css = "[alt=\"GetirBüyük\"]")
    public WebElement getirBuyuk;

    @FindBy(css = "[alt=\"Getir\"]")
    public WebElement getir;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]/div[2]/form/div[1]/div/div[1]/div/div[2]")
    public WebElement flagLog;

    @FindBy(xpath = "/html/body/div[11]/div[2]/div/div[2]/div[2]/form/div[1]/div[1]/div[1]/div/div[2]/div")
    public WebElement flagSign;

    @FindBy(css = "[class=\"country\"]")
    public List<WebElement> countrys;

    @FindBy(css = "[class=\"style__PhoneInputContainer-sc-__sc-1kfx5k6-11 fTZlXa\"] [placeholder=\"Telefon Numarası\"]")
    public WebElement numberArea;

    @FindBy(css = "[placeholder=\"Ad Soyad\"]")
    public WebElement nameArea;

    @FindBy(css = "[placeholder=\"E-Posta\"]")
    public WebElement mailArea;

    @FindBy(css = "[placeholder=\"Şifre\"]")
    public WebElement passwordArea;

    @FindBy(css = "[data-testid=\"checkbox\"]")
    public WebElement checkOfferText;

    @FindBy(css = "[class=\"style__Link-sc-__sc-1gkqffg-0 bkMJgu style__Link-sc-__sc-m9xm1p-0 gfCVCv\"]")
    public WebElement userText;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div[3]/div[2]/button")
    public WebElement addBox;

    @FindBy(css = "[name=\"chevron-right\"]")
    public WebElement foodRightSlide;

    @FindBy(css = "[name=\"chevron-left\"]")
    public WebElement foodLeftSlide;

    @FindBy(css = "[class=\"slick-list\"] [class=\"slick-slide slick-active\"]")
    public List<WebElement> foodTypeList;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/section/div/section[2]/div/div[2]/div/div/div[23]/div/div/span")
    public WebElement example;

    public void pressButtonWithText(String buttonText) {
        String locator = "//*[contains(text(), '" + buttonText + "')]";
        System.out.println(locator);
        click(driver.findElement(By.xpath(locator)));
    }

    public void slide(String direction){
        switch (direction.toLowerCase()){
            case "right":
                common.waitFor(1);
                clickElement(foodRightSlide);
                common.waitFor(1);
                break;

            case "left":
                common.waitFor(1);
                clickElement(foodLeftSlide);
                common.waitFor(1);
                break;

            default:
                System.out.println("Wrong Way!!!");
        }
    }
    public void loopAndClick(List<WebElement> list,String buttonName){
        for (WebElement item:list) {
            if (item.getText().contains(buttonName)){
                clickElement(item);
                return;
            }
        }
        Assert.fail("No such element was found...");
    }
   
    public void advancedLoopAndClick(List<WebElement> list,String attributeValue,String attributeType){
        for (WebElement item:list) {
            if (item.getAttribute(attributeType).contains(attributeValue)){
                clickElement(item);
                return;
            }
        }
        Assert.fail("No such element was found...");
    }

    public void country(String areaCode){
        for (WebElement selectCode:countrys) {
            if (selectCode.getText().contains(areaCode)){
                selectCode.click();
                return;
            }
        }
    }

    public void loopProductType(String productType){
        for (WebElement productTypeSelect:productTypeList) {
            if (productTypeSelect.getText().contains(productType)){
                productTypeSelect.click();
                return;
            }
        }
    }

    public void loopProduct(String productName){
        for (WebElement productSelect:productList) {
            if (productSelect.getText().contains(productName)){
                productSelect.click();
                return;
            }
        }
    }

    public void loopFoodType(String foodType){
        for (WebElement foodSelect:foodTypeList){
            if (foodSelect.getText().contains(foodType)){
                clickElement(foodSelect);
                return;
            }
        }
    }

    public void clickGetirType(String type){
        for (WebElement typeCard: getirTypes) {
            if (typeCard.getText().contains(type)){
                typeCard.click();
                return;
            }
        }
    }
}
