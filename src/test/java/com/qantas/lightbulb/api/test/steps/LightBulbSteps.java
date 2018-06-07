package com.qantas.lightbulb.api.test.steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.core.IsEqual.equalTo;
//import static net.serenitybdd.rest.SerenityRest.config;
//import static io.restassured.config.Config;

public class LightBulbSteps extends ScenarioSteps {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    //String baseUrl = variables.getProperty("BASE_URL");
    //String ctxPath = baseUrl+variables.getProperty("CTX_URL");

    @Step
    public void saveAddress(String userName, String password){
        Serenity.getCurrentSession().put("strUserName", userName);
        Serenity.getCurrentSession().put("strPassword", password);
    }

    @Step
    public void getApplicationAddress(){
        Serenity.getCurrentSession().put("strBasePath",variables.getProperty("BASE_URL"));
        Serenity.getCurrentSession().put("strContextPath",variables.getProperty("CTX_URL"));
    }

    @Step
    public void requestBulbWithStatus(String strStatus ){


        Map<String, String> paramBody = new HashMap<String, String>();
        config = config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        Map<String, String> paramHeaders = new HashMap<String, String>();
        paramHeaders.put("Content-Type", "application/json");
        paramHeaders.put("userid", "19c62a32-d4de-b331-3103-ca25c17d720b");
        SerenityRest.given()
                .headers(paramHeaders)
                .when().post(Serenity.getCurrentSession().get("strBasePath").toString()+Serenity.getCurrentSession().get("strContextPath").toString()+strStatus);
    }

    @Step
    public void requestBulbWithPower(String strStatus,int intpower ){
        Map<String, String> paramBody = new HashMap<String, String>();
        paramBody.put("power",Integer.toString(intpower));


        config = config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        Map<String, String> paramHeaders = new HashMap<String, String>();
        paramHeaders.put("Content-Type", "application/json");
        paramHeaders.put("userid", "19c62a32-d4de-b331-3103-ca25c17d720b");


        SerenityRest.given()
                .headers(paramHeaders)
                .body(paramBody)
                .when().post(Serenity.getCurrentSession().get("strBasePath").toString()+Serenity.getCurrentSession().get("strContextPath").toString()+strStatus);
    }
    @Step
    public void getStatusCode(){

       // String strToken = SerenityRest.then().extract().body().jsonPath().get(".access_token");

        /*SerenityRest
                .then().assertThat().statusCode((Integer) Serenity.getCurrentSession().get("intResponseCode"));
        System.out.println(SerenityRest.then().extract().body().toString());
        //String strToken = SerenityRest.then().extract().body().jsonPath().get(".access_token");
        String strToken = SerenityRest.then().extract().path(".access_token");
        System.out.println(strToken);
        reports(strToken);*/

        //return SerenityRest.then().extract().statusCode();
        //return SerenityRest.then().extract().body().jsonPath().get(".access_token");
        SerenityRest.then()
                    .assertThat().statusCode(200)
        .extract().body().jsonPath().get("");
    }

    public void saveResponseCode(int responseCode) {
        Serenity.getCurrentSession().put("intResponseCode", responseCode);
    }

    public void validateResult(String result) {
        //SerenityRest.and().body("RestResponse.result.Result",is(result));

        /*SerenityRest.expect().that().statusCode(200)
                .and().body("Result",equalTo(result));*/

        //String s = SerenityRest.then().extract().body().jsonPath().get("Result");
        SerenityRest.then().assertThat().extract().body().jsonPath().get("Result").equals(result);
        //System.out.println(s);
    }
}
