package com.practice.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUPorLoginPage
{
    WebDriver ldriver;
    WebDriverWait wait;
    
    public SignUPorLoginPage(WebDriver rdriver)
    {
        try
        {
            ldriver=rdriver;
            PageFactory.initElements(rdriver,this);
            wait=new WebDriverWait(rdriver, Duration.ofSeconds(10));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String getPageTitle()
    {
        String title=null;
        try
        {
            title=ldriver.getTitle();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return title;
    }
    
    //-----------------------------------------------------------------------
    //Login to your account - Section   
    @FindBy(xpath="//div[@class=\"login-form\"]")
    WebElement loginForm ;
    
    @FindBy(xpath="//input[@data-qa=\"login-email\"]")
    WebElement loginForm_EmailAddress_TextBox;
    
    @FindBy(xpath="//input[@placeholder=\"Password\"]")
    WebElement loginForm_Password_TextBox;
    
    @FindBy(xpath="//button[normalize-space()=\"Login\"]")
    WebElement loginForm_Login_Button;
    
    
    
    //-----------------------------------------------------------------------
    //New User Signup! - Section
    @FindBy(xpath="//div[@class=\"signup-form\"]")
    WebElement signupForm;
        
    @FindBy(xpath="//input[@placeholder=\"Name\"]")
    WebElement signupForm_Name_TextBox;
    
    public void fillDataIn_signupForm_Name_TextBox(String name)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(signupForm_Name_TextBox));
            signupForm_Name_TextBox.clear();
            signupForm_Name_TextBox.sendKeys(name);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FindBy(xpath="//input[@data-qa=\"signup-email\"]")
    WebElement signupForm_EmailAddress_TextBox;
    
    public void fillDataIn_signupForm_EmailAddress_TextBox(String password)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(signupForm_EmailAddress_TextBox));
            signupForm_EmailAddress_TextBox.clear();
            signupForm_EmailAddress_TextBox.sendKeys(password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FindBy(xpath="//button[normalize-space()=\"Signup\"]")
    WebElement signupForm_Signup_Button;
    
    public void click_signupForm_Signup_Button()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(signupForm_Signup_Button));
            signupForm_Signup_Button.click();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
}
