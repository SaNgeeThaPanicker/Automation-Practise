package com.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    @BeforeMethod
    public void setUp() throws IOException {

        // Load config
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/resources/config/config.properties");
        prop.load(fis);

        // Setup driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open URL
        String url = prop.getProperty("url");
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}