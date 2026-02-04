package co.wompi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public MerchantData() {}

    public MerchantData(String id, String name, String email, String contactName,
                       String phoneNumber, boolean active, String logoUrl, String legalName,
                       String legalIdType, String legalId, String publicKey,
                       List<String> acceptedCurrencies, String fraudJavascriptKey,
                       List<Object> fraudGroups, List<String> acceptedPaymentMethods,
                       List<PaymentMethodDetail> paymentMethods,
                       PresignedAcceptance presignedAcceptance,
                       PresignedPersonalDataAuth presignedPersonalDataAuth,
                       String clickToPayDpaId, String mcc, String acquirerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.logoUrl = logoUrl;
        this.legalName = legalName;
        this.legalIdType = legalIdType;
        this.legalId = legalId;
        this.publicKey = publicKey;
        this.acceptedCurrencies = acceptedCurrencies;
        this.fraudJavascriptKey = fraudJavascriptKey;
        this.fraudGroups = fraudGroups;
        this.acceptedPaymentMethods = acceptedPaymentMethods;
        this.paymentMethods = paymentMethods;
        this.presignedAcceptance = presignedAcceptance;
        this.presignedPersonalDataAuth = presignedPersonalDataAuth;
        this.clickToPayDpaId = clickToPayDpaId;
        this.mcc = mcc;
        this.acquirerId = acquirerId;
    }

    public Optional<String> getId() { return Optional.ofNullable(id); }
    public Optional<String> getName() { return Optional.ofNullable(name); }
    public Optional<String> getEmail() { return Optional.ofNullable(email); }
    public Optional<String> getContactName() { return Optional.ofNullable(contactName); }
    public Optional<String> getPhoneNumber() { return Optional.ofNullable(phoneNumber); }
    public boolean isActive() { return active; }
    public Optional<String> getLogoUrl() { return Optional.ofNullable(logoUrl); }
    public Optional<String> getLegalName() { return Optional.ofNullable(legalName); }
    public Optional<String> getLegalIdType() { return Optional.ofNullable(legalIdType); }
    public Optional<String> getLegalId() { return Optional.ofNullable(legalId); }
    public Optional<String> getPublicKey() { return Optional.ofNullable(publicKey); }
    public Optional<List<String>> getAcceptedCurrencies() { return Optional.ofNullable(acceptedCurrencies); }
    public Optional<String> getFraudJavascriptKey() { return Optional.ofNullable(fraudJavascriptKey); }
    public Optional<List<Object>> getFraudGroups() { return Optional.ofNullable(fraudGroups); }
    public Optional<List<String>> getAcceptedPaymentMethods() { return Optional.ofNullable(acceptedPaymentMethods); }
    public Optional<List<PaymentMethodDetail>> getPaymentMethods() { return Optional.ofNullable(paymentMethods); }
    public Optional<PresignedAcceptance> getPresignedAcceptance() { return Optional.ofNullable(presignedAcceptance); }
    public Optional<PresignedPersonalDataAuth> getPresignedPersonalDataAuth() { return Optional.ofNullable(presignedPersonalDataAuth); }
    public Optional<String> getClickToPayDpaId() { return Optional.ofNullable(clickToPayDpaId); }
    public Optional<String> getMcc() { return Optional.ofNullable(mcc); }
    public Optional<String> getAcquirerId() { return Optional.ofNullable(acquirerId); }

    public boolean isValid() {
        return name != null && !name.trim().isEmpty() &&
               email != null && !email.trim().isEmpty() &&
               publicKey != null && !publicKey.trim().isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantData that = (MerchantData) o;
        return active == that.active &&
               Objects.equals(id, that.id) &&
               Objects.equals(name, that.name) &&
               Objects.equals(email, that.email) &&
               Objects.equals(publicKey, that.publicKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, publicKey, active);
    }

    @Override
    public String toString() {
        return "MerchantData{" +
                "id='" + maskSensitiveData(id) + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", publicKey='" + maskSensitiveData(publicKey) + '\'' +
                ", active=" + active +
                '}';
    }

    private String maskSensitiveData(String data) {
        if (data == null || data.length() < 8) return "***";
        return data.substring(0, 4) + "***" + data.substring(data.length() - 4);
    }
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
