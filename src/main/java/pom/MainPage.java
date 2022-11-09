package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";



    private final By accordionFirstItemButton = By.xpath(".//div[@id='accordion__heading-0']");
    private final By accordionSecondItemButton = By.xpath(".//div[@id='accordion__heading-1']");
    private final By accordionThirdItemButton = By.xpath(".//div[@id='accordion__heading-2']");
    private final By accordionFourthItemButton = By.xpath(".//div[@id='accordion__heading-3']");
    private final By accordionFifthItemButton = By.xpath(".//div[@id='accordion__heading-4']");
    private final By accordionSixthItemButton = By.xpath(".//div[@id='accordion__heading-5']");
    private final By accordionSeventhItemButton = By.xpath(".//div[@id='accordion__heading-6']");
    private final By accordionEighthItemButton = By.xpath(".//div[@id='accordion__heading-7']");

    private final By accordionFirstItemHidden = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final By accordionSecondItemHidden = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final By accordionThirdItemHidden = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final By accordionFourthItemHidden = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final By accordionFifthItemHidden = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final By accordionSixthItemHidden = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final By accordionSeventhItemHidden = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final By accordionEighthItemHidden = By.xpath(".//div[@id='accordion__panel-7']/p");

    private final By CookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(url);
        return this;
    }

    public MainPage clickForCookies() {
        driver.findElement(CookiesButton).click();
        return this;
    }


    public MainPage checkOpenedQuestions(int number, String hiddenText) {
        WebElement element = driver.findElement(accordionFifthItemButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(accordionFifthItemButton));
        if (number == 1) {
            driver.findElement(accordionFirstItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionFirstItemHidden));
            String hiddenPageText = driver.findElement(accordionFirstItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);
        } else if (number == 2) {
            driver.findElement(accordionSecondItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionSecondItemHidden));
            String hiddenPageText = driver.findElement(accordionSecondItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);
        }
        else if (number == 3) {
            driver.findElement(accordionThirdItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionThirdItemHidden));
            String hiddenPageText = driver.findElement(accordionThirdItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);
        }
        else if (number == 4) {
            driver.findElement(accordionFourthItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionFourthItemHidden));
            String hiddenPageText = driver.findElement(accordionFourthItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);
        }
        else if (number == 5) {
            driver.findElement(accordionFifthItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionFifthItemHidden));
            String hiddenPageText = driver.findElement(accordionFifthItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);

        }
        else if (number == 6) {
            driver.findElement(accordionSixthItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionSixthItemHidden));
            String hiddenPageText = driver.findElement(accordionSixthItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);
        }
        else if (number == 7) {
            driver.findElement(accordionSeventhItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionSeventhItemHidden));
            String hiddenPageText = driver.findElement(accordionSeventhItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);
        }
        else if (number == 8) {
            driver.findElement(accordionEighthItemButton).click();
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(accordionEighthItemHidden));
            String hiddenPageText = driver.findElement(accordionEighthItemHidden).getText();
            Assert.assertEquals(hiddenText, hiddenPageText);
        }
        return this;
    }


}
