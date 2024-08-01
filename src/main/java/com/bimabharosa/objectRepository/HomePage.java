package com.bimabharosa.objectRepository;

import com.bimabharosa.base.BaseClass;
import com.bimabharosa.base.CommonMethods;
import com.bimabharosa.base.WaitTimeHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement okButton;

    @FindBy(xpath = "(//img[@class='logo-width'])[1]")
    private WebElement bimaBharosa_logo;

    @FindBy(id = "btnRegComplaint")
    private WebElement registerButton;

    @FindBy(id = "txtinput")
    private WebElement mobileNumber;

    @FindBy(xpath = "//*[@id='btnLogin']")
    private WebElement search;

    @FindBy(xpath = "//button[@id='btnotpvalidate']")
    private WebElement OTPSubmitbtn;

    @FindBy(id = "txtotp1")
    private WebElement O1;

    @FindBy(id = "txtotp2")
    private WebElement O2;

    @FindBy(id = "txtotp3")
    private WebElement O3;

    @FindBy(id = "txtotp4")
    private WebElement O4;

    @FindBy(id = "txtotp5")
    private WebElement O5;

    @FindBy(id = "txtotp6")
    private WebElement O6;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clkRegister() {
        //CommonMethods.javascript_click(registerButton, driver);
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", registerButton);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void enterOTP(String Mobile_No) {
        char c[] = Mobile_No.toCharArray();

        //Wait for the OTP window displayed to enter the OTP
        WaitTimeHelper.elementToBeClickableExplicitWait(O1, 60);

        O1.sendKeys(String.valueOf(c[0]));
        O2.sendKeys(String.valueOf(c[1]));
        O3.sendKeys(String.valueOf(c[2]));
        O4.sendKeys(String.valueOf(c[3]));
        O5.sendKeys(String.valueOf(c[4]));
        O6.sendKeys(String.valueOf(c[5]));
    }

    public void clickOnValidate(){
        CommonMethods.javascript_click(OTPSubmitbtn);
    }
}



