import org.junit.Test;

import config.TestConfig;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestConfig {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void getRequestTest() {
        String TODOS_ENDPOINT = "{todoId}";

        given()
            .pathParam("todoId", "3")
        .when()
            .get(TODOS_ENDPOINT)
            // .get("https://dummyjson.com/todos/3")
        .then()
            .statusCode(200)
            .body("id", equalTo(3))
            .body("todo", startsWith("Watch"))
            .body("completed", equalTo(false))
            .body("userId", is(4))
            .body(matchesJsonSchemaInClasspath("schema.json"));
    }

    @Test
    public void postRequestTest() {
        String TODOS_ENDPOINT = "{todoId}";

        String todoJson = "{"+
            "\"todo\": \"Build a Lego Set\"," +
            "\"completed\": true," +
            "\"userId\": 15" +
            "}";

        given()
            .pathParam("todoId", "add")
            .contentType("application/json")
            .body(todoJson)
        .when()
            .post(TODOS_ENDPOINT)
            // .post("https://dummyjson.com/todos/add")
        .then()
            .statusCode(200)
            .body("id", equalTo(151))
            .body("todo", equalTo("Build a Lego Set"))
            .body("completed", equalTo(true))
            .body("userId", equalTo(15));
    }

    @Test
    public void putRequestTest() {
        String TODOS_ENDPOINT = "{todoId}";

        String todoJson = "{"+
            "\"todo\": \"Watch a horror movie\"," +
            "\"completed\": true," +
            "\"userId\": 4" +
            "}";

        given()
            .pathParam("todoId", "3")
            .contentType("application/json")
            .body(todoJson)
        .when()
            .put(TODOS_ENDPOINT)
            // .put("https://dummyjson.com/todos/3")
        .then()
            .statusCode(200)
            .body("id", equalTo(3))
            .body("todo", startsWith("Watch a horror"))
            .body("completed", equalTo(true))
            .body("userId", equalTo(4));
    }

    @Test
    public void deleteRequestTest() {
        String TODOS_ENDPOINT = "{todoId}";

        given()
            .pathParam("todoId", 3)
        .when()
            .delete(TODOS_ENDPOINT)
            // .put("https://dummyjson.com/todos/3")
        .then()
            .statusCode(200);
    }
}
