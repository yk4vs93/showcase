package com.example.softproject;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    private Select select;

    @BeforeEach
    public void setUp() {

//        System.setProperty("webdriver.chrome.driver", "/Users/michaelkim/Desktop/chrome/chromedriver");
//        driver = new ChromeDriver();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.statskingdom.com/p_value.html");
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    //[distribution, tail, decimal rounding, sig level ,statics,mean,standard deviation,first check,second check,
    //calculate,back not pressed]

    @Test
    public void baseCase(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Select select1 =  new Select(mainPage.roundingDropBox);
        select1.selectByValue("1");
        sleep();
        mainPage.sigLevel.sendKeys("0.05");
        mainPage.statistic.sendKeys("0.05");
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        mainPage.firstCheckBox.click();
        mainPage.inputSigma.sendKeys(".05");
        mainPage.MeanInput.sendKeys("5");

        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep();
        mainPage.SubmitButton.click();
        sleep();
        WebElement result = driver.findElement(By.xpath("//*[text() = '0']"));
        assertTrue(result.isDisplayed());
    }
    @Test
    //[t -distribution, two tailed , 1 , 0.05 , 0.05 , 5 , .05 ,
    // first box unchecked , second box unchecked, calculate pressed , not back pressed ]
    public void TR1() {

        mainPage.inputSigma.sendKeys(".05");
        mainPage.MeanInput.sendKeys("5");
        select = new Select(mainPage.distribution);
        select.selectByValue("T");
        sleep();
        Select select1 =  new Select(mainPage.roundingDropBox);
        select1.selectByValue("1");
        sleep();
        mainPage.sigLevel.sendKeys("0.05");
        mainPage.statistic.sendKeys("0.05");
        mainPage.firstCheckBox.click();
        sleep();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep();
        mainPage.SubmitButton.click();
        sleep();
        WebElement result = driver.findElement(By.xpath("//*[text() = '1']"));
        assertTrue(result.isDisplayed());
    }
    @Test
    //[f- distribution , two tailed , 1 , 0.05 , 0.05 , 5 , .05 ,
    ///first box unchecked , second box unchecked, calculate pressed , not back pressed ]
    public void TR2(){
        mainPage.inputSigma.sendKeys(".05");
        mainPage.MeanInput.sendKeys("5");
        select = new Select(mainPage.distribution);
        select.selectByValue("F");
        sleep();
        Select select1 =  new Select(mainPage.roundingDropBox);
        select1.selectByValue("1");
        sleep();
        mainPage.sigLevel.sendKeys("0.05");
        mainPage.statistic.sendKeys("0.05");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        mainPage.firstCheckBox.click();
        sleep();
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep();
        mainPage.SubmitButton.click();
        sleep();
        WebElement result = driver.findElement(By.xpath("//*[text() = '0.01']"));
        assertTrue(result.isDisplayed());
    }



    private static void sleep() {
        try {
            Thread.sleep(2000);     // specify milliseconds to wait
        } catch (Exception e) {

        }
    }


//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.click();
//
//        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='main-submenu']"));
//        assertTrue(menuPopup.isDisplayed());
//    }

//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeDeveloperToolsButton.click();
//        mainPage.findYourToolsButton.click();
//
//        WebElement productsList = driver.findElement(By.id("products-page"));
//        assertTrue(productsList.isDisplayed());
//        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
//    }
}
