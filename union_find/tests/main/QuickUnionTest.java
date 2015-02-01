package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickUnionTest {

    private QuickUnion quickUnion;
    @Before
    public void setUp() throws Exception {
        quickUnion = new QuickUnion(10);
        quickUnion.union(1,2);
        quickUnion.union(1,4);
        quickUnion.union(3,5);
        quickUnion.union(5,9);
        quickUnion.union(2,9);
        quickUnion.union(1,9);
        quickUnion.union(9,1);
    }

    @Test
    public void testConnected() throws Exception {
        Assert.assertEquals(quickUnion.connected(1,2), true);
        Assert.assertEquals(quickUnion.connected(5,2),true);
        Assert.assertEquals(quickUnion.connected(1,9),true);
        Assert.assertEquals(quickUnion.connected(3,9),true);
    }
}