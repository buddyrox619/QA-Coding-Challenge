package com.mobiquity.jsonplaceholder;

import com.mobiquity.jsonplaceholder.config.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.baseURI;

public class BaseAPI {

    protected static Configuration configuration;
    private static Logger logger = LoggerFactory.getLogger(BaseAPI.class);

    @BeforeSuite
    public void beforeAllTests() {

        configuration = getConfiguration();

        baseURI = configuration.baseURI();
        RestAssured.useRelaxedHTTPSValidation();

    }

    public Configuration getConfiguration() {
        return ConfigCache.getOrCreate(Configuration.class);
    }

    public List<String> patternMatches(List<String> emailAddresses, String regexPattern) throws Exception {

        List<String> invalidEmails = new ArrayList<String>();

        try {
            for (String emailAddress : emailAddresses) {

                if (!Pattern.compile(regexPattern)
                        .matcher(emailAddress)
                        .matches()) {

                    invalidEmails.add(emailAddress);

                }

            }

        } catch (Exception e) {
            throw e;
        }

        return invalidEmails;
    }

    public void logInstruction(String instruction) {
        Reporter.log("&bull; " + instruction + "<br/>");
        logger.info(instruction);
    }

}
