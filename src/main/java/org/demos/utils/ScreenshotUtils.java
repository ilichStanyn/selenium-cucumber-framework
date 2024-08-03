package org.demos.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ScreenshotUtils {

    private final WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void cleanScreenshotDirectory() {
        File screenshotDir = new File("screenshot");
        if (screenshotDir.exists()) {
            File[] files = screenshotDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (!file.isDirectory()) {
                        file.delete();
                    }
                }
            }
        }
    }

    public void takeScreeshot(String testName, String status) {

        File screenshotDir = new File("screenshot");

        // Verifica si el directorio existe; si no, lo crea
        if (!screenshotDir.exists()) {
            boolean created = screenshotDir.mkdirs(); // Crea directorios si no existen
            if (!created) {
                System.err.println("No se pudo crear el directorio de capturas de pantalla.");
                return;
            }
        }

        // Define el archivo de destino para la captura de pantalla
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(screenshotDir, testName + "-" + status + ".png");

        // Intenta copiar el archivo de captura de pantalla al destino
        try {
            FileHandler.copy(screenshot, destinationFile);
            System.out.println("Captura de pantalla guardada en: " + destinationFile.getAbsolutePath());
            try (FileInputStream is = new FileInputStream(destinationFile)) {
                Allure.addAttachment(testName + "-" + status, "image/png", is, "png");
            }
            //Allure.addAttachment(testName + "+" + status, "image/png", new FileInputStream(screenshot), "png");
        } catch (IOException e) {
            System.err.println("Ocurrió un error al guardar la captura de pantalla: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
