package test.java.com.eventHubTest.base;
public class baseTest {
    
   @BeforeMethod
    public void setup() {
        RestAssured.baseURI = ConfigManager.getBaseUrl();
    }

}
