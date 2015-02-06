package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickUnionTest {

    private QuickUnion quickUnion;
    @Before
    public void setUp() throws Exception {
        quickUnion = new QuickUnion(10);
        quickUnion.union(2,4);
        quickUnion.union(3,7);
        quickUnion.union(7,2);
        quickUnion.union(0,6);
        quickUnion.union(6,8);
        quickUnion.union(0,9);
        quickUnion.union(5,8);
        quickUnion.union(4,8);
        quickUnion.union(0,1);
        System.out.println(quickUnion.getArray());
    }

    @Test
    public void testConnected() throws Exception {
        Assert.assertEquals(quickUnion.connected(1,2),true);
        Assert.assertEquals(quickUnion.connected(5,2),true);
        Assert.assertEquals(quickUnion.connected(1,9),true);
        Assert.assertEquals(quickUnion.connected(3,9),true);
    }
}