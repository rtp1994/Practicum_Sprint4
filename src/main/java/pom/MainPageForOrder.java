package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageForOrder {

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    private final By OrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By SecondOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') or (@class='Button_Button__ra12g')]");
    private final By CookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");


    private WebDriver driver;

    public MainPageForOrder(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageForOrder open() {
        driver.get(url);
        return this;
    }

    public MainPageForOrder clickForCookies() {
        driver.findElement(CookiesButton).click();
        return this;
    }

    public MainPageForOrder clickForCreatingOrder() {
        driver.findElement(SecondOrderButton).click();
        return this;
    }


}
