package org.demos.pages;

import org.demos.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void validatePresenceLoginPage() {
        validateTitle();
    }

    public void botonPresente() {
        validarElementoIsDisplay(LoginPageLocators.btnLogin);
    }
}
