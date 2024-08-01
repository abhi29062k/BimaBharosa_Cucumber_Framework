package com.bimabharosa.objectRepository;

import com.bimabharosa.base.BaseClass;
import com.bimabharosa.base.CommonMethods;
import com.bimabharosa.base.WaitTimeHelper;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpPage extends BaseClass {

    Actions actions;
    @FindBy(xpath = "//button[@id='btnConfirmSuccess']")
    @CacheLookup
    private WebElement acceptAlertWindow;

    @FindBy(xpath = "//button[@id='btnConfirmCancel']")
    @CacheLookup
    private WebElement dismissAlertWindow;

    @FindBy(id = "Acknowladgepopupclose")
    @CacheLookup
    private WebElement ackPopUp;

    @FindBy(xpath = "//p[text()='Complaint Registered Successfully.']")
    @CacheLookup
    private WebElement registrationMsg;

    @FindBy(id = "lblTokenNumber")
    @CacheLookup
    private WebElement complaintNumber;

    @FindBy(xpath = "//button[@id='btnwarningModal']")
    @CacheLookup
    private WebElement warningBtn;

    @FindBy(id = "warningMessage")
    @CacheLookup
    private WebElement warningMessage;

    @FindBy(id = "successMessage")
    @CacheLookup
    private WebElement fileUpload_msg;

    @FindBy(xpath = "//button[@id='btnsuccessModal']")
    @CacheLookup
    private WebElement fileUpload_success_btn;

    @FindBy(id = "ConfirmationMessage")
    @CacheLookup
    private WebElement confirmation_message;

    @FindBy(id = "btnsuccessModal")
    @CacheLookup
    private WebElement complaint_updated_success_btn;

    @FindBy(xpath = "//h4[@id='successMessage']")
    @CacheLookup
    private WebElement complaint_updated_success_msg;



    public PopUpPage() {
        PageFactory.initElements(driver, this);
    }

    public void acceptAlertWindow(){
        CommonMethods.javascript_click(acceptAlertWindow);
    }

    public void ackPopupClk(){
        try{
            ackPopUp.click();
        }
        catch (NoSuchElementException e){

        }
    }

    /* Validation Methods*/
    public String verifyMessage(){
        try{
            WaitTimeHelper.visibilityOfElementExplicitWait(registrationMsg, 3);
            String success_msg = registrationMsg.getText();;
            return success_msg;
        }
        catch (NoSuchElementException e){

        }
        return null;
    }

}
