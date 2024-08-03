package org.demos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void type(String locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public void click(String locator) {
        find(locator).click();
    }

    private String getTitleValue() {
        return driver.getTitle();
    }

    private String getText(String locator) {
        return find(locator).getText();
    }

    protected boolean validateTitle() {
        String title = getTitleValue();
        return driver.getTitle().equals(title);
    }

    public boolean validarElementoIsDisplay(String locator) {
        WebElement element = find(locator);
        return element.isDisplayed();
    }


}
