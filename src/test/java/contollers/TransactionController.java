package contollers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import setup.Setup;
import setup.TransactionModel;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TransactionController extends Setup {
    public TransactionController() throws IOException {
        initConfigFile();
    }

    public JsonPath depositToUser(String from_account, String to_account, int amount) {
        TransactionModel model = new TransactionModel();
        model.setFrom_account(from_account);
        model.setTo_account(to_account);
        model.setAmount(amount);

        RestAssured.baseURI = prop.getProperty("baseURI");
        Response response = given().contentType("application/json").header("Authorization", "Bearer " + prop.getProperty("token")).header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey")).body(model).when().post("/transaction/deposit");

        return response.jsonPath();
    }

    public JsonPath withdrawMoney(String from_account, String to_account, int amount) {
        TransactionModel model = new TransactionModel();
        model.setFrom_account(from_account);
        model.setTo_account(to_account);
        model.setAmount(amount);

        RestAssured.baseURI = prop.getProperty("baseURI");
        Response response = given().contentType("application/json").header("Authorization", "Bearer " + prop.getProperty("token")).header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey")).body(model).when().post("/transaction/withdraw");

        return response.jsonPath();
    }

    public JsonPath sendMoney(String from_account, String to_account, int amount) {
        TransactionModel model = new TransactionModel();
        model.setFrom_account(from_account);
        model.setTo_account(to_account);
        model.setAmount(amount);

        RestAssured.baseURI = prop.getProperty("baseURI");
        Response response = given().contentType("application/json").header("Authorization", "Bearer " + ((prop.getProperty("token")))).header("X-AUTH-SECRET-KEY", prop.getProperty("partnerKey")).body(model).when().post("/transaction/sendmoney");

        return response.jsonPath();
    }

    public JsonPath checkBalance(String phone_number) {
        RestAssured.baseURI = prop.getProperty("baseURI");

        Response response = given().contentType("application/json").header("Authorization", "Bearer " + prop.getProperty("token")).header("X-AUTH-SECRET-KEY", prop
                .getProperty("partnerKey")).get("/transaction/balance/" + phone_number);

        return response.jsonPath();
    }
}
