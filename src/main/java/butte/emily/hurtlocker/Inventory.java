package butte.emily.hurtlocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emilybutte on 10/18/16.
 */
public class Inventory {

    //foodList holds the food objects and each objects associated key:value pairs
    ArrayList<Food> foodList = new ArrayList<>();
    ArrayList<String> foodNames = new ArrayList<>();

    //Each map below holds a key:value pair of FOOD objects - Ex. key = Milk, value = price
    Map<String, Integer> mapOfMilkPrices = new HashMap<>();
    Map<String, Integer> mapOfBreadPrices = new HashMap<>();
    Map<String, Integer> mapOfCookiesPrices = new HashMap<>();
    Map<String, Integer> mapOfApplesPrices = new HashMap<>();

    ArrayList<Map<String, Integer>> maps = new ArrayList<>();

    //The following 4 methods iterate through the foodList ArrayList in the same way
    public void populateMap(Food food, Map<String, Integer> map){
        //if the item is working on is already found it the MAP, it just adds +1 to the count
                if(map.containsKey(food.getName())){
                    map.put(food.getPrice(), map.get(food.getPrice()) +1);
                } else {
                    //if the item is not found to already exist in the MAP, it is added.
                    map.put(food.getPrice(), 1);
                }
            }


    public void inventoryPrices() throws NullValueException {
        for (Food food : foodList) {
            try {
                food.replaceAllFoodObjectNames();
                food.checkPrice();

                if (!food.getPrice().equals(null)) {

                    switch (food.getName()) {
                        case "milk":
                            populateMap(food, mapOfMilkPrices);
                            break;
                        case "bread":
                            populateMap(food, mapOfBreadPrices);
                            break;
                        case "cookies":
                            populateMap(food, mapOfCookiesPrices );
                            break;
                        case "apples":
                            populateMap(food, mapOfApplesPrices);
                    }
                }

            } catch (Exception e) {
                NullValueException.counter++;
            }
        }
    }

    public void populateFoodNames(){
        foodNames.add("Milk");
        foodNames.add("Cookies");
        foodNames.add("Apples");
        foodNames.add("Bread");
    }

    public void populateMaps(){
        maps.add(mapOfMilkPrices);
        maps.add(mapOfCookiesPrices);
        maps.add(mapOfApplesPrices);
        maps.add(mapOfBreadPrices);
    }

    public String createInventoryItemFormat(String name){
        StringBuilder firstLine = new StringBuilder("name:      ");
        firstLine.append(name);
        firstLine.append("            ");
        firstLine.append("seen:     ");
        firstLine.append(Food.getCounter(name));
        firstLine.append("  times");
        return firstLine.toString();
    }

    public String doubleLineFomat(){
        StringBuilder lines = new StringBuilder("=============");
        lines.append("               ");
        lines.append("=============");
        return lines.toString();
    }

    public String singleLineFomat(){
        StringBuilder line = new StringBuilder("-------------");
        line.append("               ");
        line.append("-------------");
        return line.toString();
    }

    public String createPriceFormat(Map<String, Integer> map){
        StringBuilder priceGroup = new StringBuilder();
        for (String price : map.keySet()){
            StringBuilder priceLine = new StringBuilder("Price:      ");
            priceLine.append(price);
            priceLine.append("            ");
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
        errorLine.append("            ");
        errorLine.append("            ");
        errorLine.append("seen:     ");
        errorLine.append(NullValueException.getCounter());
        errorLine.append("  times");
        return errorLine.toString();
    }

    public void printInventory(){
        populateFoodNames();
        populateMaps();
        for (String name: foodNames) {
            System.out.println(createInventoryItemFormat(name));
            for (Map map : maps) {
                System.out.println(createPriceFormat(map));
            }

            }
        System.out.println(printErrors());
        }
}
