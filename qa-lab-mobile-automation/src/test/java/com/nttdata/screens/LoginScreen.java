package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginScreen extends PageObject {

    //@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Cerrar\"]")
    //private WebElement btnClose;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement btnClose;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    private WebElement btnPermisos;
    public void clickClose(){
        WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
        WebElement allowButton = wait1.until(ExpectedConditions.elementToBeClickable(btnPermisos));
        try{
            allowButton.click();
        }catch (NoSuchElementException | TimeoutException e){
            System.out.println("No hay permisos");
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 4);
        wait.until(ExpectedConditions.elementToBeClickable(btnClose));
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        btnClose.click();
    }

}
