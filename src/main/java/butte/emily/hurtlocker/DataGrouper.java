package butte.emily.hurtlocker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by emilybutte on 10/17/16.
 */
public class DataGrouper {

    Main main = new Main();
    String data = main.readRawDataToString();
    String[] entries;
    ArrayList<String> keyValueList = new ArrayList<>();

    public DataGrouper() throws Exception {
        try{
            separatePairs();
        }catch(Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
    // use String class .split method to separate the pairs
    public String[] separatePairs() {
        Map<String, String> map = new HashMap<String, String>();
        entries = data.split("##");
        return entries;
    }

    public ArrayList findKeyValues(){
        String temp = "";
        Pattern pattern = Pattern.compile("([\\w]+)?:([\\w]+)?;?"); // regex matching each key:value set
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            for(int i = 0; i < entries.length; i++)
                temp = matcher.group();
                keyValueList.add(temp);
        }
        return keyValueList;
    }

    public void replaceSymbols() {
        //use String.replace method to replace a regex statement with a colon(:)
    }
}