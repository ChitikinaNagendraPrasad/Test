package com.practice.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
    WebDriver ldriver;
    WebDriverWait wait;
    
    public LoginPage(WebDriver rdriver)
    {
        try
        {
            ldriver=rdriver;
            PageFactory.initElements(rdriver,this);
            wait = new WebDriverWait(rdriver,Duration.ofSeconds(10));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
    
    @FindBy(xpath="//header[@id=\"header\"]//li[1]//a[1]")
    WebElement loggedInAs_Label;
    
    public String loggedInUserMessage()
    {
        String returnValue=null;
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(loggedInAs_Label));
            returnValue=loggedInAs_Label.getText();            
        }
        catch(Exception e)
        {
            
        }        
        return returnValue;
    }
    
    
    
}
