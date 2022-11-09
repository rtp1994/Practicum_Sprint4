package DropDownList;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class CheckDropDownList {
    private WebDriver driver;


    private final int NUMBER_OF_ITEM;
    private final String HIDDEN_TEXT_IN_LIST;

    public CheckDropDownList(int NUMBER_OF_ITEM, String HIDDEN_TEXT_IN_LIST) {
        this.NUMBER_OF_ITEM = NUMBER_OF_ITEM;
        this.HIDDEN_TEXT_IN_LIST = HIDDEN_TEXT_IN_LIST;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][] {
                { 1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 1, "Сутки — 400 рублей."},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void openCorrectDropDownList() {

        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickForCookies()
                .checkOpenedQuestions(NUMBER_OF_ITEM, HIDDEN_TEXT_IN_LIST);


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

