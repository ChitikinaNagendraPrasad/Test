package com.practice.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Rough
{
    @DataProvider(name="loginTestData")
    public Object[][] loginData()
    {
        return new Object[][]
                {
            {"abc@abc.com","firstPassword"},
            {"mno@abc.com","secondPassword"}
                };
    }
    
    
    @Test(dataProvider="loginTestData")
    public void displayValues(String un, String pwd)
    {
        System.out.println("User Name : "+un);
        System.out.println("Password  : "+pwd);
    }
}
