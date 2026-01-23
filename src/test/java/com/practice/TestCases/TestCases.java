package com.practice.TestCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.Pages.AccountCreatedPage;
import com.practice.Pages.HomePage;
import com.practice.Pages.LoginPage;
import com.practice.Pages.SignUPorLoginPage;
import com.practice.Pages.SignUpPage;
import com.practice.Utilities.MyTestListener;

public class TestCases extends Base
{
    HomePage homePage;
    SignUPorLoginPage signupOrLoginPage;
    SignUpPage signUpPage;
    AccountCreatedPage accountCreatedPage;
    LoginPage loginPage;
    

    String expected_HomePage_Title = "Automation Exercise";
    String expected_SignUporLoginPage_Title = "Automation Exercise - Signup / Login";
    String expected_SignUpPage_Title = "Automation Exercise - Signup";

    @BeforeMethod
    public void initPages()
    {
        try
        {
            homePage = new HomePage(driver);
            signupOrLoginPage = new SignUPorLoginPage(driver);
            signUpPage = new SignUpPage(driver);
            accountCreatedPage= new AccountCreatedPage(driver);
            loginPage=new LoginPage(driver);
        } catch (Exception e)
        {

        }
    }

    @Test
    public void TC001_Register_User()
    {
        Random random = new Random();
        long randomNumber = 1000000000L+(long)(random.nextDouble() * 9000000000L);
        String email="nagendra-"+randomNumber+"-@nag.com";
        String password="myPassword";
      
        System.out.println("Email Address : "+email);
        System.out.println("Password      : "+password);
        
        try
        {
            // Home Page
            if (!homePage.getPageTitle().equals(expected_HomePage_Title))
            {
                captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
            }
            Assert.assertEquals(homePage.getPageTitle(), expected_HomePage_Title, "Home Page Title Mismatch");
            homePage.click_singUpOrLogin_Link();

            // SignUp or Login Page
            if (!signupOrLoginPage.getPageTitle().equals(expected_SignUporLoginPage_Title))
            {
                captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
            }
            Assert.assertEquals(signupOrLoginPage.getPageTitle(), expected_SignUporLoginPage_Title, "Signup / Login Page Title Mismatch");

            // Enter Details In New User SignUp! Section
            signupOrLoginPage.fillDataIn_signupForm_Name_TextBox("Nagendra");

            signupOrLoginPage.fillDataIn_signupForm_EmailAddress_TextBox(email);
            signupOrLoginPage.click_signupForm_Signup_Button();

            // SignUp Page
            if (!signUpPage.getPageTitle().equals(expected_SignUpPage_Title))
            {
                captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
            }
            Assert.assertEquals(signUpPage.getPageTitle(), expected_SignUpPage_Title, "Signup Page Title Mismatch");        
            //System.out.println(signUpPage.getEnter_Account_Information_Section_Header());
            
            if (!signUpPage.getEnter_Account_Information_Section_Header().equals("ENTER ACCOUNT INFORMATION"))
            {
                captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
            }
            Assert.assertEquals(signUpPage.getEnter_Account_Information_Section_Header(), "ENTER ACCOUNT INFORMATION", "Signup Page Title Mismatch");
            
            //Entering Data In - Enter Account Information Section
            signUpPage.click_enterAccountInformationSection_Mr_RadioButton();
            //signUpPage.click_enterAccountInformationSection_Mrs_RadioButton();
            signUpPage.fillDataIn_enterAccountInformationSection_Password_TextBox(password);
            signUpPage.select_enterAccountInformationSection_DOB_Days_DropDown("2");
            signUpPage.select_enterAccountInformationSection_DOB_Month_DropDown("July");
            signUpPage.select_enterAccountInformationSection_DOB_Years_DropDown("1977");
            signUpPage.click_enterAccountInformationSection_SignUpForNewsLetter_CheckBox();
            signUpPage.click_enterAccountInformationSection_ReceiveSpecialOffers_CheckBox();            
            //Entering Data In - Address Information Section            
            signUpPage.fillDataIn_addressInformationSection_FirstName_TextBox("Nagendra Prasad");
            signUpPage.fillDataIn_addressInformationSection_LastName_TextBox("Chitikina");
            signUpPage.fillDataIn_addressInformationSection_Company_TextBox("DXC");
            signUpPage.fillDataIn_addressInformationSection_Address_TextBox("Narayanapuram");
            signUpPage.fillDataIn_addressInformationSection_Address2_TextBox("Rajahmundry");
            signUpPage.select_addressInformationSection_Country_DropDown("India");
            signUpPage.fillDataIn_addressInformationSection_State_TextBox("Andhra Pradesh");
            signUpPage.fillDataIn_addressInformationSection_City_TextBox("Rajahmundry");
            signUpPage.fillDataIn_addressInformationSection_ZipCode_TextBox("533103");
            signUpPage.fillDataIn_addressInformationSection_MobileNumber_TextBox("1234567890");            
            signUpPage.click_createAccount_Button();         
            
            String accountCreatedpageHeader = accountCreatedPage.getPageTitle();           
            if (!accountCreatedPage.getPageTitle().equals("Automation Exercise - Account Created"))
            {
                captureScreenshot(driver, Thread.currentThread().getStackTrace()[1].getMethodName());
            }
            Assert.assertEquals(accountCreatedPage.getPageTitle(), "Automation Exercise - Account Created", "Account Created Page Title Mismatch\n");            
            accountCreatedPage.click_continue_Button();
            
            System.out.println("Successfully Logged In Message : "+loginPage.loggedInUserMessage());
            
            System.out.println("Welcome Message = "+driver.findElement(By.xpath("//header[@id=\"header\"]//li[1]")).getText());
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
