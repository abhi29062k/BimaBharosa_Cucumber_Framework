package com.bimabharosa.stepDefinitions;

import com.bimabharosa.base.BaseClass;
import com.bimabharosa.objectRepository.LoginPage;
import com.bimabharosa.utilities.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.*;

import javax.swing.*;
import java.io.IOException;

public class LoginPageStepDefinition extends BaseClass {


    String initialCaptchaSrc;
    String newCaptchaSrc;

    //Initialize object of LoginPage
    LoginPage lp;


    @Given("User Open URL {string}")
    public void user_open_url(String URL) throws IOException {
        launchBrowser();
        hitURL(URL);
    }

    @When("User click on backToSafety button")
    public void user_click_on_back_to_safety_button() {
        backToSafety();
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws IOException {
        PropertyReader pro = new PropertyReader("./src/main/resources/bimabharosa.properties");
        String expected_loginPageURL = pro.getLoginURL();
        String actual_loginPageURL = driver.getCurrentUrl();
        Assert.assertEquals(expected_loginPageURL, actual_loginPageURL);
    }

    @Then("Buttons should be clickable")
    public void buttons_should_be_clickable() {
        lp = new LoginPage();
        Assert.assertTrue(lp.verifyLoginBtn());
    }

    @Then("Captcha present on the web page")
    public void captcha_present_on_the_web_page() {
        lp = new LoginPage();
        Assert.assertTrue(lp.verifyCaptcha());
    }

    @When("User click on the refresh icon of the captcha")
    public void user_click_on_the_refresh_button_icon_of_the_captcha() {
        lp = new LoginPage();
        initialCaptchaSrc = lp.attributeCaptcha();
        lp.clkRefreshCaptcha();
    }

    @Then("New captcha displayed")
    public void new_captcha_displayed() {
        lp = new LoginPage();
        newCaptchaSrc = lp.attributeCaptcha();
        Assert.assertNotEquals(initialCaptchaSrc, newCaptchaSrc);
    }

    @When("User enter valid userId {string}")
    public void user_enter_valid_user_id(String userId) {
        lp = new LoginPage();
        lp.enterUsername(userId);
    }

    @When("User enter valid password {string}")
    public void user_enter_valid_password(String password) {
        lp = new LoginPage();
        lp.enterPassword(password);
    }

    @When("Click on clear button")
    public void click_on_clear_button() {
        lp = new LoginPage();
        lp.clkClrbtn();
    }

    @Then("All input field should clear")
    public void all_input_field_should_clear() {
        lp = new LoginPage();
        Assert.assertTrue(lp.verifyEmptyField());
    }

    @When("Click on login button")
    public void click_on_login_button() {
        lp = new LoginPage();
        lp.clkLoginbtn();

    }

    @Then("User successfully logged in")
    public void user_successfully_logged_in() {
       String expectedPageTitle = "Dashboard | IRDAI";
       String actualPageTitle = driver.getTitle();
       Assert.assertEquals(expectedPageTitle,actualPageTitle);
    }

    @Then("Error message displayed for empty username {string}")
    public void error_message_displayed_for_empty_username(String username_error) {
        lp = new LoginPage();
        Assert.assertEquals(username_error,lp.getUsernameErrorMsg());
    }

    @Then("Error message displayed for empty password {string}")
    public void error_message_displayed_for_empty_password(String password_error) {
        lp = new LoginPage();
        Assert.assertEquals(password_error,lp.getPasswordErrorMsg());
    }

    @When("User enter invalid userID")
    public void user_enter_invalid_user_id() {
        lp = new LoginPage();
        lp.enterUsername("ABCD");
    }

    @When("User enter valid Captcha")
    public void user_enter_valid_captcha() {
        lp = new LoginPage();
        String str1 = JOptionPane.showInputDialog("Enter Captcha");
        lp.enterCaptcha(str1);
    }

    @Then("Alert pop up displayed with error message {string}")
    public void alert_pop_up_displayed_with_error_message(String expected_error) {
        lp = new LoginPage();
        Assert.assertEquals(expected_error, lp.getTextErrInvalidCredential());
    }
}
