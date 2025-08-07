package co.wompi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantResponse {
    @JsonProperty("data")
    private MerchantData data;

    // Getter para data
    public MerchantData getData() {
        return data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MerchantData {
        private String id;
        private String name;
        private String email;
        @JsonProperty("contact_name")
        private String contactName;
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
        @JsonProperty("fraud_groups")
        private List<Object> fraudGroups; // Can be more specific if structure is known
        @JsonProperty("accepted_payment_methods")
        private List<String> acceptedPaymentMethods;
        @JsonProperty("payment_methods")
        private List<PaymentMethodDetail> paymentMethods;
        @JsonProperty("presigned_acceptance")
        private PresignedAcceptance presignedAcceptance;
        @JsonProperty("presigned_personal_data_auth")
        private PresignedPersonalDataAuth presignedPersonalDataAuth;
        @JsonProperty("click_to_pay_dpa_id")
        private String clickToPayDpaId;
        private String mcc;
        @JsonProperty("acquirer_id")
        private String acquirerId;

        // Getters
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaymentMethodDetail {
        private String name;
        @JsonProperty("payment_processors")
        private List<PaymentProcessor> paymentProcessors;

        public String getName() { return name; }
        public List<PaymentProcessor> getPaymentProcessors() { return paymentProcessors; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaymentProcessor {
        private String name;

        public String getName() { return name; }
    }

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
