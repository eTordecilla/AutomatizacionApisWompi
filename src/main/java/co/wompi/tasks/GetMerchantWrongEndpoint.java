package co.wompi.tasks;

import co.wompi.exceptions.MerchantApiException;
import co.wompi.utils.ApiConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetMerchantWrongEndpoint implements Task {

    private static final Logger logger = LoggerFactory.getLogger(GetMerchantWrongEndpoint.class);
    private static final String WRONG_ENDPOINT = "/v1/merchants-wrong-endpoint/";
    
    private final String publicKey;

    public GetMerchantWrongEndpoint(String publicKey) {
        this.publicKey = publicKey;
    }

    public static GetMerchantWrongEndpoint withPublicKey(String publicKey) {
        return new GetMerchantWrongEndpoint(publicKey);
    }

    @Override
    @Step("{0} busca información del comercio con un endpoint incorrecto")
    public <T extends Actor> void performAs(T actor) {
        logger.info("Consultando endpoint incorrecto con publicKey: {}", maskPublicKey(publicKey));
        
        try {
            actor.attemptsTo(
                    Get.resource(WRONG_ENDPOINT + publicKey)
                            .with(request -> request
                                    .relaxedHTTPSValidation()
                                    .config(io.restassured.RestAssured.config()
                                        .httpClient(io.restassured.config.HttpClientConfig.httpClientConfig()
                                            .setParam("http.connection.timeout", ApiConfig.getInstance().getTimeout())
                                            .setParam("http.socket.timeout", ApiConfig.getInstance().getTimeout())
                                        )
                                    )
                            )
            );
            logger.debug("Petición a endpoint incorrecto enviada");
        } catch (Exception e) {
            logger.error("Error al consultar endpoint incorrecto: {}", e.getMessage(), e);
            throw new MerchantApiException("Error al consultar endpoint incorrecto: " + e.getMessage(), e);
        }
    }
    
    private String maskPublicKey(String key) {
        if (key == null || key.length() < 8) return "***";
        return key.substring(0, 4) + "***" + key.substring(key.length() - 4);
    }
}
