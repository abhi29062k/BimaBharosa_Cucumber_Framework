package com.bimabharosa.stepDefinitions;

import com.bimabharosa.base.BaseClass;
import com.bimabharosa.objectRepository.HomePage;
import com.bimabharosa.objectRepository.PopUpPage;
import com.bimabharosa.objectRepository.RegistrationPage;
import com.bimabharosa.utilities.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;


public class RegistrationStepDefinition extends BaseClass{

    HomePage h;
    RegistrationPage rg;
    PopUpPage pg;


    @When("User Click on registration button")
    public void user_click_on_registration_button() {
        h = new HomePage();
        h.clkRegister();
    }

    @Then("User redirected to registration page")
    public void user_redirected_to_registration_page() throws IOException {
        PropertyReader pro = new PropertyReader("./src/main/resources/bimabharosa.properties");
        String expectedURL = pro.getRegisterURL();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @When("User enter name {string}")
    public void user_enter_name(String name) {
        rg = new RegistrationPage();
        rg.enterName(name);
    }

    @When("User enter mobile no {string}")
    public void user_enter_mobile_no(String mobileNo) {
        rg.enterMobileNumber(mobileNo);
    }

    @And("OTP window displayed")
    public void otp_window_displayed() {
        rg.clkEmailText();
        Assert.assertTrue(rg.verifyOTPWindow());
    }

    @When("User enter OTP {string}")
    public void user_enter_otp(String mobileNo) {
        h.enterOTP(mobileNo);
    }

    @When("Click on validate button")
    public void click_on_validate_button() {
        h.clickOnValidate();
    }

    @Then("Mobile Number field disabled")
    public void mobile_number_field_disabled() {
        Assert.assertFalse(rg.verifyMobileNumberField_Disabled());
    }

    @When("User enter pincode {string}")
    public void user_enter_pincode(String pinCode) throws InterruptedException {
        rg.enterPinCode(pinCode);
    }

    @When("Click on district field")
    public void click_on_district_field() {
        rg.clkOnDistrict();
    }

    @Then("District and state auto populated")
    public void district_and_state_auto_populated() {
        Assert.assertTrue(rg.verifyDistrictAndStatePopulated());
    }

    @When("User select complaint against {string}")
    public void user_select_complaint_against(String complaint_against) throws InterruptedException {
       rg.select_complaint_Against(complaint_against);
    }

    @When("User select insurance company name {string}")
    public void user_select_insurance_company_name(String ins_comp_name) throws InterruptedException {
        rg.select_ins_companyName(ins_comp_name);
    }

    @When("User select policy type {string}")
    public void user_select_policy_type(String policy_type) throws InterruptedException {
        rg.select_policy_type(policy_type);
    }

    @When("User select complaint type {string}")
    public void user_select_complaint_type(String complaint_type) throws InterruptedException {
        rg.select_complaint_type(complaint_type);
    }

    @When("User select complaint description type {string}")
    public void user_select_complaint_description_type(String complaint_desc_type) throws InterruptedException {
        rg.select_complaint_desc_type(complaint_desc_type);
    }

    @When("User select policy number radio button")
    public void user_select_policy_number_radio_button() {
        rg.select_policy_number();
    }

    @When("User enter policy number {string}")
    public void user_enter_policy_number(String policy_number) throws InterruptedException {
        rg.enterPolicyNumber(policy_number);
    }

    @When("User enter complaint details {string}")
    public void user_enter_complaint_details(String complaint_details) throws InterruptedException {
        rg.enterCompDesc(complaint_details);
    }

    @When("Click on Register button")
    public void click_on_register_button() throws InterruptedException {
        rg.clkOnRegister();
    }

    @When("Accept alert window")
    public void accept_alert_window() {
        pg = new PopUpPage();
        pg.acceptAlertWindow();
    }

    @Then("Complaint registered successfully")
    public void complaint_registered_successfully() {
        String expected_msg = "Complaint Registered Successfully.";
        String actual_msg = pg.verifyMessage();
        Assert.assertEquals(expected_msg,actual_msg);
    }

}





