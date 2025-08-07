# Autor:Elkin David Tordecilla Avila
#### https://www.linkedin.com/in/elkin-david-tordecilla-avila-b137ab152/
##### ------------------------------------------------------------------------------------------------------
# Automation API -REST WOMPI
##### ------------------------------------------------------------------------------------------------------

#### URL BASE a consumir:  https://api-sandbox.co.uat.wompi.dev/v1/merchants
#### Patron de diseño: Screenplay
#### Framework: gherkin, cucumber, Junit, Serenity-Rest, API-REST
#### Framework adicionales: cucumber for java
#### Lenguaje programacion: Java
#### version gradle: gradle-8.10
#### OPEN_JDK Version 17.0.11
#### ID: Intellij IDEA community Edition 2025.2
##### ------------------------------------------------------------------------------------------------------

### Todos los casos pruebas cumplen con cada criterio solicitado
##### ------------------------------------------------------------------------------------------------------
# PASOS PARA LA EJECUCIÓN

## Opcion 1
### PASO A PASO PARA LA EJECUCIÓN POR CONSOLA

### Comando para limpiar el proyecto y luego ejecuta TODOS los escenarios uno por uno
#### ./gradlew clean test

### Comando para ejecutar por feature
#### ./gradlew test --tests "org.wompi.runners.ApiTestRunner"

### Comando para generar los test y el reporte despues que haya terminado un test (Por consola arrojara la ruta .html )
#### ./gradlew clean test aggregate

