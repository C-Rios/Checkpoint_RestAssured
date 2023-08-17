package Tests;

import config.TestConfig;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class Task_2 extends TestConfig {
    private final String PRODUCTS_ENDPOINT = "products/{productID}";

    //GET REQUEST
    @Test
    public void getAllProducts(){
        /*
        * Data validation:
        * Request and response gets done under 2 seconds
        * Status code is 200
        * The response header is JSON Type
        * */
        given()
        .when()
                .get(PRODUCTS_ENDPOINT,"")
        .then().log().all()
                .time(Matchers.lessThan(2000L))
                .statusCode(Matchers.equalTo(200))
                .contentType(ContentType.JSON);

    }
    //POST REQUEST
    @Test
    public void insertProduct(){
        /*
         * Data validation:
         * ID is 101 (Each post returns a product with the 101 id)
         * The product data is the same in the request and the response (Ex: category, description, etc).
         * Request and response gets done under 2 seconds
         * Status code is 200
         * The response header is JSON Type
         * */
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

    //PUT REQUEST
    @Test
    public void updateProduct(){
        /*
         * Data validation:
         * ID is 1, as that was the indicated product
         * The updated product data is the same in the request and the response (Ex: category, description, etc).
         * Request and response gets done under 2 seconds
         * Status code is 200
         * The response header is JSON Type
         * */
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

    //DELETE REQUEST
    @Test
    public void deleteProduct(){
        /*
        * Data Validation:
        * The confirmation values in the response indicate that the product has been deleted.
        * */
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
