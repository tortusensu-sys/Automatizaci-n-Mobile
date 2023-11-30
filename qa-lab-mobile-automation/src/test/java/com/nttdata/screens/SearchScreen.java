package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class SearchScreen extends PageObject {
    @AndroidFindBy(id = "//android.widget.ScrollView/android.view.View[3]/android.widget.Button")
    private WebElement buttonClose;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Explora destinos\"]")
    private WebElement searchInput;
    @AndroidFindBy(xpath = "\t\n" +
            "//android.widget.ImageView[@resource-id=\"com.airbnb.android:id/start_button\"]")
    private WebElement fromInput;
    @AndroidFindBy(id = "com.airbnb.android:id/n2_bottom_sheet_title_title")
    private WebElement resultText;

    public void time(WebElement by){
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
    public void clickSearchInput(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
        try {
            buttonClose.click();
        }catch (Exception e){
            System.out.println("error: "+ e.getMessage());
        }
        fromInput.click();

        time(searchInput);
        searchInput.click();
    }

    public void getResultText(String expectedText) {
        time(resultText);

        String actualText = resultText.getText().replaceAll("\u00A0", "").replaceAll("\\s", "").trim();
        String expectedTextWithoutNBSP = expectedText.replaceAll("\u00A0", "").replaceAll("\\s", "").trim();
    
        Assert.assertEquals(actualText, expectedTextWithoutNBSP);
    }
    public void searchItem() {
        time(resultText);
        String actualText = resultText.getText();
        int numeroDeHospedaje = Integer.parseInt(actualText.replaceAll("[^0-9]", ""));

        if(numeroDeHospedaje > 1){
            System.out.println("Validación correcto.");
        }else{
            Assert.fail("Hay 1 o 0 hoteles para este destino");
        }
    }
}
