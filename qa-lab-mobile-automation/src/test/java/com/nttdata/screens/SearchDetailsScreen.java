package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchDetailsScreen extends PageObject {

    @AndroidFindBy(xpath="\t\n" +
            "//android.widget.EditText[@resource-id=\"com.airbnb.android:id/input_bar_input\"]")
    private WebElement searchDetailInput;

    @AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.airbnb.android:id/title\" and @text=\"Vichayito, Perú\"]")
    private WebElement searchInput;

    @AndroidFindBy(xpath = "\t\n" +
            "//android.widget.Button[@resource-id=\"com.airbnb.android:id/n2_simple_search_footer_link\"]")
    private WebElement buttonSkip;

    @AndroidFindBy(xpath = "\t\n" +
            "//android.widget.Button[@resource-id=\"com.airbnb.android:id/n2_dls_action_footer_gradient_button\"]")
    private WebElement buttonBuscar;


    public void time(WebElement by){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    public void enterSearchInput(String place){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(searchDetailInput));

        searchDetailInput.sendKeys(place);

        time(searchInput);
        searchInput.click();
    }
    public void skip() {
        time(buttonSkip);
        buttonSkip.click();
    }
    public void buscar() {
        time(buttonBuscar);
        buttonBuscar.click();
    }
}
