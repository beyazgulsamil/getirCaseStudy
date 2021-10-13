package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import utils.Utilities;
import java.util.List;

public class HomePage extends Utilities {
    private RemoteWebDriver driver;

    @FindBy(css = "[d=\"M24 8.846c0 4.39-3.582 7.948-8 7.948s-8-3.559-8-7.948c0-4.39 3.582-7.948 8-7.948s8 3.558 8 7.948z M0.027 28.896c-0.207 1.16 0.83 2.206 2.116 2.206h27.713c1.327 0 2.324-1.048 2.116-2.206-1.204-6.696-7.884-10.511-15.974-10.511s-14.77 3.815-15.972 10.511h-0z\"]")
    public WebElement logIn;

    @FindBy(css = "[kind=\"transparent\"]")
    public List<WebElement> getirTypes;

    public void clickGetirType(String type){
        for (WebElement typeCard: getirTypes) {
            if (typeCard.getText().contains(type)){
                typeCard.click();
                return;
            }

        }

    }
}