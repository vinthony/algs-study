package main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickFindTest {
    private QuickFind quickFind;

    @Before
    public void setQuickFind() throws Exception{
        quickFind = new QuickFind(10);
        quickFind.union(1,4);
        quickFind.union(3,5);
        quickFind.union(5,9);
        quickFind.union(2,9);
        quickFind.union(1,9);
    }

    @Test
    public void testConnected() throws Exception{
        Assert.assertEquals(quickFind.connected(1,2),true);
        Assert.assertEquals(quickFind.connected(5,2),true);
        Assert.assertEquals(quickFind.connected(1,9),true);
        Assert.assertEquals(quickFind.connected(3,9),true);
        Assert.assertEquals(quickFind.connected(7,9),false);
        Assert.assertEquals(quickFind.connected(7,8),false);

    }

}