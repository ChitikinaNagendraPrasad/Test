package com.practice.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{    
    WebDriver ldriver;
    WebDriverWait wait;
        
    public HomePage(WebDriver rdriver)
    {
        ldriver=rdriver;        
        PageFactory.initElements(rdriver,this);
        wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
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
    
    @FindBy(xpath="//a[normalize-space()=\"Signup / Login\"]")
    WebElement singUpOrLogin_Link;    
    public void click_singUpOrLogin_Link()
    {      
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(singUpOrLogin_Link)).click();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
