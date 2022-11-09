package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWhoIsTheScooterFor {

    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By stationInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneNumberInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By baltSelector = By.xpath(".//button[@value=235]");
    private final By nextFormForOrder = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]");


    private WebDriver driver;

    public PageWhoIsTheScooterFor(WebDriver driver) {
        this.driver = driver;
    }

    public PageWhoIsTheScooterFor inputName(String text) {
        driver.findElement(nameInput).sendKeys(text);
        return this;
    }

    public PageWhoIsTheScooterFor inputSurname(String text) {
        driver.findElement(surnameInput).sendKeys(text);
        return this;
    }

    public PageWhoIsTheScooterFor inputAddress(String text) {
        driver.findElement(addressInput).sendKeys(text);
        return this;
    }

    public PageWhoIsTheScooterFor inputPhoneNumber(String text) {
        driver.findElement(phoneNumberInput).sendKeys(text);
        return this;
    }

    public PageWhoIsTheScooterFor inputStation() {
        driver.findElement(stationInput).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(baltSelector));

        WebElement balt = driver.findElement(baltSelector);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", balt);

        balt.click();
        return this;
    }

    public PageWhoIsTheScooterFor clickNextFormButton() {
        driver.findElement(nextFormForOrder).click();
        return this;
    }

}
