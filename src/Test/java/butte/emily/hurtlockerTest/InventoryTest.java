package butte.emily.hurtlockerTest;

import butte.emily.hurtlocker.Inventory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by emilybutte on 10/19/16.
 */
public class InventoryTest {

    @Test
    public void populateMapTest(){
        Inventory inventory = new Inventory();
        inventory.populateMapList();
        int expected = 4;
        int actual = Inventory.mapList.size();
        Assert.assertEquals(expected, actual);
    }
}
