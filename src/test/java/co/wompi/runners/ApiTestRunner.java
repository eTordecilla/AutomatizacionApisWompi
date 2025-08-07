package co.wompi.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// Indica que la clase debe ser ejecutada usando el runner de Serenity adaptado a Cucumber
@RunWith(CucumberWithSerenity.class)

// Configura las opciones de Cucumber para la ejecución de los tests
@CucumberOptions(
        // Carpeta donde se encuentran los archivos .feature escritos en Gherkin
        features = "src/test/resources/features",

        // Paquete donde se encuentran las definiciones de pasos (Step Definitions)
        glue = "co.wompi.stepdefinitions",

        // Configura el tipo de nomenclatura para los snippets (CAMELCASE genera métodos como miMetodoEjemplo)
        snippets = CucumberOptions.SnippetType.CAMELCASE,

        // Plugins para la generación de reportes (consola legible, HTML y JSON)
        plugin = {
                "pretty", // Salida más legible en consola
                "html:target/cucumber-reports/cucumber.html", // Reporte en HTML
                "json:target/cucumber-reports/cucumber.json" // Reporte en formato JSON
        }
        // Puedes descomentar la siguiente línea para ejecutar solo escenarios con el tag @test6
        //,tags = "@test6"
)
public class ApiTestRunner {
        // Esta clase no necesita código adicional. Su única función es ser el punto de entrada para los tests.
}
