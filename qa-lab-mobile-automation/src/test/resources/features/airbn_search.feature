Feature: Búsqueda en Airbnb

  @test
  Scenario: Búsqueda simple de hospedaje

    Given que me enuentro en el login de Airbnb
    When busco "Vichayito"
    And presiono el boton omitir
    And Presiono el boton bucar
    Then muestra el texto "Más de 1000 alojamientos"
    And verifica que hay mas de una busqueda