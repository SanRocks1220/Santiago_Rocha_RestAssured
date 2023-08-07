


import org.junit.Test;
import static io.restassured.RestAssured.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void myFirstTest() {
        given()
        .log().all()
        .when()
        .get("https://videogamedb.uk/api/videogame")
        .then()
        .log().all();
    }
}