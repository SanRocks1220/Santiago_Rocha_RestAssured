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
        .then()
            .log().all();
    }
}
