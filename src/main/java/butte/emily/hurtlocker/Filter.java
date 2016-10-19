package butte.emily.hurtlocker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by emilybutte on 10/17/16.
 */
public class Filter {
    int exceptions = 0;

    ArrayList<String[]> foodData = new ArrayList<>(); //arrayList of String arrays
    FoodOrganizer foodOrganizer = new FoodOrganizer();

    public String runFilter(String output) throws NullValueException {
        createFoodDataList(output);
        createFoodList();
        foodOrganizer.organizeFood();
        foodOrganizer.printFood();
        return output;
    }

    public String[] splitByObjects(String output) {
        return output.split("##");
    }

    public String[] splitIntoPairs(String output) {
        return output.split("[^\\w:./]");
    }

    public String valueStringPattern(String foodObject) {
        Pattern p = Pattern.compile("((?<=[:])\\w+[^\\d\\W])");
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

    //Splits the input at the "##" into lines of Food Objects
    //then splits the Food Objects into
    public ArrayList createFoodDataList(String output) {
        String[] objects = splitByObjects(output); // = [naMe:Milk;price:3.23;type:Food;expiration:1/25/2016], ...}
        for (int i = 0; i < objects.length; i++) {
            String[] foodObject = splitIntoPairs(objects[i]);
            // = [[naMe:Milk], [price:3.23], [type:Food], [expiration:1/25/2016], ...]
            foodData.add(foodObject);
            //foodData is an array(list) of (string) arrays
        }
        return null;
    }

    //iterates through the foodData(array of arrays, which is really an array FOOD objects) and assigns them to a
    // position in the foodList arrayList, ultimately assigning the Key;value pairs to their corresponding object
    public ArrayList createFoodList() {
        for (String[] foodObject : foodData) {
            String name = valueDatePattern(foodObject[0]);
            String price = valuePricePattern(foodObject[1]);
            String expiration = valueDatePattern(foodObject[2]);
            String type = valueStringPattern(foodObject[3]);

            Food food = new Food(name, price, expiration, type);
            foodOrganizer.foodList.add(food);

            //output is a "foodList" with String arrays containing...
            // [Milk: price, exp date, type]
            // [Apples: price, exp date, type]
            // [Milk: price, exp date, type]...etc.
        }
        return null;
    }
}
