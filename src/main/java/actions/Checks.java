package actions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Checks {

    public void checkMainPage(WebDriver driver, WebElement searchField) {
        Assert.assertEquals(driver.getCurrentUrl(), "https://market.yandex.ru/");
        Assert.assertTrue(searchField.isDisplayed() && searchField.isEnabled());
    }

    public void checkButton(WebElement searchButton){
        Assert.assertTrue(searchButton.isDisplayed() && searchButton.isEnabled());
    }

    public void checkComputersPage(WebElement computers_text, WebElement laptops) {
        Assert.assertEquals(computers_text.getText(),"Компьютеры");
        Assert.assertEquals(laptops.getText(),"Ноутбуки");
        Assert.assertTrue(laptops.isDisplayed() && laptops.isEnabled());
    }

    public void checkLaptopPage(WebElement laptop_title, WebElement maxprice, WebElement selectHP, WebElement checkboxHP,
                                WebElement selectLenovo, WebElement checkboxLenovo, WebElement selectBlack, WebElement selectWhite, WebElement priceSort) {
        Assert.assertEquals(laptop_title.getText(), "Ноутбуки");
        Assert.assertTrue(maxprice.isDisplayed() && maxprice.isEnabled());
        Assert.assertTrue(selectHP.isDisplayed() && selectHP.isEnabled() && !checkboxHP.isSelected());
        Assert.assertTrue(selectLenovo.isDisplayed() && selectLenovo.isEnabled() && !checkboxLenovo.isSelected());
        Assert.assertTrue(selectBlack.isDisplayed() && selectBlack.isEnabled());
        Assert.assertTrue(selectWhite.isDisplayed() && selectWhite.isEnabled());
        Assert.assertTrue(priceSort.isDisplayed() && priceSort.isEnabled());
    }

    public void checkCheckbox(WebElement checkboxHP, WebElement checkboxLenovo){
        Assert.assertTrue(checkboxHP.isSelected());
        Assert.assertTrue(checkboxLenovo.isSelected());
    }

    public void checkSort(int a, int b) {
        Assert.assertTrue(a <= b);
    }

    public void checkSingleLaptopPage(WebElement specs) {
        Assert.assertTrue(specs.isDisplayed() && specs.isEnabled());
        Assert.assertEquals(specs.getText(),"Характеристики");
    }

    public void checkSpecPage(WebElement tip){
        Assert.assertTrue(tip.isDisplayed() && tip.isEnabled());
    }
}
