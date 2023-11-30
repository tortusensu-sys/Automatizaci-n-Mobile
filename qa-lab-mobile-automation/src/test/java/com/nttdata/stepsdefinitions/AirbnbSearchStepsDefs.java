package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AirbnbSearchSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.io.File;

public class AirbnbSearchStepsDefs {

    @Steps
    AirbnbSearchSteps airbnbSearchSteps;

    @Given("que me enuentro en el login de Airbnb")
    public void que_me_enuentro_en_el_login_de_airbnb() {
        airbnbSearchSteps.clickClose();
    }

    @When("busco {string}")
    public void busco(String place) {
        airbnbSearchSteps.searchByText(place);
    }

    @And("presiono el boton omitir")
    public void presionoElBotonOmitir() {
        airbnbSearchSteps.butoonSkip();
    }

    @And("Presiono el boton bucar")
    public void presionoElBotonBucar() {
        airbnbSearchSteps.butoonBuscar();
    }

    @Then("muestra el texto {string}")
    public void muestra_el_texto(String text) {
        airbnbSearchSteps.getResultText(text);
    }

    @And("verifica que hay mas de una busqueda")
    public void verificaQueHayMasDeUnaBusqueda() {
        airbnbSearchSteps.searchItem();
    }
}
