package testrunners;

import contollers.TransactionController;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.io.IOException;

public class TransactionTestRunner {

    String customer1 = "";
    String customer2 = "";

    public String getPhoneNumberOfRole(String role) throws IOException, ParseException {
        JSONArray userArr = Utils.readJSON();

        for(int i = 0; i < userArr.size(); i++) {
            JSONObject userObj = (JSONObject) userArr.get(i);
            if(userObj.get("role").equals(role)) {
                return (String) userObj.get("phone_number");
            }
        }

        return null;
    }

    /*
     * @role is used to find a role
     * @phone_number is used to find a user of the same role but to make sure they are different phone_number is used
     */
    public String getPhoneNumberOfRole(String role, String phone_number) throws IOException, ParseException {
        JSONArray userArr = Utils.readJSON();

        for(int i = 0; i < userArr.size(); i++) {
            JSONObject userObj = (JSONObject) userArr.get(i);
            if(userObj.get("role").equals(role) && !userObj.get("phone_number").equals(phone_number)) {
                return (String) userObj.get("phone_number");
            }
        }

        return null;
    }

    @Test(priority = 1, description = "System deposits money to an agent")
    public void depositToAgent() throws IOException, ParseException {
        TransactionController transactionController = new TransactionController();
        String to_phone_number = getPhoneNumberOfRole("Agent");

        JsonPath jsonPath = transactionController.depositToUser("SYSTEM", to_phone_number, 2000);
        String messageActual = jsonPath.get("message");
        String messageExpected = "Deposit successful";

        System.out.println(messageActual);

        Assert.assertEquals(messageExpected, messageActual);
    }

    @Test(priority = 2, description = "Agent deposits money to a customer")
    public void depositToCustomer() throws IOException, ParseException {
        TransactionController transactionController = new TransactionController();
        String from_phone_number = getPhoneNumberOfRole("Agent");
        customer1 = getPhoneNumberOfRole("Customer");
        String to_phone_number = customer1;

        JsonPath jsonPath = transactionController.depositToUser(from_phone_number, to_phone_number, 1500);
        String messageActual = jsonPath.get("message");
        String messageExpected = "Deposit successful";

        System.out.println(messageActual);

        Assert.assertEquals(messageExpected, messageActual);
    }

    @Test(priority = 3, description = "Customer withdraws money from an agent")
    public void withdrawMoney() throws IOException, ParseException {
        TransactionController transactionController = new TransactionController();
        String from_phone_number = customer1;
        String to_phone_number = getPhoneNumberOfRole("Agent");

        JsonPath jsonPath = transactionController.withdrawMoney(from_phone_number, to_phone_number, 500);
        String messageActual = jsonPath.get("message");
        String messageExpected = "Withdraw successful";

        System.out.println(messageActual);

        Assert.assertEquals(messageExpected, messageActual);
    }

    @Test(priority = 4, description = "Customer sends money to another customer")
    public void sendMoney1() throws IOException, ParseException {
        TransactionController transactionController = new TransactionController();
        String from_phone_number = customer1;
        customer2 = getPhoneNumberOfRole("Customer", customer1);
        String to_phone_number = customer2;

        JsonPath jsonPath = transactionController.sendMoney(from_phone_number, to_phone_number, 500);
        String messageActual = jsonPath.get("message");
        String messageExpected = "Send money successful";

        System.out.println(messageActual);

        Assert.assertEquals(messageExpected, messageActual);
    }

    @Test(priority = 5, description = "Customer makes a payment to merchant")
    public void sendMoney2() throws IOException, ParseException {
        TransactionController transactionController = new TransactionController();
        String from_phone_number = customer2;
        String to_phone_number = "01686606905"; // merchant phone number

        JsonPath jsonPath = transactionController.sendMoney(from_phone_number, to_phone_number, 100);
        String messageActual = jsonPath.get("message");
        String messageExpected = "Send money successful";

        System.out.println(messageActual);

        Assert.assertEquals(messageExpected, messageActual);
    }

    @Test(priority = 6, description = "Customer checks their balance")
    public void checkBalance() throws IOException {
        TransactionController transactionController = new TransactionController();
        String phone_number = customer2;

        JsonPath jsonPath = transactionController.checkBalance(phone_number);
        String messageActual = jsonPath.get("message");
        String messageExpected = "User balance";

        Assert.assertEquals(messageExpected, messageActual);
    }
}
