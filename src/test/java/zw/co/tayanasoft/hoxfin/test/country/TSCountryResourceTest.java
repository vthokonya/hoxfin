package zw.co.tayanasoft.hoxfin.test.country;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import zw.co.tayanasoft.hoxfin.service.TSCountryResource;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(TSCountryResource.class)
public class TSCountryResourceTest {
    @Test
    public void testGetAllCountriesEndpoint(){
        when().get().then().statusCode(200).body(is("[]"));
    }

    @Test
    public void testAddCountryEndpoint(){
        given().body("{\"countryCode\": \"ZW\", \"countryName\": \"Zimbabwe\"}")
                .header("Content-Type", "application/json")
                .when()
                .post()
                .then()
                .statusCode(200);

        given().when().get()
                .then()
                .statusCode(200)
                .body("$.size()", is(1),
                        "[0].countryCode", is("ZW"),
                        "[0].countryName", is("Zimbabwe"));
    }
}
