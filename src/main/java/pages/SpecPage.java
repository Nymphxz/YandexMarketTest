package pages;

import actions.Checks;
import actions.Operations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SpecPage {

    public SpecPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private Checks checks = new Checks();
    public Operations operations = new Operations();

    @FindBy(xpath="//div/h2[text()='Питание']//following-sibling::dl")
    private List<WebElement> power;

    @FindBy(xpath="//span[text()='Тип']/div/span")
    private WebElement tip;

    @FindBy(xpath = "//div[@class='n-hint-button__article']")
    private List<WebElement> ss;

    private class LaptopPower {
        private List<WebElement> params = null;
        private LaptopPower(List<WebElement> itemsToAdd) {
            this.params = itemsToAdd;
        }  //Конструктор
    }

    public SpecPage createLaptopPower() {
        LaptopPower laptopPower = new LaptopPower(power);
        System.out.println("Характеристики блока 'Питание':");
        for (WebElement s : laptopPower.params) {
            System.out.println(s.getText());
        }
        return new SpecPage(driver);
    }

    public SpecPage checkSpecPage(){
        checks.checkSpecPage(tip);
        return new SpecPage(driver);
    }

    public SpecPage clickTip(){
        tip.click();
        return new SpecPage(driver);
    }

    public SpecPage readPopUp(){
        for (WebElement s : ss) {
            if (s.isDisplayed()){
                System.out.println(s.getText().substring(0, s.getText().indexOf("Словарь")));
            }
        }
        System.out.println("Все сделал! Я молодец");
        return new SpecPage(driver);
    }
}
