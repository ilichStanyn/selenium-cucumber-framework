Feature: Prueba de validación

  Background:
    Given Ingresamos a la pagina principal
    And Validamos que nos encontramos en la pagina principal

  @regression
  Scenario: Login exitoso
    When Navegamos a la pagina de login
    Then Validamos que nos encontramos en la pagina de login

  @regression
  Scenario: Login exitoso 2
    When Navegamos a la pagina de login
    Then Validamos que nos encontramos en la pagina de login

  @smoke @regression
  Scenario: Login exitoso 30
    When Navegamos a la pagina de login
    Then Validamos que nos encontramos en la pagina de login

  @smoke @regression
  Scenario: Login exitoso 40
    When Navegamos a la pagina de login
    Then Validamos que nos encontramos en la pagina de login
    And Visualizamos un elemento especifico