package com.example.softproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.statskingdom.com/p_value.html
public class MainPage {
    @FindBy(css = "input[id='x1']")
    public WebElement MeanInput;

    @FindBy(css = "input[id='sigma1']")
    public WebElement inputSigma;

    @FindBy(css = "input[id='alpha']")
    public WebElement sigLevel;

    @FindBy(css = "input[id='xp']")
    public WebElement statistic;

    @FindBy(xpath = "//*[@id='submit1']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//*[@id='distribution1']")
    public WebElement distribution;

    @FindBy(xpath = "//*[@id='adv1']")
    public WebElement secondCheckBox;

    @FindBy(xpath = "//*[@id='digits']")
    public WebElement roundingDropBox;

    @FindBy(css = "html > body > div:nth-of-type(3) > div > div:nth-of-type(1) > form:nth-of-type(1) > div:nth-of-type(10) > div")
    public WebElement firstCheckBox;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
