package testrunners;

import contollers.UserController;
import io.restassured.path.json.JsonPath;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;
import setup.UserModel;
import utils.Utils;

import java.io.IOException;

public class UserTestRunner extends Setup {

    @Test(priority = 1, description = "Admin logins", enabled = true)
    public void doLogin() throws IOException, ConfigurationException {
        UserController userController = new UserController();
        userController.doLogin("admin@roadtocareer.net", "1234");
    }

    @Test(priority = 2, description = "Admin creates customer 1")
    public void createCustomerOne() throws IOException, ConfigurationException, ParseException {
        UserModel model = Utils.generateRandomInfo("Customer");

        Utils.saveUser(model);

        UserController userController = new UserController();
        JsonPath jsonPath = userController.createUser(model);
        int userId = jsonPath.get("user.id");
        Utils.setEnvVar("userId", String.valueOf(userId));
    }

    @Test(priority = 3, description = "Admin creates customer 2")
    public void createCustomerTwo() throws IOException, ConfigurationException, ParseException {
        UserModel model = Utils.generateRandomInfo("Customer");

        Utils.saveUser(model);

        UserController userController = new UserController();
        JsonPath jsonPath = userController.createUser(model);
        int userId = jsonPath.get("user.id");
        Utils.setEnvVar("userId", String.valueOf(userId));
    }

    @Test(priority = 4, description = "Admin creates agent")
    public void createAgent() throws IOException, ConfigurationException, ParseException {
        UserModel model = Utils.generateRandomInfo("Agent");

        Utils.saveUser(model);

        UserController userController = new UserController();
        JsonPath jsonPath = userController.createUser(model);
        int userId = jsonPath.get("user.id");
        Utils.setEnvVar("userId", String.valueOf(userId));
    }
}