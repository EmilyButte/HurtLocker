package butte.emily.hurtlocker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by emilybutte on 10/17/16.
 */
public class Filter {

    public ArrayList<String[]> foodData = new ArrayList<>();
    Inventory foodOrganizer = new Inventory();

    public void runFilter(String output) throws NullValueException {
        createFoodDataList(output);
        createFoodList();
        foodOrganizer.inventoryPrices();
        foodOrganizer.printInventory();
    }

    public String[] splitByObjects(String output) {
        return output.split("##");
    }

    public String[] splitIntoPairs(String output) {
        return output.split("[^\\w:./]");
    }

    public String valueStringPattern(String foodObject) {
        Pattern p = Pattern.compile("(?<=[:])\\w+");
        Matcher m = p.matcher(foodObject);
        while (m.find()) {
            return m.group();
        }
        return null;
    }

    public String valuePricePattern(String foodObject) {
        Pattern p = Pattern.compile("(?<=[:])\\w+\\W+\\w+\\b");
        Matcher m = p.matcher(foodObject);
        while (m.find()) {
            return m.group();
        }
        return null;
    }

    public String valueDatePattern(String foodObject) {
        Pattern p = Pattern.compile("(?<=[:])\\w+\\W++\\w+\\W+\\w+\\b");
        Matcher m = p.matcher(foodObject);
        while (m.find()) {
            return m.group();
        }
        return null;
    }


    public ArrayList createFoodDataList(String output) {
        String[] objects = splitByObjects(output);
        for (int i = 0; i < objects.length; i++) {
            String[] foodObject = splitIntoPairs(objects[i]);
            foodData.add(foodObject);
        }
        return null;
    }

    public ArrayList createFoodList() {
        for (String[] foodObject : foodData) {
            String name = valueStringPattern(foodObject[0]);
            String price = valuePricePattern(foodObject[1]);
            String expiration = valueDatePattern(foodObject[2]);
            String type = valueStringPattern(foodObject[3]);

            Food food = new Food(name, price, expiration, type);
            foodOrganizer.foodList.add(food);
        }
        return null;
    }
}
