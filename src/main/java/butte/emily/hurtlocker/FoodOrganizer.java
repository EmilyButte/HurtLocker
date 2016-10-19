package butte.emily.hurtlocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emilybutte on 10/18/16.
 */
public class FoodOrganizer {

    Filter filter = new Filter();
    FoodOrganizer foodOrganizer = new FoodOrganizer();

    ArrayList<Food> foodList = new ArrayList<>(); // List lines

    Map<String, Integer> mapOfMilkCost = new HashMap<>();
    Map<String, Integer> mapOfBreadCost = new HashMap<>();
    Map<String, Integer> mapOfCookiesCost = new HashMap<>();
    Map<String, Integer> mapOfApplesCost = new HashMap<>();


    public void makeMilkMap(){
        for(Food food: foodList){
                if(mapOfMilkCost.keySet().contains(food.getName())){
                    mapOfMilkCost.put(food.getPrice(), mapOfMilkCost.get(food.getPrice()) +1);
                } else {
                    mapOfMilkCost.put(food.getPrice(), 1);
                }
            }
        }

    public void makeCookieMap(){
        for(Food food: foodList){
                if(mapOfCookiesCost.keySet().contains(food.getName())){
                    mapOfCookiesCost.put(food.getPrice(), mapOfCookiesCost.get(food.getPrice()) +1);
                } else {
                    mapOfCookiesCost.put(food.getPrice(), 1);
                }
            }
        }

    public void makeBreadMap(){
        for(Food food: foodList){
                if(mapOfBreadCost.keySet().contains(food.getName())){
                    mapOfBreadCost.put(food.getPrice(), mapOfBreadCost.get(food.getPrice()) +1);
                } else {
                    mapOfBreadCost.put(food.getPrice(), 1);
                }
            }
        }

    public void makeApplesMap(){
        for(Food food: foodList){
                if(mapOfApplesCost.keySet().contains(food.getName())){
                    mapOfApplesCost.put(food.getPrice(), mapOfApplesCost.get(food.getPrice()) +1);
                } else {
                    mapOfApplesCost.put(food.getPrice(), 1);
                }
            }
        }

    public void organizeFood() throws NullValueException {
        for (Food food : foodList) {
            try {
                food.replaceAllNames();
                food.checkPrice();

                if (!food.getPrice().equals(null)) {

                    switch (food.getName()) {
                        case "milk":
                            makeMilkMap();
                            break;
                        case "bread":
                            makeBreadMap();
                            break;
                        case "cookies":
                            makeCookieMap();
                            break;
                        case "apples":
                            makeApplesMap();
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
