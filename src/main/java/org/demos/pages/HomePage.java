package org.demos.pages;

import org.demos.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateHomePage() {
        navigateTo("https://automationexercise.com/");
    }

    public void validatePresenceHome() {
        validateTitle();
    }

    public void navigateToLoginPage() {
        click(HomePageLocators.singUpLocator);
    }
}
