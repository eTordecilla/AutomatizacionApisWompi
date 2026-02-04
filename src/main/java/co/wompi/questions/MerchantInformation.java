package co.wompi.questions;

// Importa la clase MerchantResponse, que representa el modelo de la respuesta del comercio
import co.wompi.models.MerchantResponse;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.List;

// Clase que contiene diferentes Questions para consultar información de la última respuesta HTTP recibida
public class MerchantInformation {

    // Devuelve el código de respuesta HTTP de la última petición
    public static Question<Integer> responseCode() {
        return actor -> LastResponse.received().answeredBy(actor).getStatusCode();
    }

    // Devuelve el nombre del comercio obtenido en la respuesta
    public static Question<String> name() {
        return actor -> LastResponse.received()
                .answeredBy(actor)                 // Obtiene la última respuesta para el actor
                .as(MerchantResponse.class)        // Deserializa la respuesta al modelo MerchantResponse
                .getData()                        // Accede al objeto 'data'
                .getName()                        // Obtiene el campo 'name' como Optional<String>
                .orElse(null);                    // Extrae el valor o null si está vacío
    }

    // Verifica si un campo específico existe dentro del objeto 'data' en la respuesta
    public static Question<Boolean> fieldExists(String fieldName) {
        return actor -> LastResponse.received()
                .answeredBy(actor)
                .jsonPath()
                .get("data." + fieldName) != null; // Buscamos el campo usando JsonPath y verifica si es distinto de null
    }

    // Devuelve la lista de métodos de pago aceptados por el comercio
    public static Question<List<String>> acceptedPaymentMethods() {
        return actor -> LastResponse.received()
                .answeredBy(actor)
                .as(MerchantResponse.class)
                .getData()
                .getAcceptedPaymentMethods() // Devuelve Optional<List<String>>
                .orElse(null);               // Extrae el valor o null si está vacío
    }

    // Valida si la respuesta es válida, es decir, no es nula y contiene el nombre del comercio
    public static Question<Boolean> isValidResponse() {
        return actor -> {
            MerchantResponse response = LastResponse.received()
                    .answeredBy(actor)
                    .as(MerchantResponse.class);

            // La respuesta es válida si no es nula, tiene data, y data tiene nombre
            return response != null &&
                    response.getData() != null &&
                    response.getData().getName().isPresent();
        };
    }

    // Devuelve el mensaje de error de la respuesta, si existe
    public static Question<String> errorMessage() {
        return actor -> LastResponse.received()
                .answeredBy(actor)
                .jsonPath()
                .getString("error.message"); // Busca el mensaje de error en la respuesta
    }

    // Verifica si la respuesta contiene información del comercio ('data')
    public static Question<Boolean> hasMerchantData() {
        return actor -> {
            try {
                MerchantResponse response = LastResponse.received()
                        .answeredBy(actor)
                        .as(MerchantResponse.class);
                // La respuesta tiene data si no es nula y el campo data tampoco es nulo
                return response != null && response.getData() != null;
            } catch (Exception e) {
                // Si ocurre una excepción al deserializar, retorna false
                return false;
            }
        };
    }
}
