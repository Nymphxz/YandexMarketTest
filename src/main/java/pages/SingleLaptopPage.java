package pages;

import actions.Checks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SingleLaptopPage {
    public SingleLaptopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private Checks checks = new Checks();

    @FindBy(xpath="//ul[@class='n-product-tabs__list']/li[2]")
    private WebElement specs;

    public SingleLaptopPage checkSingleLaptopPage() {
        checks.checkSingleLaptopPage(specs);
        return new SingleLaptopPage(driver);
    }

    public SingleLaptopPage clickSpecs(){
        specs.click();
        return new SingleLaptopPage(driver);
    }
}
