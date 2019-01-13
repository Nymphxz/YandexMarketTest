package actions;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    private static int rzn;
    public void waitUpdateSort(){
        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void calcCheap(String cheapest, String name) {
        System.out.println("Самый дешёвый ноутбук: " + name + " " + cheapest);
        cheapest = cheapest.replaceAll("[^0-9]", "");
        rzn = Integer.parseInt(cheapest);
    }

    public void calcExpensive(String expensive, String name) {
        System.out.println("Самый дорогой ноутбук: " + name + " " + expensive);
        expensive = expensive.replaceAll("[^0-9]", "");
        rzn = Integer.parseInt(expensive) - rzn;
        System.out.println("Разница в цене: " + rzn);
    }

    private List<String> strlist = new ArrayList<String>();

    public void getAllLaptops(List<WebElement> allLaptops) {
        for (WebElement s : allLaptops) {
            strlist.add(s.getText());
        }
        strlist.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Список отображаемых ноутбуков, отсортированных по названию:");
        for (String str : strlist){
            System.out.println(str);
        }
    }
}
