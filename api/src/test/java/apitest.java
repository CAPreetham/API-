import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class apitest
{
    private String path;
    private String validRequest = "{\n" + "  \"username\": \"upskills_admin\",\n"
            + "  \"password\": \"Talent4$$\" \n}";
    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "http://rest-api.upskills.in/api/rest_admin/login";
        path = "/login";
    }

    @Test
    public void createUser() {
        Response response = given()
                .auth()
                .preemptive()
                .basic("required_username", "required_password")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(validRequest)
                .post(path)
                .then().extract().response();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    public static void main (String[] args){
        Response responsePost = given().when().header("Authorization","Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
                .post("http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials");
        responsePost.prettyPrint();
        Assert.assertEquals(responsePost.getStatusCode(),200);


    }

}
