# Project Title: API Automation of a Fintech App, Dmoney, Using REST Assured 

### Project Summary: In this API Automation using Rest Assured project, a flow has been created where Admin can login using valid credentials and perform several CRUD operations for the users. For example, the Admin can create Agent and Customer roles. Later, Agents can deposit money which they got deposited from SYSTEM to Customers. Again, the Customers can withdraw or send money to the other customers or make payments to Merchants. Finally, all the users can check their account balance or statements as well.

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
