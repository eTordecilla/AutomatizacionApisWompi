package co.wompi.tasks;

import co.wompi.exceptions.MerchantApiException;
import co.wompi.utils.ApiConfig;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetMerchant implements Task {

    private static final Logger logger = LoggerFactory.getLogger(GetMerchant.class);
    
    private final String publicKey;

    public GetMerchant(String publicKey) {
        this.publicKey = publicKey;
    }

    public static GetMerchant withPublicKey(String publicKey) {
        return new GetMerchant(publicKey);
    }

    @Override
    @Step("{0} consulta la información del comercio con llave pública")
    public <T extends Actor> void performAs(T actor) {
        logger.info("Consultando información del comercio con publicKey: {}", maskPublicKey(publicKey));
        
        try {
            actor.attemptsTo(
                    Get.resource("/v1/merchants/{publicKey}")
                            .with(request -> request
                                    .pathParam("publicKey", publicKey)
                                    .relaxedHTTPSValidation()
                                    .config(io.restassured.RestAssured.config()
                                        .httpClient(io.restassured.config.HttpClientConfig.httpClientConfig()
                                            .setParam("http.connection.timeout", ApiConfig.getInstance().getTimeout())
                                            .setParam("http.socket.timeout", ApiConfig.getInstance().getTimeout())
                                        )
                                    )
                            )
            );
            logger.debug("Petición GET enviada exitosamente para el comercio");
        } catch (Exception e) {
            logger.error("Error al consultar el comercio: {}", e.getMessage(), e);
            throw new MerchantApiException("Error al consultar el comercio: " + e.getMessage(), e);
        }
    }
    
    private String maskPublicKey(String key) {
        if (key == null || key.length() < 8) return "***";
        return key.substring(0, 4) + "***" + key.substring(key.length() - 4);
    }
}
