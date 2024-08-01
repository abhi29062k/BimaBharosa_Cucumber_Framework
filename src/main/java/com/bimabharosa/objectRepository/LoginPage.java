package com.bimabharosa.objectRepository;

import com.bimabharosa.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    static Actions action;
    @FindBy(id = "txtusername")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "txtpassword")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement loginbtn;

    @FindBy(id = "btnclear")
    @CacheLookup
    private WebElement clrbtn;

    @FindBy(id = "captchacode")
    @CacheLookup
    private WebElement cptcha;

    @FindBy(xpath = "//img[@id='m_imgCaptcha']")
    @CacheLookup
    private WebElement captchaText;

    @FindBy(id = "imgRefreshCaptcha")
    @CacheLookup
    private WebElement refreshctcha;

    @FindBy(id = "langDropdown_chosen")
    @CacheLookup
    private WebElement languageDropdown;

    @FindBy(xpath = "//label[@id='txtusername-error']")
    @CacheLookup
    private WebElement errorUsername;

    @FindBy(xpath = "//label[@id='txtpassword-error']")
    @CacheLookup
    private WebElement errorPassword;

    @FindBy(xpath = "//*[@id='warningMessage']")
    @CacheLookup
    private WebElement errorInvalidCredential;

    @FindBy(xpath = "//*[@id='warningMessage']")
    @CacheLookup
    private WebElement errInvalidCaptcha;

    @FindBy(xpath = "//*[@id='captchacode-error']")
    @CacheLookup
    private WebElement errorCaptcha;

    @FindBy(xpath = "//label[@id='label_English']")
    @CacheLookup
    private WebElement englishVerify;

    @FindBy(xpath = "//label[@id='label_Hindi']")
    @CacheLookup
    private WebElement hindiVerify;

    @FindBy(xpath = "//button[@id='btnwarningModal']")
    @CacheLookup
    private WebElement okPOPUP;

    @FindBy(xpath = "(//*[contains(text(),'View / Edit')])[2]")
    @CacheLookup
    private WebElement ViewEdit;

    @FindBy(xpath = "//button[@id='Logout']")
    @CacheLookup
    private WebElement logoutBtn;

    @FindBy(xpath = "//button[@id='btnConfirmSuccess']")
    @CacheLookup
    private WebElement logOffSuccess;

    @FindBy(id = "btnConfirmCancel")
    @CacheLookup
    private static WebElement logOffCancel;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean displayLoginBtn() {

        loginbtn.isDisplayed();

        return loginbtn.isDisplayed();

    }

    public void logOutSuccess() throws InterruptedException {
        try{
            logoutBtn.click();
            Thread.sleep(1000);
            logOffSuccess.click();
        }
        catch (NoSuchElementException e){

        }
    }

    public void logOutCancel() throws InterruptedException {
        try{
            logoutBtn.click();
            Thread.sleep(1000);
            logOffCancel.click();
        }
        catch (NoSuchElementException e){

        }
    }

    public void enterUsername(String usrname) {
        username.sendKeys(usrname);
    }

    public void clrUsername() {
        username.clear();
    }

    public void clrPassword() {
        password.clear();
    }

    public void enterPassword(String pwd) {

        password.sendKeys(pwd);
    }

    public void clkLoginbtn() {

        loginbtn.click();
    }

    public void clkClrbtn() {
        clrbtn.click();
    }

    public void enterCaptcha(String captcha) {
        cptcha.sendKeys(captcha);
    }

    public void clrCaptcha() {
        cptcha.clear();
    }

    public void clkRefreshCaptcha() {

        refreshctcha.click();
    }

    public void clkLanguageDropdown() {
        languageDropdown.click();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void clkOK() {
        okPOPUP.click();
    }

    public void UseDownArrowKey() {
        action = new Actions(driver);
        action.keyDown(Keys.ARROW_DOWN).build().perform();
    }

    public void UseUpArrowKey() {
        action = new Actions(driver);
        action.keyUp(Keys.ARROW_UP).build().perform();
    }

    public void UseEnterKey() {
        action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }


    //Getter methods
    public String attributeCaptcha() {
        captchaText.getAttribute("src");
        return captchaText.getAttribute("src");
    }

    public String getUsernameErrorMsg(){
        return errorUsername.getText();
    }

    public String getPasswordErrorMsg(){
        return errorPassword.getText();
    }

    public String getTextErrInvalidCredential() {
        return errorInvalidCredential.getText();
    }


    //Validation methods
    public boolean verifyLoginBtn() {
        return loginbtn.isDisplayed() && loginbtn.isEnabled();
    }

    public boolean verifyCaptcha() {
        return captchaText.isDisplayed();
    }

    public boolean verifyEmptyField() {
        String userId = username.getAttribute("value");
        String pass = password.getAttribute("value");
        return userId.isEmpty() && pass.isEmpty();
    }


}
