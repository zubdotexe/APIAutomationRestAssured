# Project Title: Automation of OrangeHRM Demo Using TestNG 

### Project Summary: OrangeHRM is a Human resource management system that has been automated in this project. The tests for Login module have been automated for both admin and employees created by admin. Then, the employee creation process by admin has been automated and tested by searching newly created employees by their names and employee IDs. Lastly, the Employee module has been tested by automating the setting of gender and blood group of employees through their profiles. 

## Prerequisites  
* JDK 11
* IntelliJ IDEA
* Gradle
* Libraries:
  * Selenium
  * TestNG
  * Allure
  * Rest Assured
  * Apache Commons Configuration
  * Jackson Databind
  * JSON.simple
  * Java Faker

## How to setup the environment?  
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java) and paste it in build.gradle file in the project folder
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/org.testng/testng](https://mvnrepository.com/artifact/org.testng/testng) and paste it in build.gradle file in the project folder
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/io.qameta.allure/allure-testng](https://mvnrepository.com/artifact/io.qameta.allure/allure-testng) and paste it in build.gradle file in the project folder
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/io.rest-assured/rest-assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured) and paste it in build.gradle file in the project folder
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/commons-configuration/commons-configuration](https://mvnrepository.com/artifact/commons-configuration/commons-configuration) and paste it in build.gradle file in the project folder
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind) and paste it in build.gradle file in the project folder
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple](https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple) and paste it in build.gradle file in the project folder
* Copy library name from the Gradle section on [https://mvnrepository.com/artifact/com.github.javafaker/javafaker](https://mvnrepository.com/artifact/com.github.javafaker/javafaker) and paste it in build.gradle file in the project folder
* Click on the gradle icon on IntelliJ IDEA
* Click on the 'Reload All Gradle Projects' icon

## How to run?  
Run the following command in the terminal inside the project directory:  
`gradle clean test`

## How to generate Allure report?  
Run the following command in the terminal inside the project directory:  
* `allure generate allure-results`  
* `allure serve allure-results`

## Output  
### Report 
 ![rest_allure_overviewpng](https://github.com/user-attachments/assets/f00e7307-fb12-4165-9958-370f8bb904b9)
<br>
<br>
![rest_allure_behavior](https://github.com/user-attachments/assets/046d6bc7-557d-48c8-a90e-cc35324c28ce)
<br>
<br>
### Test Cases
Please click the link to view the test cases:  
https://docs.google.com/spreadsheets/d/11Wnky-CMHicVizqBDMaNdL6fwkhhp5focviEeWb6k28/edit?usp=sharing  
