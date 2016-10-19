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

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }



    // The following 4 methods are used to identify patterns that match the variations in which the
    // MILK, BREAD, COOKIES and APPLES objects are identified
    public void replaceMilkValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^m\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            name = "milk";
            // milkCounter keeps track the number of occurences of the MILK object
            milkCounter++;
        }
    }

    public void replaceCookiesValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^c\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            name = "cookie";
            cookieCounter++;
        }
    }

    public void replaceBreadValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^b\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            name = "bread";
            breadCounter++;
        }
    }

    public void replaceApplesValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^a\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            name = "apples";
            appleCounter++;
        }
    }

    public static int getCounter(String name) {
        int temp = 0;
        switch (name) {
            case "milk":
                temp = milkCounter;
                break;
            case "bread":
                temp = breadCounter;
                break;
            case "cookies":
                temp = cookieCounter;
                break;
            case "apples":
                temp=appleCounter;
        }
        return temp;
    }

    // This method calls the individual replace methods from above and throws an exception if the name = null
    public void replaceAllFoodObjectNames() throws NullValueException {
        if (name.equals(null)) {
            throw new NullValueException("Name value is null");
        }
        replaceMilkValuePattern(name);
        replaceCookiesValuePattern(name);
        replaceApplesValuePattern(name);
        replaceBreadValuePattern(name);
    }

    //This method throws an exception if the price value is null
    public void checkPrice() throws NullValueException {
        if(price.equals(null)){
            switch (name) {
                case "milk":
                    milkCounter--;
                    break;
                case "bread":
                   breadCounter--;
                    break;
                case "cookies":
                    cookieCounter--;
                    break;
                case "apples":
                    appleCounter--;
            }
            throw new NullValueException("Null Value");
        }
    }
}

