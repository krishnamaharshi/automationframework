package com.TestFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class BaseTest {

    public WebDriver driver=null;


    @BeforeTest
    public void setup()throws Exception{
        String chromeDriverPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"drivers";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath+File.separator+"chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().maximize();

        Thread.sleep(2000);

    }

    @AfterTest
    public void tearDown(){
//        if(driver!=null){
//            driver.quit();
//        }
    }
}
