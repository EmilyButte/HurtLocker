package butte.emily.hurtlocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emilybutte on 10/18/16.
 */
public class FoodOrganizer {

    //foodList holds the food objects and each objects associated key:value pairs
    ArrayList<Food> foodList = new ArrayList<>();

    //Each map below holds a key:value pair of FOOD objects - Ex. key = Milk, value = price
    Map<String, Integer> mapOfMilkPrices = new HashMap<>();
    Map<String, Integer> mapOfBreadPrices = new HashMap<>();
    Map<String, Integer> mapOfCookiesPrices = new HashMap<>();
    Map<String, Integer> mapOfApplesPrices = new HashMap<>();

    //The following 4 methods iterate through the foodList ArrayList in the same way
    public void createMilkMap(){
        //for each loop is used to iterate through the food items in the foodList ArrayList
        for(Food food: foodList){
            //if the item is working on is already found it the MAP, it just adds +1 to the count
                if(mapOfMilkPrices.keySet().contains(food.getName())){
                    mapOfMilkPrices.put(food.getPrice(), mapOfMilkPrices.get(food.getPrice()) +1);
                } else {
                    //if the item is not found to already exist in the MAP, it is added.
                    mapOfMilkPrices.put(food.getPrice(), 1);
                }
            }
        }

    public void createCookieMap(){
        for(Food food: foodList){
                if(mapOfCookiesPrices.keySet().contains(food.getName())){
                    mapOfCookiesPrices.put(food.getPrice(), mapOfCookiesPrices.get(food.getPrice()) +1);
                } else {
                    mapOfCookiesPrices.put(food.getPrice(), 1);
                }
            }
        }

    public void createBreadMap(){
        for(Food food: foodList){
                if(mapOfBreadPrices.keySet().contains(food.getName())){
                    mapOfBreadPrices.put(food.getPrice(), mapOfBreadPrices.get(food.getPrice()) +1);
                } else {
                    mapOfBreadPrices.put(food.getPrice(), 1);
                }
            }
        }

    public void createApplesMap(){
        for(Food food: foodList){
                if(mapOfApplesPrices.keySet().contains(food.getName())){
                    mapOfApplesPrices.put(food.getPrice(), mapOfApplesPrices.get(food.getPrice()) +1);
                    //if the FOOD object  is contained in the foodList, then put it into the hashmap as String/Integer pairs
                    // of the price: # occurances (found by adding 1 to the array index)
                } else {
                    mapOfApplesPrices.put(food.getPrice(), 1);
                }
            }
        }



    public void organizeFood() throws NullValueException {
        for (Food food : foodList) {
            try {
                food.replaceAllFoodObjectNames();
                food.checkPrice();

                if (!food.getPrice().equals(null)) {

                    switch (food.getName()) {
                        case "milk":
                            createMilkMap();
                            break;
                        case "bread":
                            createBreadMap();
                            break;
                        case "cookies":
                            createCookieMap();
                            break;
                        case "apples":
                            createApplesMap();
                            break;
                    }
                }

            } catch (Exception e) {

            }
        }
    }

    public void printFood(){
        System.out.println("This prints out?!?");
    }

}
