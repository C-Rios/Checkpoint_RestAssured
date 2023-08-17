package Tests;

import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Task_1 extends TestConfig {
    private final String PRODUCTS_ENDPOINT = "products/{productID}";

    @Test
    public void getAllProducts(){
        Response response =
                given()
                .when()
                        .get(PRODUCTS_ENDPOINT,"")
                .then().log().all().extract().response();

        //System.out.println(response.print());
    }

    @Test
    public void insertProduct(){
        String productJSON = "{\n" +
                "    \"title\": \"iPhone 19\",\n" +
                "    \"description\": \"An apple mobile which is nothing like apple\",\n" +
                "    \"price\": 1099,\n" +
                "    \"discountPercentage\": 12.96,\n" +
                "    \"rating\": 4.69,\n" +
                "    \"stock\": 94,\n" +
                "    \"brand\": \"Apple\",\n" +
                "    \"category\": \"smartphones\",\n" +
                "    \"thumbnail\": \"https://i.dummyjson.com/data/products/1/thumbnail.jpg\"\n" +
                "}";

        given()
                .body(productJSON)
        .when()
                .post(PRODUCTS_ENDPOINT, "add")
        .then().log().all();
    }

    @Test
    public void updateProduct(){
        String productUpdatedJSON = "{\n" +
                "    \"title\": \"iPhone 19\",\n" +
                "    \"price\": 1099,\n" +
                "    \"rating\": 4.69,\n" +
                "    \"brand\": \"Apple\",\n" +
                "    \"category\": \"smartphones\"\n" +
                "}";
        String productID = "1";

        given()
                .body(productUpdatedJSON)
                .when()
                .put(PRODUCTS_ENDPOINT, productID)
                .then().log().all();
    }

    @Test
    public void deleteProduct(){
        String productID = "1";
        given()
        .when()
            .delete(PRODUCTS_ENDPOINT,productID)
        .then().log().all();
    }
}
