package com.practice.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage
{
    WebDriver ldriver;
    WebDriverWait wait;
    
    public AccountCreatedPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
        wait= new WebDriverWait(rdriver,Duration.ofSeconds(10));
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
    
    @FindBy(xpath="//b[normalize-space()=\"Account Created!\"]")
    WebElement accountCreated_Header;

    @FindBy(xpath="//a[normalize-space()=\"Continue\"]")
    WebElement continue_Button;
    
    public void click_continue_Button()
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(continue_Button));
            continue_Button.click();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
