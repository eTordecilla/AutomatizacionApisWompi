package co.wompi.exceptions;

public class ApiConfigurationException extends RuntimeException {
    
    public ApiConfigurationException(String message) {
        super(message);
    }
    
    public ApiConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
