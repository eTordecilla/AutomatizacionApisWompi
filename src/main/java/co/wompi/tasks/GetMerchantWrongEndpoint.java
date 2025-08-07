package co.wompi.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

// Esta clase implementa una tarea (Task) que realiza una petición GET a un endpoint incorrecto.
// Se utiliza para probar el comportamiento de la API ante rutas no válidas o errores esperados.
public class GetMerchantWrongEndpoint implements Task {

    // Llave pública que se usará para construir la URL de la petición
    private final String publicKey;

    // Constante que almacena la ruta incorrecta del endpoint
    private static final String WRONG_ENDPOINT = "/v1/merchants-wrong-endpoint/";

    // Constructor que recibe la llave pública y la asigna al atributo de la clase
    public GetMerchantWrongEndpoint(String publicKey) {
        this.publicKey = publicKey;
    }

    public static GetMerchantWrongEndpoint withPublicKey(String publicKey) {
        return new GetMerchantWrongEndpoint(publicKey);
    }

    // Sobrescribe el método performAs del Task.
    // Este método define qué acciones realiza el actor cuando ejecuta esta tarea.
    @Override
    @Step("{0} busca informacion del comercio con un endpoint incorrecto")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Realiza la petición GET a un endpoint incorrecto concatenando la llave pública
                Get.resource(WRONG_ENDPOINT + publicKey)
        );
    }
}
