package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public abstract class Utilities extends Driver {

    public Utilities(){PageFactory.initElements(driver, this);}

    public void clickElement(WebElement element){waitUntilClickable(centerElement(element),System.currentTimeMillis()).click();}

    public void fillInput(WebElement inputBox, String inputText){
        centerElement(waitUntilVisible(inputBox,System.currentTimeMillis())).sendKeys(inputText);}

    public String getElementAttribute(WebElement element,String attributeName){
        return element.getAttribute(attributeName);}

    public WebElement centerElement(WebElement element){
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor)driver).executeScript(scrollElementIntoMiddle, element);
        return element;
    }

    public WebElement waitUntilVisible(WebElement element, long initialTime){
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        if (System.currentTimeMillis()-initialTime>15000){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return null;
        }
        try {
            if (!element.isDisplayed()){waitUntilVisible(element, initialTime);}
        }
        catch (StaleElementReferenceException|NoSuchElementException|TimeoutException exception){
            waitUntilVisible(element, initialTime);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return element;
    }

    public WebElement waitUntilClickable(WebElement element, long initialTime){
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        if (System.currentTimeMillis()-initialTime>15000){
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return null;
        }
        try {
            if (!element.isEnabled()){waitUntilClickable(element, initialTime);}
        }
        catch (StaleElementReferenceException|NoSuchElementException|TimeoutException exception){
            waitUntilClickable(element, initialTime);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return element;
    }

    public void click(WebElement element){
        element.click();
    }

}