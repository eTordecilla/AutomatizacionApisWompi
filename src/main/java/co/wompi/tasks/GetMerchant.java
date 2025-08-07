package co.wompi.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetMerchant implements Task {
    private final String publicKey;
    private boolean invalidEndpoint = false;

    public GetMerchant(String publicKey) {
        this.publicKey = publicKey;
    }

    public static GetMerchant withPublicKey(String publicKey) {
        return instrumented(GetMerchant.class, publicKey);
    }

    public static GetMerchant withPublicKeyAtInvalidEndpoint(String publicKey) {
        GetMerchant task = instrumented(GetMerchant.class, publicKey);
        task.invalidEndpoint = true;
        return task;
    }

    @Step("{0} consulta la informacion del comercio con la llave publica {publicKey}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            if (publicKey == null || publicKey.isEmpty()) {
                throw new RuntimeException("La llave publica no puede ser nula o vacia");
            }

            String endpoint = invalidEndpoint
                    ? "/invalid_endpoint"
                    : "/v1/merchants/" + publicKey;

            actor.attemptsTo(
                    Get.resource(endpoint)
                            .with(request -> request
                                    .header("Content-Type", "application/json")
                            )
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar el comercio: " + e.getMessage(), e);
        }
    }
}