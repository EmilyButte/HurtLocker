package butte.emily.hurtlockerTest;

import butte.emily.hurtlocker.Filter;
import org.junit.*;
import org.junit.Test;

/**
 * Created by emilybutte on 10/17/16.
 */
public class FilterTest {

    Filter filter;

    @Before
    public void setUp(){
        filter = new Filter();
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
        String actual= filter.valueStringPattern("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        Assert.assertEquals(expected, actual);
    }
}
