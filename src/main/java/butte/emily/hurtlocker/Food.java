package butte.emily.hurtlocker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by emilybutte on 10/17/16.
 */
public class Food {

    String name;
    String price;
    String type;
    String expiration;

    public static int milkCounter = 0;
    public static int breadCounter = 0;
    public static int appleCounter = 0;
    public static int cookieCounter = 0;

    public Food(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }


    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    public String replaceMilkValuePattern(String foodName) {
        Pattern p = Pattern.compile("(?i)^m\\w+");
        Matcher m = p.matcher(foodName);
        if(m.find()){
            name = "Milk";
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

    public void replaceAllFoodObjectNames(String foodName) throws NullValueException {
        if (foodName == null) {
            throw new NullValueException("Name value is null");
        }
        replaceMilkValuePattern(foodName);
        replaceCookiesValuePattern(foodName);
        replaceApplesValuePattern(foodName);
        replaceBreadValuePattern(foodName);
    }

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

