
package orderstatus;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.GeckoDriverService;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPageForOrder;
import pom.PageAboutRent;
import pom.PageWhoIsTheScooterFor;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class CheckCreatingOrderParam {

    private final String Name;
    private final String Surname;
    private final String Address;
    private final String PhoneNumber;
    private final String CommentForCourier;


    public CheckCreatingOrderParam(String Name, String Surname, String Address, String PhoneNumber, String CommentForCourier) {
        this.Name = Name;
        this.Surname = Surname;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.CommentForCourier = CommentForCourier;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                { "Иван", "Иванов", "Ленина, 8", "89009909000", "Нет"},
                { "Petr", "Ivanov", "Malisheva, 8", "89009909000", "-"},
        };
    }


    public static final String dataOfOrder(){
        String dataOfOrder = "";
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.DAY_OF_YEAR, 3);
        Date finalDate = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        dataOfOrder = formatter.format(finalDate);
        return dataOfOrder;
    }

    private WebDriver driver;

    @Before
    public void setUp() {


        //  GeckoDriverService gecko = new GeckoDriverService.Builder()
        //          .usingDriverExecutable(new File("C:/cygwin64/home/Basek/sprint4/drivers/geckodriver.exe"))
        //          .usingFirefoxBinary(new FirefoxBinary(new File("C:/Program Files/Mozilla Firefox/firefox.exe")))
        //          .build();

        //  driver = new FirefoxDriver(gecko);


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test

    public void orderCreated() {
        MainPageForOrder mainPageForOrder = new MainPageForOrder(driver);

        mainPageForOrder
                .open()
                .clickForCookies()
                .clickForCreatingOrder();

        PageWhoIsTheScooterFor pageWhoIsTheScooterFor = new PageWhoIsTheScooterFor(driver);


        pageWhoIsTheScooterFor
                .inputName(Name)
                .inputSurname(Surname)
                .inputAddress(Address)
                .inputStation()
                .inputPhoneNumber(PhoneNumber)
                .clickNextFormButton();

        PageAboutRent pageAboutRent = new PageAboutRent(driver);

        pageAboutRent
                .inputComment(CommentForCourier)
                .dataOfDelivery(dataOfOrder())
                .clickChooseColour()
                .inputChoosePeriodOfRent()
                .clickOrder()
                .clickOrderConfirmation()
                .clickOrderStatus();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}


