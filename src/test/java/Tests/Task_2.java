package Tests;

import config.TestConfig;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class Task_2 extends TestConfig {
    private final String PRODUCTS_ENDPOINT = "products/{productID}";

    @Test
    public void getAllProducts(){
        given()
        .when()
                .get(PRODUCTS_ENDPOINT,"")
        .then().log().all()
                .time(Matchers.lessThan(2000L))
                .statusCode(Matchers.equalTo(200))
                .contentType(ContentType.JSON);

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
        .then().log().all()
                .body("id", Matchers.equalTo(101))
                .body("category", Matchers.equalTo("smartphones"))
                .body("description", Matchers.startsWith("An apple"))
                .body("price", Matchers.equalTo(1099))
                .body("stock", Matchers.equalTo(94))
                .body("brand", Matchers.equalTo("Apple"))
                .time(Matchers.lessThan(2000L))
                .statusCode(Matchers.equalTo(200))
                .contentType(ContentType.JSON);
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
        .then().log().all()
                .body("id", Matchers.equalTo(1))
                .body("title", Matchers.equalTo("iPhone 19"))
                .body("price", Matchers.equalTo(1099))
                .body("rating", Matchers.equalTo(4.69f))
                .body("brand", Matchers.isA(String.class))
                .body("category", Matchers.equalTo("smartphones"))
                .time(Matchers.lessThan(2000L))
                .statusCode(Matchers.equalTo(200))
                .contentType(ContentType.JSON);
    }

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
                .statusCode(Matchers.equalTo(200))
                .contentType(ContentType.JSON);
    }
}
