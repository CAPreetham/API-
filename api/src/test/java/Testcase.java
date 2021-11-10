import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Testcase {
    @Test
    public void Auth(){
        Response responsePost = given().when().header("Authorization","Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
                .post("http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials");
        responsePost.prettyPrint();
        Assert.assertEquals(responsePost.getStatusCode(),200);
        //access_token= responsePost.getBody().path("access_token");
    }
    @Test
    //access_token= response.path(access_token);
    public void Login(){
        String payload = "{\n" + "    \"username\" : \"upskills_admin\",\n" + "    \"password\" : \"Talent4$$\"\n"
                + "}";
        Response response = RestAssured.given().auth().oauth2("access_token").header("Content-Type","application/json").body(payload)
                .when().post("http://rest-api.upskills.in/api/rest_admin/login");
        //access_token= response.getBody().path("access_token");
        response.prettyPrint();
        //access_token= response.getBody().path("access_token");
    }
    @Test
    public void Testcase1(){
        Response responseCat= given().when().header("Content-Type","application-json").when().get("http://rest-api.upskills.in/api/rest_admin/categories");
        responseCat.prettyPrint();
        Assert.assertEquals(responseCat.getStatusCode(),200);

    }


}
