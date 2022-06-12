package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RestAssuredGETAndPost {
    @BeforeClass
    public static void Setup()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    // Scenario get All
    @Test
    public void it_should_get_all_comments() {
        Response response = given()
                .when()
                .get("posts/1/comments")
                .then()
                .extract()
                .response();

        System.out.println(response.jsonPath().get("[0].name").toString());
        System.out.println(response.jsonPath().get("[0].email").toString());
        System.out.println(response.jsonPath().get("[0].body").toString());


        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("[0].name");
        String email = jsonPath.getString("[0].email");
        String body = jsonPath.getString("[0].body");
        Assert.assertEquals(name, "id labore ex et quam laborum");
        Assert.assertEquals(email, "Eliseo@gardner.biz");
        Assert.assertEquals(body, "laudantium enim quasi est quidem magnam voluptate ipsam eos"+"\n"+"tempora quo necessitatibus"+"\n"+"dolor quam autem quasi"+"\n"+"reiciendis et nam sapiente accusantium");
    }
    // Scenario get by parameter
    @Test
    public void when_passing_id_then_it_should_only_return_data_for_that_postId() {
        Response response = given()
                .when().
                        queryParam("postId",2)
                .get("comments")
                .then()
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        //id
        String id = jsonPath.getString("id");
        Assert.assertEquals(id, "6");
        //name
        String name = jsonPath.getString("name");
        Assert.assertEquals(name, "et fugit eligendi deleniti quidem qui sint nihil autem");
    }

    // Scenario Post to create
    @Test
    public void it_should_create_new_post() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("{\n" +
                        "    \"postId\": 1,\n" +
                        "    \"name\": \"Jon Doe\",\n" +
                        "    \"email\": \"jon.doe@amazon.com\",\n" +
                        "    \"body\": \"this is jon doe\"\n" +
                        "}")
                .post("comments/")
                .then()
                .extract()
                .response();

        //Assert.assertEquals(response.getStatusCode(), 201);
        response.prettyPrint();

//        JsonPath jsonPath = response.jsonPath();
//        String title = jsonPath.getString("title");
//        String body = jsonPath.getString("body");
//        Assert.assertEquals(title, "abcd");
//        Assert.assertEquals(body, "abce efg");
    }

}
