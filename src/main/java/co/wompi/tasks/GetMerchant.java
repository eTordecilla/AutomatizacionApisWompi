package co.wompi.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

// Implementa la interfaz Task del patrón Screenplay.
// Representa la acción de consultar información de un comercio por su llave pública.
public class GetMerchant implements Task {

    // Llave pública del comercio que se va a consultar
    private final String publicKey;

    // Constructor que recibe la llave pública
    public GetMerchant(String publicKey) {
        this.publicKey = publicKey;
    }

    // Método estático para crear la tarea de forma más legible desde los tests
    public static GetMerchant withPublicKey(String publicKey) {
        // Usa Tasks.instrumented para la correcta creación de la tarea por Serenity
        return Tasks.instrumented(GetMerchant.class, publicKey);
    }

    // Paso que se registrará en los reportes de Serenity. Se muestra el actor que ejecuta la acción.
    @Step("{0} consulta la información del comercio")
    public <T extends Actor> void performAs(T actor) {
        try {
            // El actor realiza la acción de hacer una petición GET al recurso con la publicKey como parámetro de ruta
            actor.attemptsTo(
                    Get.resource("/v1/merchants/{publicKey}")
                            .with(
                                    request -> request
                                            .pathParam("publicKey", publicKey) // Se inserta el valor de la llave pública en la URL
                            )
            );
        } catch (Exception e) {
            // Si ocurre un error durante la petición, lanza una excepción con mensaje descriptivo
            throw new RuntimeException("Error al consultar el comercio: " + e.getMessage(), e);
        }
    }
}
