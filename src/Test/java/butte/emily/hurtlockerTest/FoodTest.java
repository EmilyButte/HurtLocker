package butte.emily.hurtlockerTest;

import butte.emily.hurtlocker.Food;
import butte.emily.hurtlocker.NullValueException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by emilybutte on 10/19/16.
 */
public class FoodTest {

    private Food food;

    @Before
    public void setUp(){
        food = new Food("name", "price", "type", "expiration");
    }

    @Test
    public void replaceMilkValuePatternTest(){
        String expected = "Milk";
        String actual= food.replaceMilkValuePattern("mIlK");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceCookiesValuePatternTest(){
        String expected = "Cookies";
        String actual= food.replaceCookiesValuePattern("c00KiE");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceBreadValuePatternTest(){
        String expected = "Bread";
        String actual= food.replaceBreadValuePattern("BrEaD");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceApplesValuePatternTest() {
        String expected = "Apples";
        String actual = food.replaceApplesValuePattern("ApPlEs");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPriceTest() throws NullValueException {
        Food food1 = new Food("Milk", "3.23", "Food", "1/25/2016");
        try {
            food1.replaceMilkValuePattern(food1.getName());
        } catch (Exception e) {

        }
        int expected = 2;
        int actual = food.getCounter("Milk");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceAllFoodObjectNamesTest() throws NullValueException {
        try {
            food.replaceAllFoodObjectNames(food.getName());
        } catch (Exception e) {

        }
        String expected = "Milk";
        String actual = food.replaceMilkValuePattern("mIlK");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCounterTest(){
        Food food1 = new Food("Milk", "3.23", "Food", "1/25/2016");
        food1.replaceMilkValuePattern(food1.getName());
        int expected = 4;
        int actual= food.getCounter("Milk") ;
        Assert.assertEquals(expected, actual);
    }
}
