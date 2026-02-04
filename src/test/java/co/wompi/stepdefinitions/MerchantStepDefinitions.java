package co.wompi.stepdefinitions;

import co.wompi.questions.MerchantInformation;
import co.wompi.tasks.GetMerchant;
import co.wompi.tasks.GetMerchantWrongEndpoint;
import co.wompi.utils.ApiConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class MerchantStepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(MerchantStepDefinitions.class);
    
    private final ApiConfig config = ApiConfig.getInstance();
    private String currentPublicKey;
    private Actor alejandra;

    @Before
    public void setUp() {
        logger.info("Inicializando escenario de prueba");
        OnStage.setTheStage(new OnlineCast());
        alejandra = OnStage.theActorCalled("Alejandra");
        alejandra.can(CallAnApi.at(config.getBaseUrl()));
        logger.debug("Actor {} configurado con URL base: {}", alejandra.getName(), config.getBaseUrl());
    }

    @Given("que tengo una llave publica valida")
    public void queTengoUnaLlavePublicaValida() {
        this.currentPublicKey = config.getPublicKey();
        logger.debug("Configurada llave pública válida");
    }

    @Given("que tengo una llave publica invalida")
    public void queTengoUnaLlavePublicaInvalida() {
        this.currentPublicKey = config.getInvalidPublicKey();
        logger.debug("Configurada llave pública inválida");
    }

    @Given("que no proporciono una llave publica")
    public void queNoProporcinoUnaLlavePublica() {
        this.currentPublicKey = config.getEmptyPublicKey();
        logger.debug("Configurada llave pública vacía");
    }

    @When("consulto la informacion del comercio")
    public void consultoLaInformacionDelComercio() {
        logger.info("Ejecutando consulta de información del comercio");
        alejandra.attemptsTo(GetMerchant.withPublicKey(this.currentPublicKey));
    }

    @When("consulto un endpoint incorrecto")
    public void consultoUnEndpointIncorrecto() {
        logger.info("Ejecutando consulta a endpoint incorrecto");
        alejandra.attemptsTo(GetMerchantWrongEndpoint.withPublicKey(this.currentPublicKey));
    }

    @Then("deberia recibir una respuesta exitosa con los datos del comercio")
    public void deberiaRecibirUnaRespuestaExitosaConLosDatosDelComercio() {
        logger.info("Validando respuesta exitosa del comercio");
        alejandra.should(
                seeThat(MerchantInformation.responseCode(), Matchers.equalTo(200)),
                seeThat(MerchantInformation.isValidResponse(), Matchers.is(true)),
                seeThat(MerchantInformation.name(), Matchers.equalTo("Alejandra Pruebas Sandbox UAT"))
        );
        logger.info("Validación de respuesta exitosa completada");
    }

    @Then("la respuesta debe contener los campos obligatorios: name, email, public_key y accepted_payment_methods")
    public void laRespuestaDebeContenerLosCamposObligatorios() {
        logger.info("Validando campos obligatorios en la respuesta");
        String[] requiredFields = {"name", "email", "public_key", "accepted_payment_methods"};
        
        for (String field : requiredFields) {
            alejandra.should(
                    seeThat("el campo '" + field + "' existe", 
                           MerchantInformation.fieldExists(field), Matchers.is(true))
            );
        }
        logger.info("Validación de campos obligatorios completada");
    }

    @Then("la respuesta debe incluir el metodo de pago {string} entre los aceptados")
    public void laRespuestaDebeIncluirElMetodoDePagoEntreLosAceptados(String expectedPaymentMethod) {
        logger.info("Validando método de pago: {}", expectedPaymentMethod);
        alejandra.should(
                seeThat("el método de pago '" + expectedPaymentMethod + "' está incluido",
                        MerchantInformation.acceptedPaymentMethods(), Matchers.hasItem(expectedPaymentMethod))
        );
    }

    @Then("deberia recibir un codigo de error {int}")
    public void deberiaRecibirUnCodigoDeError(int expectedStatusCode) {
        logger.info("Validando código de error esperado: {}", expectedStatusCode);
        alejandra.should(
                seeThat(MerchantInformation.responseCode(), Matchers.equalTo(expectedStatusCode))
        );
        logger.info("Validación de código de error completada");
    }
}
