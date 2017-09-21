/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/21
 */

package org.csc.nsk.java2017.task01;

import org.junit.Assert;
import org.junit.Test;

public final class StackTests {
    private Stack<Integer> newIntegersStack() {
        return StackFactory.newStack();
    }

    @Test
    public void testStackSize() {
        final Stack<Integer> stack = newIntegersStack();
        Assert.assertTrue(stack.size() == 0);

        final Integer value = 0;

        stack.push(value);
        Assert.assertTrue(stack.size() == 1);

        stack.pop();
        Assert.assertTrue(stack.size() == 0);
    }

    @Test
    public void testPushPop() {
        final Stack<Integer> stack = newIntegersStack();
        final Integer value = 0;

        stack.push(value);
        final Integer poppedValue = stack.pop();
        Assert.assertEquals(poppedValue, value);
    }
}
