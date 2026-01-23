package com.practice.TestCases;

import java.io.File;
import java.time.Duration;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.practice.Utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base
{
    //Nagendra
    public WebDriver driver;
    public ConfigReader configReader = new ConfigReader();

    public String browser = configReader.getBrowser().toLowerCase();
    public String baseURL = configReader.getBaseURL().toLowerCase();

    @BeforeClass
    public void setUP()
    {
        // logger = LogManager.getLogManager().getLogger("Test Project");
        try
        {
            switch (browser)
            {
                case "chrome": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--incognito");
                    options.addArguments("--disable-save-password-bubble");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--disable-popup-blocking");
                 // Optional: reduce automation banners/noise
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    options.setExperimentalOption("useAutomationExtension", false);                    
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;
                }
                case "firefox": {
                    FirefoxOptions options = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(options);
                    break;
                }
                case "edge": {
                    EdgeOptions options = new EdgeOptions();
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(options);
                    break;
                }
            }
            driver.manage().window().maximize();
            // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(baseURL);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown()
    {
        try
        {
            driver.quit();
        } catch (Exception e)
        {

        }
    }

    public void captureScreenshot(WebDriver driver, String testCaseName)
    {
        try
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testCaseName + ".png");
            FileUtils.copyFile(src, dest);
            // logger.info("Successfully Captured The Screen Shot And Kept At
            // \"Screenshots\" Folder With Name ("+dest+")");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
