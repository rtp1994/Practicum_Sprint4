package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAboutRent {

    private final By periodOfRent = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By inputPeriodOfRent = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    private final By colour = By.xpath(".//input[@id='black']");
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By timeOfDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By chooseTimeOfDelivary = By.xpath(".//div[contains(@class, react-datepicker__day--selected) and @tabindex='0']");
    private final By orderClick = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");
    private final By orderClickConfirmation = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");
    private final By statusOrder = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Посмотреть статус']");

    private WebDriver driver;

    public PageAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    public PageAboutRent dataOfDelivery(String text) {
        driver.findElement(timeOfDelivery).sendKeys(text);
        return this;
    }

    public PageAboutRent inputComment(String text) {
        driver.findElement(comment).sendKeys(text);
        return this;
    }

    public PageAboutRent clickChooseColour() {

        driver.findElement(colour).click();
        return this;
    }

    public PageAboutRent inputChoosePeriodOfRent() {
        driver.findElement(periodOfRent).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(inputPeriodOfRent));

        WebElement periodTwoDays = driver.findElement(inputPeriodOfRent);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", periodTwoDays);

        periodTwoDays.click();
        return this;
    }

    public PageAboutRent clickOrder() {

        driver.findElement(orderClick).click();
        return this;
    }

    public PageAboutRent clickOrderConfirmation() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderClickConfirmation));
        driver.findElement(orderClickConfirmation).click();
        return this;
    }

    public PageAboutRent clickOrderStatus() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(statusOrder));
        return this;
    }
}
