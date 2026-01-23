package com.practice.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader
{
    Properties props= new Properties();
    FileInputStream fis ;
    public ConfigReader()
    {
        try
        {
            fis=new FileInputStream(System.getProperty("user.dir")+"\\Config\\config.properties");
            props.load(fis);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String getProperty(String configKey)
    {
        String returnValue=null;
        try
        { 
            returnValue=props.getProperty(configKey);
        }
        catch(Exception e)
        {
            
        }
        return returnValue;
    }
    
    public String getBrowser()
    {
        String returnValue=null;
        try
        { 
            returnValue=props.getProperty("browser");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public String getBaseURL()
    {
        String returnValue=null;
        try
        { 
            returnValue=props.getProperty("baseURL");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
}
