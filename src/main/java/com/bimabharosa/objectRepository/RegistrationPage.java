package com.bimabharosa.objectRepository;

import com.bimabharosa.base.BaseClass;
import com.bimabharosa.base.CommonMethods;
import com.bimabharosa.base.WaitTimeHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class RegistrationPage extends BaseClass {


    @FindBy(id = "txtname_individual")
    private WebElement name;

    @FindBy(id = "txtmob_individual")
    private WebElement mobileNumber;

    @FindBy(id = "txtmob_individual-error")
    private WebElement txtmoberror;

    @FindBy(id = "otptxt")
    private WebElement otpWindow;

    @FindBy(id = "txtotp1")
    private WebElement otpemptyfield;

    @FindBy(id = "lnkForgotPass")
    private WebElement resendotpgettxt;

    @FindBy(id = "warningMessage")
    private WebElement otpwarningMessage;

    @FindBy(id = "lblOTP")
    private WebElement PleaseEnteroneTimeOtpgettxt;

    @FindBy (xpath = "//small[text()='Please Enter Six Digit Pin-Code']")
    private WebElement emptypinCodeError;

    @FindBy(xpath = "//small[text()='Please Enter Valid Pin-Code']")
    private WebElement invalidPinCodeError;

    @FindBy (xpath = "//a[text()=' Home ']")
    private WebElement home;

    @FindBy (id ="btnwarningModal")
    private WebElement okbutton;

    @FindBy(id = "txtemailofcompl_individual")
    private WebElement email;

    @FindBy(xpath = "(//*[contains(text(),'E-mail of')])[1]")
    private WebElement emailText;

    @FindBy(id = "txtPinCode")
    private WebElement pinCode;

    @FindBy(id = "txtDistrict")
    private WebElement district;

    @FindBy(id = "txtState")
    private WebElement state;

    @FindBy(xpath = "//div[@id='ddlcomplagainstinsurer_chosen']")
    private WebElement complaint_against_dropdown;

    @FindBy(xpath = "//div[@id='ddlcomplagainstinsurer_chosen']//input[@type='text']")
    private WebElement complaint_against_inputField;

    @FindBy(xpath = "//div[@id='ddlinsurancecomp_chosen']")
    private WebElement insCompanyName_dropdown;

    @FindBy(xpath = "//div[@id='ddlinsurancecomp_chosen']//input[@type='text']")
    private WebElement insCompName_nameField;

    @FindBy(xpath = "//div[@id='ddlpolicytype_chosen']")
    private WebElement policyType_dropdown;

    @FindBy(xpath = "//div[@id='ddlpolicytype_chosen']//input[@type='text']")
    private WebElement policyType_Field;

    @FindBy(xpath = "//div[@id='ddlcomplainttype_chosen']")
    private WebElement complaintType_dropdown;

    //Insurance company fields
    @FindBy(xpath = "//div[@id='ddlcomplainttype_chosen']//input[@type='text']")
    private WebElement complaint_type_field;

    @FindBy(xpath = "//div[@id='ddlcomplaintdesctype_chosen']")
    private WebElement complaintDescType_dropdown;

    @FindBy(xpath = "//div[@id='ddlcomplaintdesctype_chosen']//input[@type='text']")
    private WebElement complaint_desctype_field;

    @FindBy(id = "rdPolicyNumber")
    private WebElement policyNumberRdBtn;

    @FindBy(xpath = "//input[@id='txtPolicyProposalCertifiateClaimNumber']")
    private WebElement policyNumber;

    @FindBy(xpath = "//textarea[@id='txtcompldetails']")
    private WebElement complaintDescription;

    @FindBy(id = "btnsave")
    private WebElement register;

    @FindBy(id = "btncancel")
    private WebElement back;

    @FindBy(id = "btnConfirmSuccess")
    private WebElement btnConfirmSuccess;

    @FindBy(id = "btnConfirmCancel")
    private WebElement btnConfirmCancel;

    @FindBy(id = "Acknowladgepopupclose")
    private WebElement ackPopUp;

    @FindBy(xpath = "//p[text()='Complaint Registered Successfully.']")
    private WebElement registrationMsg;

    @FindBy(xpath = "//span[@id='lblTokenNumber']")
    private WebElement complaintNumber;

    @FindBy(id = "warningMessage")
    private WebElement warningMessage;

    //Unregistered Entity fields
    @FindBy(id = "txtcompname_unregcomp")
    private WebElement unRegCompName;

    @FindBy(id = "txtadd_unregcomp")
    private WebElement unRegCompAddress;

    @FindBy(id = "txtphone_unregcomp")
    private WebElement unRegCompPhNumber;

    @FindBy(id = "txtdesc_unregcomp")
    private WebElement unRegCompDesc;

    @FindBy(id = "txttypeofserv_unregcomp")
    private WebElement unRegCompTypeSvcObtained;

    @FindBy(id = "txtcontpername_unregcomp")
    private WebElement unRegCompContactPersonName;

    //Insurance Intermediary fields
    @FindBy(xpath = "//div[@id='ddlintermediarytype_chosen']")
    private WebElement insIntermediaryType;

    @FindBy(xpath = "//div[@id='ddlintermediarytype_chosen']//input[@type='text']")
    private WebElement insIntermediaryType_inputField;

    @FindBy(xpath = "//div[@id='ddlbrokername_chosen']")
    private WebElement brokerName_dropdown;

    @FindBy(xpath = "//div[@id='ddlbrokername_chosen']//input[@type='text']")
    private WebElement brokerName_inputField;

    @FindBy(xpath = "//button[@id='btnwarningModal']")
    private WebElement duplicateWarningError;

    Actions action;


    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterName(String policyholder_name){
        name.sendKeys(policyholder_name);
    }

    public void enterMobileNumber(String mob){
        mobileNumber.sendKeys(mob);
    }

    public void clkEmailText(){
        emailText.click();
    }

    public void enterPinCode(String pinCode) throws InterruptedException {
        this.pinCode.sendKeys(pinCode);
        action = new Actions(driver);
        action.keyDown(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
    }

    public void clkOnDistrict(){
        try{
            district.click();
        }
        catch (NoSuchElementException e){

        }
    }

    public void select_complaint_Against(String compAgainst) throws InterruptedException {
        try{
            CommonMethods.scrollToDownward();
            action = new Actions(driver);
            complaint_against_dropdown.click();

            complaint_against_inputField.sendKeys(compAgainst);
            action.sendKeys(Keys.ENTER).perform();
        }
        catch(NoSuchElementException e){
            e.printStackTrace();
        }
        catch(ElementNotInteractableException e){
            e.printStackTrace();
        }

    }

    public void select_ins_companyName(String insCompanyName) throws InterruptedException {

        try{
            action = new Actions(driver);
            insCompanyName_dropdown.click();

            insCompName_nameField.sendKeys(insCompanyName);
            action.sendKeys(Keys.ENTER).perform();

        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        catch(ElementNotInteractableException e){
            e.printStackTrace();
        }
    }

    public void select_policy_type(String policyType) throws InterruptedException {

        try{
            action = new Actions(driver);
            policyType_dropdown.click();

            policyType_Field.sendKeys(policyType);
            action.sendKeys(Keys.ENTER).perform();

        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        catch(ElementNotInteractableException e){
            e.printStackTrace();
        }
    }

    public  void select_complaint_type(String compType) throws InterruptedException {
        try{
            action = new Actions(driver);
            complaintType_dropdown.click();

            complaint_type_field.sendKeys(compType);
            action.sendKeys(Keys.ENTER).perform();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        catch(ElementNotInteractableException e){
            e.printStackTrace();
        }
    }

    public void select_complaint_desc_type(String compDescType) throws InterruptedException {
        try{
            action = new Actions(driver);
            complaintDescType_dropdown.click();

            complaint_desctype_field.sendKeys(compDescType);
            action.sendKeys(Keys.ENTER).perform();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        catch(ElementNotInteractableException e){
            e.printStackTrace();
        }
    }

    public void select_policy_number() {
        try{
            policyNumberRdBtn.click();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        catch (ElementNotInteractableException e)
        {
            e.printStackTrace();
        }
    }


    public void enterPolicyNumber(String policy_number) throws InterruptedException {
            try{
                policyNumber.sendKeys(policy_number);
            }
            catch (NoSuchElementException e){
                e.printStackTrace();
            }
            catch (ElementNotInteractableException e)
            {
                e.printStackTrace();
            }
    }


    public void enterCompDesc(String complaintDesc) throws InterruptedException {
        try{
            complaintDescription.sendKeys(complaintDesc);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        catch (ElementNotInteractableException e)
        {
            e.printStackTrace();
        }

    }

    public void clkOnRegister() throws InterruptedException {
        try{
            register.click();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }
        catch (ElementNotInteractableException e)
        {
            e.printStackTrace();
        }

    }




    //Validation methods
    public boolean verifyOTPWindow(){
        WaitTimeHelper.visibilityOfElementExplicitWait(otpWindow,10);
        return otpWindow.isDisplayed();
    }

    public boolean verifyMobileNumberField_Disabled(){
        return mobileNumber.isEnabled();
    }

    public boolean verifyDistrictAndStatePopulated(){
        String dist = district.getAttribute("value");
        String st = state.getAttribute("value");

        return !dist.isEmpty() && !st.isEmpty();
    }

}
