package at.cgsit.train.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class DemoResourceTest {

    @Test
    public void testHelloMicroprofileParam() {
        given()
                .when().get("/helloDemo/showMessage")
                .then()
                .statusCode(200)
                .body(is("Hello: QuarkusWifiDevOps")); // Modified line
    }

    @Test
    @Disabled
    public void testDisabled() {
        throw new RuntimeException("");
    }

    @Test
    public void testHelloEchoEndpoint() {

        String testParam = "CHRIS";

        given()
                .when()
                .get("/helloDemo/echo/" + testParam)
                .then()
                .statusCode(200)
                .body(notNullValue());
        // .body(is("Hello [SIRHC]"));
    }


    @Test
    public void testHelloEndpoint() {
        given()
                .when()
                .get("/helloDemo")
                .then()
                .statusCode(200)
                .body(notNullValue());
        // .body(is("Hello helloDemo TEST2"));
    }

}
