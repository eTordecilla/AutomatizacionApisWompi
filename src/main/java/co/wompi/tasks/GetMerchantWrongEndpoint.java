package co.wompi.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class GetMerchantWrongEndpoint implements Task {

    private final String publicKey;
    private static final String WRONG_ENDPOINT = "v1/merchants-wrong-endpoint/";

    public GetMerchantWrongEndpoint(String publicKey) {
        this.publicKey = publicKey;
    }

    public static GetMerchantWrongEndpoint withPublicKey(String publicKey) {
        return new GetMerchantWrongEndpoint(publicKey);
    }

    @Override
    @Step("{0} busca informacion del comercio con un endpoint incorrecto")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(WRONG_ENDPOINT + publicKey)
        );
    }
}