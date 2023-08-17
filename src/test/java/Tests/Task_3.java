package Tests;

import config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Task_3 extends TestConfig {
    private final String PRODUCTS_ENDPOINT = "products/{productID}";

    //DELETE REQUEST
    @Test
    public void deleteProduct(){
        String productID = "1";
        given()
        .when()
            .delete(PRODUCTS_ENDPOINT,productID)
        .then().log().all()
                .body("isDeleted", Matchers.equalTo(true))
                .body("deletedOn", Matchers.startsWith("2023-08-"))
                .time(Matchers.lessThan(2000L))
                .statusCode(Matchers.is(200))
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("./productsSchema.json"));
    }
}
