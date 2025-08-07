package co.wompi.stepdefinitions;

import co.wompi.questions.MerchantInformation;
import co.wompi.tasks.GetMerchant;
import co.wompi.tasks.GetMerchantWrongEndpoint;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

// Step Definitions para los escenarios relacionados con la consulta de comercios usando la API de Wompi
public class MerchantStepDefinitions {

    // Constantes de configuración para las pruebas (URL base y llave pública válida)
    private static final String BASE_URL   = "https://api-sandbox.co.uat.wompi.dev";
    private static final String PUBLIC_KEY = "pub_stagtest_g2u0HQd3ZMh05hsSgTS2lUV8t3s4mOt7";

    // Variables que permiten cambiar la llave pública durante el flujo de pruebas
    private String public_key;
    private Actor alejandra;

    // Se ejecuta antes de cada escenario para inicializar el "elenco" y el actor principal
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast()); // Inicializa el entorno de actores
        alejandra = OnStage.theActorCalled("Alejandra"); // Crea al actor principal
        // Otorga a Alejandra la habilidad de llamar la API en la BASE_URL
        alejandra.can(CallAnApi.at(BASE_URL));
    }

    // ---------- GIVEN ----------

    @Given("que tengo una llave publica valida")
    public void queTengoUnaLlavePublicaValida() {
        this.public_key = PUBLIC_KEY;
    }

    @Given("que tengo una llave publica invalida")
    public void queTengoUnaLlavePublicaInvalida() {
        this.public_key = "pub_INVALIDA";
    }

    @Given("que no proporciono una llave publica")
    public void queNoProporcinoUnaLlavePublica() {
        this.public_key = "";
    }

    // ---------- WHEN ----------

    @When("consulto la informacion del comercio")
    public void consultoLaInformacionDelComercio() {
        alejandra.attemptsTo(
                GetMerchant.withPublicKey(this.public_key)
        );
    }

    @When("consulto un endpoint incorrecto")
    public void consultoUnEndpointIncorrecto() {
        alejandra.attemptsTo(
                GetMerchantWrongEndpoint.withPublicKey(this.public_key)
        );
    }

    // ---------- THEN ----------

    @Then("deberia recibir una respuesta exitosa con los datos del comercio")
    public void deberiaRecibirUnaRespuestaExitosaConLosDatosDelComercio() {
        alejandra.should(
                seeThat(MerchantInformation.responseCode(), Matchers.equalTo(200)),
                seeThat(MerchantInformation.isValidResponse(), Matchers.is(true)),
                seeThat(MerchantInformation.name(), Matchers.equalTo("Alejandra Pruebas Sandbox UAT"))
        );
    }

    @Then("la respuesta debe contener los campos obligatorios: name, email, public_key y accepted_payment_methods")
    public void laRespuestaDebeContenerLosCamposObligatorios() {
        alejandra.should(
                seeThat("el campo 'name' existe", MerchantInformation.fieldExists("name"), Matchers.is(true)),
                seeThat("el campo 'email' existe", MerchantInformation.fieldExists("email"), Matchers.is(true)),
                seeThat("el campo 'public_key' existe", MerchantInformation.fieldExists("public_key"), Matchers.is(true)),
                seeThat("el campo 'accepted_payment_methods' existe", MerchantInformation.fieldExists("accepted_payment_methods"), Matchers.is(true))
        );
    }

    @Then("la respuesta debe incluir el metodo de pago {string} entre los aceptados")
    public void laRespuestaDebeIncluirElMetodoDePagoEntreLosAceptados(String expectedPaymentMethod) {
        alejandra.should(
                seeThat("el método de pago está incluido",
                        MerchantInformation.acceptedPaymentMethods(), Matchers.hasItem(expectedPaymentMethod))
        );
    }

    @Then("deberia recibir un codigo de error {int}")
    public void deberiaRecibirUnCodigoDeError(int expectedStatusCode) {
        alejandra.should(
                seeThat(MerchantInformation.responseCode(), Matchers.equalTo(expectedStatusCode))
        );
    }

}
