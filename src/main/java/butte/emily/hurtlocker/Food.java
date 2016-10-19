package butte.emily.hurtlocker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by emilybutte on 10/17/16.
 */
public class Food {

    //Given data set is a list of FOOD items with associated NAMES, PRICE, TYPE, EXPIRATION, all of the String dataType
    String name;
    String price;
    String type;
    String expiration;

    // Used to keep track of the number of occurences of each FOOD object
    public static int milkCounter = 0;
    public static int breadCounter = 0;
    public static int appleCounter = 0;
    public static int cookieCounter = 0;

    //Constructor is constructed using the fields associated with the list of Food items
    public Food(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    //Getters amd Setters can be established to get/set the fields
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    // The following 4 methods are used to identify patterns that match the variations in which the
    // MILK, BREAD, COOKIES and APPLES objects are identified


    public String replaceMilkValuePattern(String foodName) {
        Pattern p = Pattern.compile("(?i)^m\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            name = "Milk";
            // milkCounter keeps track the number of occurences of the MILK object
            milkCounter++;
            return name;
        }
        return null;
    }

    public String replaceCookiesValuePattern(String foodName) {
        Pattern p = Pattern.compile("(?i)^c\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            name = "Cookies";
            cookieCounter++;
            return name;
        }
        return null;
    }

    public String replaceBreadValuePattern(String foodName) {
        Pattern p = Pattern.compile("(?i)^b\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            name = "Bread";
            breadCounter++;
            return name;
        }
        return null;
    }

    public String replaceApplesValuePattern(String foodName) {
        Pattern p = Pattern.compile("(?i)^a\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            name = "Apples";
            appleCounter++;
            return name;
        }
        return null;
    }

    public static int getCounter(String name) {
        int temp = 0;
        switch (name) {
            case "Milk":
                temp = milkCounter;
                break;
            case "Bread":
                temp = breadCounter;
                break;
            case "Cookies":
                temp = cookieCounter;
                break;
            case "Apples":
                temp=appleCounter;
        }
        return temp;
    }

    // This method calls the individual replace methods from above and throws an exception if the name = null
    public void replaceAllFoodObjectNames(String foodName) throws NullValueException {
        if (foodName == null) {
            throw new NullValueException("Name value is null");
        }
        replaceMilkValuePattern(foodName);
        replaceCookiesValuePattern(foodName);
        replaceApplesValuePattern(foodName);
        replaceBreadValuePattern(foodName);
    }

    //This method throws an exception if the price value is null
    public void checkPrice() throws NullValueException {
        if(price == null){
            switch (name) {
                case "Milk":
                    milkCounter--;
                    break;
                case "Bread":
                   breadCounter--;
                    break;
                case "Cookies":
                    cookieCounter--;
                    break;
                case "Apples":
                    appleCounter--;
            }
            throw new NullValueException("Null Value");
        }
    }
}

