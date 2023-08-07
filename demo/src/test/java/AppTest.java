import org.junit.Test;

import config.TestConfig;

import static io.restassured.RestAssured.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestConfig {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void myFirstTest() {
        given()
            .log().all()
        .when()
            .get("quotes")
            // .get("https://dummyjson.com/quotes") // If we didn't have a Base/Config class
            // we would make the request like this
        .then()
            .log().all();
    }
}
