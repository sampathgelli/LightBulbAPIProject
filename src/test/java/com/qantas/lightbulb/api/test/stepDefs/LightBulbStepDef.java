package com.qantas.lightbulb.api.test.stepDefs;

import com.qantas.lightbulb.api.test.steps.LightBulbSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class LightBulbStepDef extends GenericDeclarationClass {

    @Steps
    LightBulbSteps geoCodeSteps;

    @Given("^I have an \"([^\"]*)\"$")
    public void i_have_an_something(String address) throws Throwable {
        //geoCodeSteps.saveAddress(address);
        throw new PendingException();
    }

    @When("^I request google api for geocode with address$")
    public void i_request_google_api_for_geocode_with_address() throws Throwable {
        //geoCodeSteps.requestGeoCodeWithAddress();
        throw new PendingException();
    }

    @Given("^I have username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void i_have_username_as_something_and_password_as_something(String userName, String password) throws Throwable {
        //throw new PendingException();
        geoCodeSteps.saveAddress(userName, password);

    }

    @Then("^I should get response \"([^\"]*)\"$")
    public void i_should_get_response_something(String statuscode) throws Throwable {
        geoCodeSteps.saveResponseCode(Integer.parseInt(statuscode));
        geoCodeSteps.getStatusCode();
    }

    @Given("^lightbulb application url$")
    public void lightbulb_application_url() throws Throwable {
        geoCodeSteps.getApplicationAddress();
    }

    @When("^user request to switch \"([^\"]*)\"$")
    public void user_request_to_switch_something(String state) throws Throwable {
        geoCodeSteps.requestBulbWithStatus(state);
    }

    @When("^user request to switch \"([^\"]*)\" and power as \"(\\d+)\"$")
    public void user_request_to_switch_something(String state, int power) throws Throwable {
        geoCodeSteps.requestBulbWithPower(state, power);
    }

    @And("^Result should be \"([^\"]*)\"$")
    public void result_should_be_something(String result) throws Throwable {
       // throw new PendingException();
        geoCodeSteps.validateResult(result);
    }
}
