package co.wompi.questions;

import co.wompi.models.MerchantResponse;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.List;

public class MerchantInformation {
    public static Question<Integer> responseCode() {
        return actor -> LastResponse.received().answeredBy(actor).getStatusCode();
    }

    public static Question<String> name() {
        return actor -> LastResponse.received()
                .answeredBy(actor)
                .as(MerchantResponse.class)
                .getData() // Accedemos al objeto data
                .getName(); // Luego al nombre
    }

    public static Question<Boolean> fieldExists(String fieldName) {
        return actor -> LastResponse.received()
                .answeredBy(actor)
                .jsonPath()
                .get("data." + fieldName) != null;
    }

    public static Question<List<String>> acceptedPaymentMethods() {
        return actor -> LastResponse.received()
                .answeredBy(actor)
                .as(MerchantResponse.class)
                .getData()
                .getAcceptedPaymentMethods();
    }

    public static Question<Boolean> isValidResponse() {
        return actor -> {
            MerchantResponse response = LastResponse.received()
                    .answeredBy(actor)
                    .as(MerchantResponse.class);

            return response != null &&
                    response.getData() != null &&
                    response.getData().getName() != null;
        };
    }

    public static Question<String> errorMessage() {
        return actor -> LastResponse.received()
                .answeredBy(actor)
                .jsonPath()
                .getString("error.message");
    }

    public static Question<Boolean> hasMerchantData() {
        return actor -> {
            try {
                MerchantResponse response = LastResponse.received()
                        .answeredBy(actor)
                        .as(MerchantResponse.class);
                return response != null && response.getData() != null;
            } catch (Exception e) {
                return false;
            }
        };
    }
}