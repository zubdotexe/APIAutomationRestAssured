package contollers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import setup.Setup;
import setup.UserModel;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserController extends Setup {

    public UserController() throws IOException {
        initConfigFile();
    }

    public void doLogin(String email, String password) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("baseURI");

        UserModel model = new UserModel();
        model.setEmail(email);
        model.setPassword(password);

        Response response = given().contentType("application/json").body(model).post("/user/login");
        System.out.println(response.asString());

        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("token");

        Utils.setEnvVar("token", token);
    }

    public JsonPath createUser(UserModel model) throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("baseURI");
        Response res = given().contentType("application/json")
                .header("Authorization", "Bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey"))
                .body(model)
                .when().post("/user/create");
        System.out.println(res.asString());
        return res.jsonPath();
    }
}
