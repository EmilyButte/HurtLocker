package butte.emily.hurtlockerTest;

import butte.emily.hurtlocker.Filter;
import butte.emily.hurtlocker.Inventory;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by emilybutte on 10/17/16.
 */
public class FilterTest {

    private Filter filter;
    private Inventory inventory;

    @Before
    public void setUp(){
        filter = new Filter();
        inventory = new Inventory();
    }

    @Test
    public void splitByObjectTest(){
        String[] expected = {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016", "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016"};
        String[] actual= filter.splitByObjects("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void splitByPairsTest(){
        String[] expected = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016", "naME:BreaD", "price:1.23", "type:Food", "expiration:1/02/2016", "NAMe:BrEAD", "price:1.23", "type:Food", "expiration:2/25/2016"};
        String[] actual= filter.splitIntoPairs("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016;naME:BreaD;price:1.23;type:Food;expiration:1/02/2016;NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016");
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void valueStringPatternTest() {
        String expected = "Milk";
        String actual= filter.valueStringPattern("naMe:Milk");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valuePricePatternTest() {
        String expected = "3.23";
        String actual= filter.valuePricePattern("price:3.23");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueDatePatternTest() {
        String expected = "1/25/2016";
        String actual= filter.valueDatePattern("expiration:1/25/2016");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createFoodDataListTest(){
        filter.createFoodDataList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        int expected = 2;
        int actual = filter.foodData.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createFoodListTest() {
        filter.createFoodDataList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        filter.createFoodList();
        int expected = 2;
        int actual = Inventory.foodList.size();
        Assert.assertEquals(expected, actual);
    }
}
