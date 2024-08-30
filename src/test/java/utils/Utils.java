package utils;

import com.github.javafaker.Faker;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import setup.UserModel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void setEnvVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key, value);
        config.save();
    }

    public static int generateRandomId(int min, int max){
        double random = Math.random()*(max-min)+min;
        int randId = (int) random;
        return randId;
    }

    public static UserModel generateRandomInfo(String role) throws IOException {
        Faker faker = new Faker();
        UserModel model = new UserModel();

        model.setName(faker.name().fullName());
        model.setEmail(faker.internet().emailAddress().toLowerCase());
//        String[] names = model.getName().split(" ");
//        model.setEmail(names[0].toLowerCase() + "." + names[1].toLowerCase() + "@gmail.com");
        model.setPassword("P@ssword123");
        String phoneNumber = "01502" + generateRandomId(100000, 999999);
        model.setPhone_number(phoneNumber);
        model.setNid(String.valueOf(Utils.generateRandomId(100000000, 999999999)));
        model.setRole(role);

//        System.out.println(model.getName());
//        System.out.println(model.getEmail());
//        System.out.println(model.getPassword());
//        System.out.println(model.getPhone_number());
//        System.out.println(model.getNid());
//        System.out.println(model.getRole());

        return model;
    }

    public static JSONArray readJSON() throws IOException, ParseException {
        String filePath = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray userArr = (JSONArray) jsonParser.parse(new FileReader(filePath));
        return userArr;
    }

    public static void writeJSON(JSONArray userArr) throws IOException, ParseException {
        String filePath = "./src/test/resources/users.json";
        FileWriter writer = new FileWriter(filePath);

        writer.write(userArr.toJSONString());
        writer.flush();
    }

    public static void saveUser(UserModel model) throws IOException, ParseException {
        JSONArray userArr = readJSON();

        JSONObject userObj = new JSONObject();
        userObj.put("name", model.getName());
        userObj.put("email", model.getEmail());
        userObj.put("password", model.getPassword());
        userObj.put("phone_number", model.getPhone_number());
        userObj.put("nid", model.getNid());
        userObj.put("role", model.getRole());

        userArr.add(userObj);

        writeJSON(userArr);
    }
}
