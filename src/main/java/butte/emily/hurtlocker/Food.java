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

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void replaceMilkValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^m\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            this.name = "milk";
            milkCounter++;
        }
    }

    public void replaceCookiesValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^c\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            this.name = "cookie";
            cookieCounter++;
        }
    }

    public void replaceBreadValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^b\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            this.name = "bread";
            breadCounter++;
        }
    }

    public void replaceApplesValuePattern(String regex) {
        Pattern p = Pattern.compile("(?i)^a\\w+");
        Matcher m = p.matcher(regex);
        if(m.find()){
            this.name = "apples";
            appleCounter++;
        }
    }

    public void replaceAllNames() throws NullValueException {
        if (this.name.equals(null)) {
            throw new NullValueException("Null Value");
        }
        replaceMilkValuePattern(name);
        replaceCookiesValuePattern(name);
        replaceApplesValuePattern(name);
        replaceBreadValuePattern(name);
    }

    public void checkPrice() throws NullValueException {
        if(this.price.equals(null)){
            throw new NullValueException("Null Value");
        }
    }
}

