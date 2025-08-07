# Autor:Elkin David Tordecilla Avila
#### https://www.linkedin.com/in/alejandro-polo-carvajal-790b79186/
##### ------------------------------------------------------------------------------------------------------
# Curso Automation API -REST
##### ------------------------------------------------------------------------------------------------------

#### URL BASE a consumir:  https://api-sandbox.co.uat.wompi.dev/v1/merchants
#### Patron de diseño: Screenplay
#### Framework: gherkin, cucumber, Junit, Serenity-Rest, API-REST
#### Framework adicionales: SonarLink, cucumber for java
#### Lenguaje programacion: Java
#### version gradle: gradle-8.10
#### OPEN_JDK Version 17.0.11
#### ID: Intellij IDEA community Edition 2025.2
##### ------------------------------------------------------------------------------------------------------

### Todos los casos pruebas cumplen con cada criterio solicitado
### Todas las clases estan con auto-ident lines y reformat code
### El codigo no tiene ningun Bug o codeSmell
##### ------------------------------------------------------------------------------------------------------
# PASOS PARA LA EJECUCIÓN

## Opcion 1
### PASO A PASO PARA LA EJECUCIÓN POR CONSOLA

### Comando para limpiar el proyecto y luego ejecuta TODOS los escenarios uno por uno
#### ./gradlew clean test

### Comando para ejecutar por feature
#### ./gradlew test --tests "org.wompi.runners.GetRunner"
#### ./gradlew test --tests "org.wompi.runners" --- TODO LOS FEATURES

### Comando para generar reporte despues que haya terminado un test (Por consola arrojara la ruta .html )
#### ./gradlew reports

### Comando para limpiar la carpeta Target (Reportes)
#### ./gradlew clearReports