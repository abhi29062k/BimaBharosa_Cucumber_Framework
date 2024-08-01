Feature: Verify registration functionality

  Background: Verify User is on registration page
    Given User Open URL "https://igmsuat.irdai.gov.in/"
    When User Click on registration button
    Then User redirected to registration page

  Scenario Outline: Verify Policy holder register complaint against Insurance Company
    When User enter name "<Name>"
    And User enter mobile no "<MobileNo>"
    Then OTP window displayed
    When User enter OTP "<MobileNo>"
    And Click on validate button
    Then Mobile Number field disabled
    When User enter pincode "<PinCode>"
    And Click on district field
    Then District and state auto populated
    When User select complaint against "<Complaint_Against>"
    And User select insurance company name "<Ins_Company_Name>"
    And User select policy type "<Policy_Type>"
    And User select complaint type "<Complaint_Type>"
    And User select complaint description type "<Complaint_Desc_Type>"
    And User select policy number radio button
    And User enter policy number "<Policy_No>"
    And User enter complaint details "<Complaint_Details>"
    And Click on Register button
    And Accept alert window
    Then Complaint registered successfully


    Examples:
      | Name       | MobileNo   | PinCode | Complaint_Against | Ins_Company_Name                         | Policy_Type     | Complaint_Type | Complaint_Desc_Type               | Policy_No   | Complaint_Details                    |
      | Nutan Bhor | 1111111112 | 400097  | Company           | HDFC Ergo General Insurance Company Ltd. | Motor Insurance | Policy Related | Details incomplete in the policy. | 55645577632 | Registering complaint policy related |









