package main;

import org.junit.Assert;
import org.junit.Test;

public class StackOfStringTest {
    Stack<String> strings;
    StackOfString stackOfString;
    FixedStringOfStack fixedStringOfStack;
    QueueOfString queueOfString;
    ResizeArrayStackOfString resizeArrayStackOfString;

    @Test
    public void testStack() throws Exception{
        strings = new Stack<String>();
        strings.push("1");
        strings.push("2");
        Assert.assertEquals(strings.pop(),"2");
        Assert.assertEquals(strings.pop(),"1");
        Assert.assertEquals(strings.isEmpty(),true);
    }
    @Test
    public void testStackOfString() throws Exception{
        stackOfString = new StackOfString();
        stackOfString.push("10");
        stackOfString.push("100");
        stackOfString.push("100");
        Assert.assertEquals(stackOfString.isEmpty(),false);
        Assert.assertEquals(stackOfString.pop(),"100");

    }
    @Test
    public void testFixedStringOfStack() throws Exception{
        fixedStringOfStack = new FixedStringOfStack(4);
        fixedStringOfStack.push("1");
        fixedStringOfStack.push("2");
        fixedStringOfStack.push("3");
        fixedStringOfStack.push("4");
        Assert.assertEquals(fixedStringOfStack.pop(),"4");
        Assert.assertEquals(fixedStringOfStack.isEmpty(),false);
    }
    @Test
    public void testQueueOfString() throws Exception{
        queueOfString = new QueueOfString();
        queueOfString.enqueue("1");
        queueOfString.enqueue("2");
        queueOfString.enqueue("3");
        Assert.assertEquals(queueOfString.dequeue(),"1");
        Assert.assertEquals(queueOfString.dequeue(),"2");
        Assert.assertEquals(queueOfString.isEmpty(),false);
    }

    @Test
    public void testResizeArrayStackOfString() throws Exception{
        resizeArrayStackOfString = new ResizeArrayStackOfString();
        resizeArrayStackOfString.push("1");
        resizeArrayStackOfString.push("2");
        resizeArrayStackOfString.push("3");
        resizeArrayStackOfString.push("4");
        Assert.assertEquals(resizeArrayStackOfString.pop(),"4");
        Assert.assertEquals(resizeArrayStackOfString.pop(),"3");
    }
}