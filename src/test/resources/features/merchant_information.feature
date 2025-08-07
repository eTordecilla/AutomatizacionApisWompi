@Regression
Feature: Consulta de informacion del comercio en Wompi
  @test1
  Scenario: Consulta exitosa de informacion del comercio con llave publica valida
    Given que tengo una llave publica valida
    When consulto la informacion del comercio
    Then deberia recibir una respuesta exitosa con los datos del comercio
  @test2
  Scenario: Consulta exitosa verifica campos obligatorios
    Given que tengo una llave publica valida
    When consulto la informacion del comercio
    Then la respuesta debe contener los campos obligatorios: name, email, public_key y accepted_payment_methods
  @test3
  Scenario: Consulta exitosa verifica metodos de pago aceptados
    Given que tengo una llave publica valida
    When consulto la informacion del comercio
    Then la respuesta debe incluir el metodo de pago "NEQUI" entre los aceptados
  @test4
  Scenario: Consulta fallida con llave pública invalida
    Given que tengo una llave publica invalida
    When consulto la informacion del comercio
    Then deberia recibir un codigo de error 401
  @test5
  Scenario: Consulta fallida sin llave publica
    Given que no proporciono una llave publica
    When consulto la informacion del comercio
    Then deberia recibir un codigo de error 401
  @test6
  Scenario: Consulta fallida con endpoint incorrecto
    Given que tengo una llave publica valida
    When consulto un endpoint incorrecto
    Then deberia recibir un codigo de error 404
