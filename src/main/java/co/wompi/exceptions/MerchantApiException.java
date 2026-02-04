package co.wompi.exceptions;

public class MerchantApiException extends RuntimeException {
    
    private final int statusCode;
    private final String errorDetails;
    
    public MerchantApiException(String message) {
        super(message);
        this.statusCode = -1;
        this.errorDetails = null;
    }
    
    public MerchantApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.errorDetails = null;
    }
    
    public MerchantApiException(String message, int statusCode, String errorDetails) {
        super(message);
        this.statusCode = statusCode;
        this.errorDetails = errorDetails;
    }
    
    public MerchantApiException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = -1;
        this.errorDetails = null;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public String getErrorDetails() {
        return errorDetails;
    }
    
    @Override
    public String toString() {
        return "MerchantApiException{" +
                "message='" + getMessage() + '\'' +
                ", statusCode=" + statusCode +
                ", errorDetails='" + errorDetails + '\'' +
                '}';
    }
}
