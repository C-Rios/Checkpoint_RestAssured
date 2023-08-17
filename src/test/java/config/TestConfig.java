package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.BeforeClass;

public class TestConfig {
    @BeforeClass
    public static void setup(){
        //RestAssured.baseURI = "https://dummyjson.com/";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://dummyjson.com/")
                .setContentType("application/json").build();

    }
}
