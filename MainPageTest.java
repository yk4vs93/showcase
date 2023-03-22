package com.example.softproject;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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
        //driver.quit();
    }


    //[distribution, tail, decimal rounding, sig level ,statics,mean,standard deviation,first check,second check,
    //calculate,back not pressed]

    @Test
    public void baseCase(){
        Select select1 =  new Select(mainPage.roundingDropBox);
        select1.selectByValue("1");
        sleep();
        mainPage.sigLevel.sendKeys("0.05");
        mainPage.statistic.sendKeys("0.05");
        mainPage.firstCheckBox.click();
        mainPage.inputSigma.sendKeys(".05");
        mainPage.MeanInput.sendKeys("5");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep();
        mainPage.SubmitButton.click();
        sleep();
    }
    @Test
    //[t -distribution, two tailed , 1 , 0.05 , 0.05 , 5 , .05 ,
    // first box unchecked , second box unchecked, calculate pressed , not back pressed ]
    public void TR1() {
        select = new Select(mainPage.distribution);
        select.selectByValue("T");
        sleep();
        Select select1 =  new Select(mainPage.roundingDropBox);
        select1.selectByValue("1");
        sleep();
        mainPage.sigLevel.sendKeys("0.05");
        mainPage.statistic.sendKeys("0.05");
        mainPage.firstCheckBox.click();
        mainPage.inputSigma.sendKeys(".05");
        mainPage.MeanInput.sendKeys("5");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep();
        mainPage.SubmitButton.click();
        sleep();
    }
    @Test
    //[f- distribution , two tailed , 1 , 0.05 , 0.05 , 5 , .05 ,
    ///first box unchecked , second box unchecked, calculate pressed , not back pressed ]
    public void TR2(){
        select = new Select(mainPage.distribution);
        select.selectByValue("F");
        sleep();
        Select select1 =  new Select(mainPage.roundingDropBox);
        select1.selectByValue("1");
        sleep();
        mainPage.sigLevel.sendKeys("0.05");
        mainPage.statistic.sendKeys("0.05");
        mainPage.firstCheckBox.click();
        mainPage.inputSigma.sendKeys(".05");
        mainPage.MeanInput.sendKeys("5");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        sleep();
        mainPage.SubmitButton.click();
        sleep();
    }


//    @Test
//    public void search() {
//
//        mainPage.MeanInput.clear();
//        mainPage.MeanInput.sendKeys("3");
//        mainPage.inputSigma.clear();
//        mainPage.inputSigma.sendKeys("5");
//        mainPage.inputSigma.sendKeys(Keys.RETURN);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//        sleep();
//        mainPage.SubmitButton.click();
//        WebElement result = driver.findElement(By.xpath("//*[text() = '0.7642']"));
//        assertTrue(result.isDisplayed());
//
//    }

    private static void sleep() {
        try {
            Thread.sleep(2000);     // specify milliseconds to wait
        } catch (Exception e) {
            ;
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
