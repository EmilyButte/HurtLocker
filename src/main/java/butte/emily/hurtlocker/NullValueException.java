package butte.emily.hurtlocker;

/**
 * Created by emilybutte on 10/18/16.
 */
public class NullValueException extends Exception {

    static int counter = 0;

    public NullValueException(String message){
        super(message);
    }

    public static int getCounter() {
        return counter;
    }

    //    public static String formattedErrorOutput(){
//        return "Errors\t\t\t\tseen: "+counter+" times";
//    }
}
