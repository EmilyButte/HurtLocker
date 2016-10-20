package butte.emily.hurtlocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by emilybutte on 10/18/16.
 */
public class Inventory {

    //foodList holds the food objects and each objects associated key:value pairs
    public static ArrayList<Food> foodList = new ArrayList<>();

    //Each map below holds a key:value pair of FOOD objects - Ex. key = Milk, value = price
    Map<String, Integer> mapOfMilkPrices = new HashMap<>();
    Map<String, Integer> mapOfBreadPrices = new HashMap<>();
    Map<String, Integer> mapOfCookiesPrices = new HashMap<>();
    Map<String, Integer> mapOfApplesPrices = new HashMap<>();

    public static Map<String, Map<String, Integer>> mapList = new LinkedHashMap<>();

    //The following 4 methods iterate through the foodList ArrayList in the same way
    public void populateMap(Food food, Map<String, Integer> map){
        String price = food.getPrice();
        //if the item is working on is already found it the MAP, it just adds +1 to the count
                if(map.containsKey(price)){
                    map.put(price, map.get(price) +1);
                } else {
                    //if the item is not found to already exist in the MAP, it is added.
                    map.put(price, 1);
                }
            }

    public void fixFood(Food food) throws NullValueException {
        food.replaceAllFoodObjectNames(food.getName());
        food.checkPrice();
    }


    public void inventoryPrices() throws NullValueException {
        for (Food food : foodList) {
            try {
                fixFood(food);
                if (!food.getPrice().equals(null)) {

                    switch (food.getName()) {
                        case "Milk":
                            populateMap(food, mapOfMilkPrices);
                            break;
                        case "Bread":
                            populateMap(food, mapOfBreadPrices);
                            break;
                        case "Cookies":
                            populateMap(food, mapOfCookiesPrices );
                            break;
                        case "Apples":
                            populateMap(food, mapOfApplesPrices);
                    }
                }

            } catch (Exception e) {
                NullValueException.counter++;
            }
        }
    }

    public void populateMapList(){
        mapList.put("Milk", mapOfMilkPrices);
        mapList.put("Bread", mapOfBreadPrices);
        mapList.put("Cookies", mapOfCookiesPrices);
        mapList.put("Apples", mapOfApplesPrices);

    }


    public String createInventoryItemFormat(String name){
        StringBuilder firstLine = new StringBuilder("name:      ");
        firstLine.append(name);
        firstLine.append("                   ");
        firstLine.append("seen:     ");
        firstLine.append(Food.getCounter(name));
        firstLine.append("  times\n");
        firstLine.append(doubleLineFomat());
        return firstLine.toString();
    }

    public String doubleLineFomat(){
        StringBuilder lines = new StringBuilder("==================");
        lines.append("               ");
        lines.append("==================");
        return lines.toString();
    }

    public String singleLineFomat(){
        StringBuilder line = new StringBuilder("------------------");
        line.append("               ");
        line.append("------------------");
        return line.toString();
    }

    public String createPriceFormat(Map<String, Integer> map){
        StringBuilder priceGroup = new StringBuilder();
        for (String price : map.keySet()){
            StringBuilder priceLine = new StringBuilder("Price:      ");
            priceLine.append(price);
            priceLine.append("                  ");
            priceLine.append("seen:     ");
            priceLine.append(map.get(price));
            priceLine.append("  times\n");
            priceLine.append(singleLineFomat());
            priceLine.append("\n");
            priceGroup.append(priceLine.toString());
        }
        return priceGroup.toString();
    }

    public String printErrors() {
        StringBuilder errorLine = new StringBuilder("Errors:      ");
        errorLine.append("                     ");
        errorLine.append("seen:    ");
        errorLine.append(NullValueException.counter);
        errorLine.append("  times");
        return errorLine.toString();
    }

    public void printInventory(){
        populateMapList();
        for (String name: mapList.keySet()) {
            System.out.println(createInventoryItemFormat(name));
            System.out.println(createPriceFormat(mapList.get(name)));
            }
        System.out.println(printErrors());
        }
}
