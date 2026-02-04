package co.wompi.utils;

import java.util.Properties;

public final class ApiConfig {
    private static final String DEFAULT_BASE_URL = "https://api-sandbox.co.uat.wompi.dev";
    private static final String DEFAULT_PUBLIC_KEY = "pub_stagtest_g2u0HQd3ZMh05hsSgTS2lUV8t3s4mOt7";
    private static final String DEFAULT_PRIVATE_KEY = "prv_stagtest_5i0ZGlGiFcDQifYsXxvsny7Y37tkqFWg";
    private static final int DEFAULT_TIMEOUT = 5000;

    private static volatile ApiConfig instance;
    private final String baseUrl;
    private final String publicKey;
    private final String privateKey;
    private final int timeout;

    private ApiConfig() {
        Properties props = System.getProperties();
        this.baseUrl = props.getProperty("wompi.api.base.url", DEFAULT_BASE_URL);
        this.publicKey = props.getProperty("wompi.api.public.key", DEFAULT_PUBLIC_KEY);
        this.privateKey = props.getProperty("wompi.api.private.key", DEFAULT_PRIVATE_KEY);
        
        String timeoutStr = props.getProperty("wompi.api.timeout", String.valueOf(DEFAULT_TIMEOUT));
        this.timeout = Integer.parseInt(timeoutStr);
    }

    public static ApiConfig getInstance() {
        if (instance == null) {
            synchronized (ApiConfig.class) {
                if (instance == null) {
                    instance = new ApiConfig();
                }
            }
        }
        return instance;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getInvalidPublicKey() {
        return "pub_INVALIDA";
    }

    public String getEmptyPublicKey() {
        return "";
    }

    @Override
    public String toString() {
        return "ApiConfig{" +
                "baseUrl='" + baseUrl + '\'' +
                ", publicKey='" + maskKey(publicKey) + '\'' +
                ", timeout=" + timeout +
                '}';
    }

    private String maskKey(String key) {
        if (key == null || key.length() < 8) {
            return "***";
        }
        return key.substring(0, 4) + "***" + key.substring(key.length() - 4);
    }
}
