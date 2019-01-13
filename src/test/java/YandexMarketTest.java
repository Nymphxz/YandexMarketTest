import pages.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class YandexMarketTest {
    private static WebDriver driver;
    private static MainPage mainpage;
    private static ComputersPage computerspage;
    private static LaptopPage laptoppage;
    private static SingleLaptopPage singlelaptoppage;
    private static SpecPage specpage;

    @BeforeClass
    public static void setup() {
        String browser = "chr";
        switch(browser) {
            case "chr":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ff":
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        mainpage = new MainPage(driver);
        computerspage = new ComputersPage(driver);
        laptoppage = new LaptopPage(driver);
        singlelaptoppage = new SingleLaptopPage(driver);
        specpage = new SpecPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ru/");
    }

    @Test
    public void Shopping(){
        mainpage.checkMainPage()
                .inputSearchField("Компьютеры")
                .checkButton()
                .clickSearchButton();
        computerspage.checkComputersPage()
                     .clickLaptops();
        laptoppage.checkLaptopPage()
                  .inputMaxPrice("110000")
                  .clickHP()
                  .clickLenovo()
                  .checkCheckbox()
                  .clickBlack()
                  .clickWhite()
                  .clickSort()
                  .calcCheap()
                  .clickSort()
                  .checkSort(110000)
                  .calcExpensive()
                  .getAllLaptops()
                  .clickLaptop();
        singlelaptoppage.checkSingleLaptopPage()
                        .clickSpecs();
        specpage.checkSpecPage()
                .createLaptopPower()
                .clickTip()
                .readPopUp();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
