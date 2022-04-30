# QA-Assignement

Automation tool/framework used: **RestAssured**     
Programming Language: **Java *(Assignment Choice of Programming language)***
Build Tool: **Maven**
Library's used: **RestAssured (For Rest API's),TestNG (Support Test Creation),Lombok(For clean code),owner (To manage Configurations),log4J/SLF4J (Logging purpose)**  

### A comprehesive test summary report including *test-cases, execution status, testing strategy, bug report, reccomendations* and more details can be found in the report linked below:

***[Test Summary Report Link](https://docs.google.com/document/)***

## Required software
* Java JDK 8+
* Maven installed and in your classpath

## How to execute the tests
You can open each test class on `src\test\java` and execute all of them, but I recommend you run it by the
command line.

### Running the test suites

The test suites can be run directly by your IDE or by command line.
If you run `mvn test -DsuiteXmlFile="RegressionTest.xml"` all the tests will execute.

| regretion tests | `mvn test -DsuiteXmlFile="RegressionTest.xml"` |

## How to view test reports
This project uses SureFire Report to automatically generate the test report.You can view the report in `target\surefire-reports\index.html` 
Alure reporting has been implemented there for you can use belove command line to genarate the report 
    * `mvn allure:report`: will generate the HTML port at `target/site/allure-maven-plugin` folder
    
## About the Project Structure

### src/main/java

#### test
Base Test that sets the initial aspects to make the requests using RestAssured.


#### config
The class `Configuration` is the connections between the property file `configuration.properties` located in `src/test/resources/`.
This also holds the relative url's in RelativeURI.java

#### model
Model and Builder class to mapping objects thought serialization and deserialization
in use with Rest-Assured.

### src/test/java

#### e2e
End to End test using both endpoints to simulate the user journey thought the API.

#### comments
Contract and Functional tests to the Simulations comments endpoint 

#### posts
Contract and Functional tests to the Simulations posts endpoint 

#### user
Contract and Functional tests to the Simulations user endpoint 

### src/test/resources
It has a `schemas` folder with the JSON Schemas to enable Contract Testing using Rest-Assured.Also testng suite xml files and the properties files (configuration & log4J).

    
## Things to highlight
    1. Builder, Base Test, Request and Responce Specification patterns applied
    2. Dynamic Test data, manage through TestNG parameters to ease the maintainability.
    3. Increase maintainability and increase readability
    
