package co.wompi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// Ignora propiedades desconocidas en el JSON al deserializar, evita errores si llegan campos no mapeados
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantResponse {

    // Mapea el campo "data" del JSON a la propiedad data de tipo MerchantData
    @JsonProperty("data")
    private MerchantData data;

    // Getter para obtener el objeto data
    public MerchantData getData() {
        return data;
    }

    // Clase interna estática que representa el objeto "data" en la respuesta JSON
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MerchantData {
        private String id;
        private String name;
        private String email;

        // Mapea "contact_name" del JSON a contactName
        @JsonProperty("contact_name")
        private String contactName;

        // Mapea "phone_number" del JSON a phoneNumber
        @JsonProperty("phone_number")
        private String phoneNumber;

        private boolean active;

        @JsonProperty("logo_url")
        private String logoUrl;

        @JsonProperty("legal_name")
        private String legalName;

        @JsonProperty("legal_id_type")
        private String legalIdType;

        @JsonProperty("legal_id")
        private String legalId;

        @JsonProperty("public_key")
        private String publicKey;

        @JsonProperty("accepted_currencies")
        private List<String> acceptedCurrencies;

        @JsonProperty("fraud_javascript_key")
        private String fraudJavascriptKey;

        // Lista de grupos de fraude (se puede especificar el tipo si se conoce la estructura)
        @JsonProperty("fraud_groups")
        private List<Object> fraudGroups;

        // Métodos de pago aceptados (ej: ["CARD", "NEQUI"])
        @JsonProperty("accepted_payment_methods")
        private List<String> acceptedPaymentMethods;

        // Detalle de métodos de pago soportados (ver clase interna)
        @JsonProperty("payment_methods")
        private List<PaymentMethodDetail> paymentMethods;

        @JsonProperty("presigned_acceptance")
        private PresignedAcceptance presignedAcceptance;

        @JsonProperty("presigned_personal_data_auth")
        private PresignedPersonalDataAuth presignedPersonalDataAuth;

        // ID para click to pay
        @JsonProperty("click_to_pay_dpa_id")
        private String clickToPayDpaId;

        private String mcc; // Merchant Category Code

        @JsonProperty("acquirer_id")
        private String acquirerId;

        // Getters para cada campo (acceso tipo POJO)
        public String getId() { return id; }
        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getContactName() { return contactName; }
        public String getPhoneNumber() { return phoneNumber; }
        public boolean isActive() { return active; }
        public String getLogoUrl() { return logoUrl; }
        public String getLegalName() { return legalName; }
        public String getLegalIdType() { return legalIdType; }
        public String getLegalId() { return legalId; }
        public String getPublicKey() { return publicKey; }
        public List<String> getAcceptedCurrencies() { return acceptedCurrencies; }
        public String getFraudJavascriptKey() { return fraudJavascriptKey; }
        public List<Object> getFraudGroups() { return fraudGroups; }
        public List<String> getAcceptedPaymentMethods() { return acceptedPaymentMethods; }
        public List<PaymentMethodDetail> getPaymentMethods() { return paymentMethods; }
        public PresignedAcceptance getPresignedAcceptance() { return presignedAcceptance; }
        public PresignedPersonalDataAuth getPresignedPersonalDataAuth() { return presignedPersonalDataAuth; }
        public String getClickToPayDpaId() { return clickToPayDpaId; }
        public String getMcc() { return mcc; }
        public String getAcquirerId() { return acquirerId; }
    }

    // Clase interna para los detalles de cada método de pago
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaymentMethodDetail {
        private String name;

        // Procesadores de pago asociados a este método
        @JsonProperty("payment_processors")
        private List<PaymentProcessor> paymentProcessors;

        public String getName() { return name; }
        public List<PaymentProcessor> getPaymentProcessors() { return paymentProcessors; }
    }

    // Clase interna para cada procesador de pago (por ejemplo, entidades bancarias)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaymentProcessor {
        private String name;

        public String getName() { return name; }
    }

    // Clase interna para aceptación pre-firmada (ej: token para aceptación de términos)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PresignedAcceptance {
        @JsonProperty("acceptance_token")
        private String acceptanceToken;
        private String permalink;
        private String type;

        public String getAcceptanceToken() { return acceptanceToken; }
        public String getPermalink() { return permalink; }
        public String getType() { return type; }
    }

    // Clase interna para autorización de datos personales pre-firmada
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PresignedPersonalDataAuth {
        @JsonProperty("acceptance_token")
        private String acceptanceToken;
        private String permalink;
        private String type;

        public String getAcceptanceToken() { return acceptanceToken; }
        public String getPermalink() { return permalink; }
        public String getType() { return type; }
    }
}
