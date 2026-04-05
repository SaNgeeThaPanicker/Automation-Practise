package test.resources;

public class configManager {

    String baseUrl = ConfigReader.get("base.url");
    String token = System.getenv("API_TOKEN");

    public static String getBaseUrl() {

        String env = System.getProperty("env", "qa");

        switch (env.toLowerCase()) {
            case "qa":
                return ConfigReader.get("qa.url");

            case "stage":
                return ConfigReader.get("stage.url");

            case "prod":
                return ConfigReader.get("prod.url");

            default:
                throw new RuntimeException("Invalid env");
        }
    }
}

