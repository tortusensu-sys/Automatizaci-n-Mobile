package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;
import com.nttdata.screens.SearchDetailsScreen;
import com.nttdata.screens.SearchScreen;
import net.thucydides.core.annotations.Step;

public class AirbnbSearchSteps {

    LoginScreen loginScreen;
    SearchScreen searchScreen;
    SearchDetailsScreen searchDetailsScreen;

    @Step("Click en cerrar")
    public void clickClose(){
        loginScreen.clickClose();
    }

    @Step("Búsqueda por texto {0}")
    public void searchByText(String place){

        searchScreen.clickSearchInput();
        searchDetailsScreen.enterSearchInput(place);
    }
    public void butoonSkip() {
        searchDetailsScreen.skip();
    }
    public void butoonBuscar() {
        searchDetailsScreen.buscar();
    }
    @Step("Obtiene el texto del resultado")
    public void  getResultText(String text){
         searchScreen.getResultText(text);
    }
    public void searchItem() {
        searchScreen.searchItem();
    }
}
