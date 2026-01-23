package com.practice.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage
{
    WebDriver ldriver;
    WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));

    public SignUpPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        wait = new WebDriverWait(rdriver, Duration.ofSeconds(10));
    }

    public String getPageTitle()
    {
        String title = null;
        try
        {
            title = ldriver.getTitle();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return title;
    }

    @FindBy(xpath = "//div[@class=\"login-form\"]")
    WebElement enterAccountInformationSection;

    @FindBy(xpath = "//b[normalize-space()=\"Enter Account Information\"]")
    WebElement enterAccountInformationSection_Header;

    public String getEnter_Account_Information_Section_Header()
    {
        String returnValue = null;
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_Header));
            returnValue = enterAccountInformationSection_Header.getText();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }

    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    WebElement enterAccountInformationSection_Mr_RadioButton;

    public void click_enterAccountInformationSection_Mr_RadioButton()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_Mr_RadioButton));
            enterAccountInformationSection_Mr_RadioButton.click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//input[@id=\"id_gender2\"]")
    WebElement enterAccountInformationSection_Mrs_RadioButton;

    public void click_enterAccountInformationSection_Mrs_RadioButton()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_Mrs_RadioButton));
            enterAccountInformationSection_Mrs_RadioButton.click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //Name, email, password
    
    
    @FindBy(xpath="//input[@id=\"name\"]")
    WebElement enterAccountInformationSection_Name_TextBox;
    
    @FindBy(xpath="//input[@id=\"email\"]")
    WebElement enterAccountInformationSection_Email_TextBox;
    
    @FindBy(xpath="//input[@id=\"password\"]")
    WebElement enterAccountInformationSection_Password_TextBox;
    
    public void fillDataIn_enterAccountInformationSection_Password_TextBox(String password)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_Password_TextBox));
            enterAccountInformationSection_Password_TextBox.clear();
            enterAccountInformationSection_Password_TextBox.sendKeys(password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
    
    @FindBy(xpath="//select[@id=\"days\"]")
    WebElement enterAccountInformationSection_DOB_Days_DropDown;
    public void select_enterAccountInformationSection_DOB_Days_DropDown(String days)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_DOB_Days_DropDown));            
            Select select = new Select(enterAccountInformationSection_DOB_Days_DropDown);
            select.selectByVisibleText(days);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FindBy(xpath="//select[@id=\"months\"]")
    WebElement enterAccountInformationSection_DOB_Months_DropDown;    
    public void select_enterAccountInformationSection_DOB_Month_DropDown(String months)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_DOB_Months_DropDown));            
            Select select = new Select(enterAccountInformationSection_DOB_Months_DropDown);
            select.selectByVisibleText(months);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FindBy(xpath="//select[@id=\"years\"]")
    WebElement enterAccountInformationSection_DOB_Years_DropDown;   
    public void select_enterAccountInformationSection_DOB_Years_DropDown(String years)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_DOB_Years_DropDown));            
            Select select = new Select(enterAccountInformationSection_DOB_Years_DropDown);
            select.selectByVisibleText(years);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FindBy(xpath="//input[@id=\"newsletter\"]")
    WebElement enterAccountInformationSection_SignUpForNewsLetter_CheckBox;    
    public void click_enterAccountInformationSection_SignUpForNewsLetter_CheckBox()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_SignUpForNewsLetter_CheckBox));
            enterAccountInformationSection_SignUpForNewsLetter_CheckBox.click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @FindBy(xpath="//input[@id=\"optin\"]")
    WebElement enterAccountInformationSection_ReceiveSpecialOffers_CheckBox;
    public void click_enterAccountInformationSection_ReceiveSpecialOffers_CheckBox()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(enterAccountInformationSection_ReceiveSpecialOffers_CheckBox));
            enterAccountInformationSection_ReceiveSpecialOffers_CheckBox.click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    //ADDRESS INFORMATION
    
    @FindBy(xpath="//b[normalize-space()=\"Address Information\"]")
    WebElement addressInformationSection_Header;
    
    //FistName, LastName, Company
    
    @FindBy(xpath="//input[@id=\"first_name\"]")
    WebElement addressInformationSection_FirstName_TextBox;    
    public void fillDataIn_addressInformationSection_FirstName_TextBox(String firstName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_FirstName_TextBox));
            addressInformationSection_FirstName_TextBox.clear();
            addressInformationSection_FirstName_TextBox.sendKeys(firstName);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
  
    @FindBy(xpath="//input[@id=\"last_name\"]")
    WebElement addressInformationSection_LastName_TextBox;
    public void fillDataIn_addressInformationSection_LastName_TextBox(String lastName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_LastName_TextBox));
            addressInformationSection_LastName_TextBox.clear();
            addressInformationSection_LastName_TextBox.sendKeys(lastName);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }     
        
    @FindBy(xpath="//input[@id=\"company\"]")
    WebElement addressInformationSection_Company_TextBox;
    public void fillDataIn_addressInformationSection_Company_TextBox(String companyName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_Company_TextBox));
            addressInformationSection_Company_TextBox.clear();
            addressInformationSection_Company_TextBox.sendKeys(companyName);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 
      
    @FindBy(xpath="//input[@id=\"address1\"]")
    WebElement addressInformationSection_Address_TextBox;
    public void fillDataIn_addressInformationSection_Address_TextBox(String address)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_Address_TextBox));
            addressInformationSection_Address_TextBox.clear();
            addressInformationSection_Address_TextBox.sendKeys(address);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }     
    
    
    @FindBy(xpath="//input[@id=\"address2\"]")
    WebElement addressInformationSection_Address2_TextBox;
    public void fillDataIn_addressInformationSection_Address2_TextBox(String address2)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_Address2_TextBox));
            addressInformationSection_Address2_TextBox.clear();
            addressInformationSection_Address2_TextBox.sendKeys(address2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }     
    
    @FindBy(xpath="//select[@id=\"country\"]")
    WebElement addressInformationSection_Country_DropDown;
    public void select_addressInformationSection_Country_DropDown(String countryName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_Country_DropDown));            
            Select select = new Select(addressInformationSection_Country_DropDown);
            select.selectByVisibleText(countryName);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
    
    @FindBy(xpath="//input[@id=\"state\"]")
    WebElement addressInformationSection_State_TextBox;
    public void fillDataIn_addressInformationSection_State_TextBox(String state)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_State_TextBox));
            addressInformationSection_State_TextBox.clear();
            addressInformationSection_State_TextBox.sendKeys(state);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }     
    
    @FindBy(xpath="//input[@id=\"city\"]")
    WebElement addressInformationSection_City_TextBox;
    public void fillDataIn_addressInformationSection_City_TextBox(String city)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_City_TextBox));
            addressInformationSection_City_TextBox.clear();
            addressInformationSection_City_TextBox.sendKeys(city);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 
      
    @FindBy(xpath="//input[@id=\"zipcode\"]")
    WebElement addressInformationSection_ZipCode_TextBox;
    public void fillDataIn_addressInformationSection_ZipCode_TextBox(String zipCode)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_ZipCode_TextBox));
            addressInformationSection_ZipCode_TextBox.clear();
            addressInformationSection_ZipCode_TextBox.sendKeys(zipCode);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
    
    @FindBy(xpath="//input[@id=\"mobile_number\"]")
    WebElement addressInformationSection_MobileNumber_TextBox;  
    public void fillDataIn_addressInformationSection_MobileNumber_TextBox(String mobileNumber)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(addressInformationSection_MobileNumber_TextBox));
            addressInformationSection_MobileNumber_TextBox.clear();
            addressInformationSection_MobileNumber_TextBox.sendKeys(mobileNumber);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }  
    
    @FindBy(xpath="//button[normalize-space()=\"Create Account\"]")
    WebElement createAccount_Button;
    public void click_createAccount_Button()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(createAccount_Button));
            createAccount_Button.click();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
  
  
    
    
    
}
