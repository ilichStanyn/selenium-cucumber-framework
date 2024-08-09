# Proyecto junitCucumberJava

Este proyecto es una demostración de pruebas automatizadas utilizando **JUnit** y **Cucumber** en Java. También se
incluye integración con **Selenium** para pruebas de automatización en navegadores y **Allure** para la generación de
reportes.

## Requisitos previos

- **Java 17**: El proyecto está configurado para compilarse y ejecutarse con Java 17.
- **Maven**: Este proyecto utiliza Maven para la gestión de dependencias y la ejecución de pruebas.

## Dependencias principales

- **JUnit 4**: Framework para pruebas unitarias.
- **Cucumber**: Framework para pruebas BDD (Behavior Driven Development).
- **Selenium**: Herramienta para la automatización de navegadores web.
- **WebDriverManager**: Gestión automática de los binarios de WebDriver.
- **Log4j**: Biblioteca para el registro de logs.
- **Allure**: Framework para la generación de reportes de pruebas.

## Configuración

### Variables de sistema

El proyecto define algunas propiedades importantes que se pueden ajustar en el archivo `pom.xml`:

- **Browser**: El navegador con el que se ejecutarán las pruebas. La propiedad `${browser}` está configurada en `chrome`
  por defecto.
- **Cucumber Tags**: Manejo de etiquetas para ejecutar pruebas específicas con Cucumber. La
  propiedad `${cucumber.filter.tags}` está configurada en `@smoke` por defecto.

### Plugins

- **maven-surefire-plugin**: Se utiliza para la ejecución de pruebas unitarias.
- **cucumber-junit**: Plugin de Cucumber para ejecutar las pruebas BDD con JUnit.
- **allure-maven**: Plugin para generar reportes de Allure después de la ejecución de las pruebas.

## Ejecución de pruebas

### Desde Maven

Puedes ejecutar las pruebas utilizando el siguiente comando:

```bash
mvn test
````

Este comando ejecutará todas las pruebas definidas en el proyecto, utilizando el navegador y las etiquetas configuradas
en el archivo pom.xml.

## Configuración del navegador y etiquetas

Puedes modificar el navegador y las etiquetas desde la línea de comandos al ejecutar Maven:

```bash
mvn test -Dbrowser=firefox -Dcucumber.filter.tags="@regression"
````

Este comando ejecutará las pruebas utilizando Firefox como navegador y ejecutando solo las pruebas etiquetadas con
@regression.

## Generación de reportes

### Allure

Para generar un reporte de Allure después de la ejecución de las pruebas, puedes utilizar el siguiente comando:

````bash
allure generate --clean
````

Para abrir el reporte de allure una vez generado el reporte usamos el comando:

````bash
allure open
````