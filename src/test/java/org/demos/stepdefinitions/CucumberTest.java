package org.demos.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.demos.pages.HomePage;
import org.demos.pages.LoginPage;
import org.demos.utils.Logs;


public class CucumberTest {
    private final HomePage homePage;
    private final LoginPage loginPage;


    public CucumberTest() {
        this.homePage = new HomePage(Hooks.getDriver());
        this.loginPage = new LoginPage(Hooks.getDriver());
    }


    @Given("Ingresamos a la pagina principal")
    public void ingresamos_a_la_pagina_principal() {
        Logs.info("Navegando hacia la pagina principal");
        homePage.navigateHomePage();
    }


    @Given("Validamos que nos encontramos en la pagina principal")
    public void validamos_que_nos_encontramos_en_la_pagina_principal() {
        Logs.info("Validando que no encontramos en la pagina indicada");
        homePage.validatePresenceHome();
    }


    @When("Navegamos a la pagina de login")
    public void navegamos_a_la_pagina_de_login() {
        homePage.navigateToLoginPage();
    }


    @Then("Validamos que nos encontramos en la pagina de login")
    public void validamos_que_nos_encontramos_en_la_pagina_de_login() {
        loginPage.validatePresenceLoginPage();
    }

    @Then("Visualizamos un elemento especifico")
    public void visualizamos_un_elemento_especifico() {
        loginPage.botonPresente();
    }
}
