/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/2
 */

package org.csc.nsk.java2017.task01;

import lombok.val;
import org.junit.Assert;
import org.junit.Test;

public final class MultisetTeacherTestsBasic {
    @Test
    public void testSingleAdd() {
        val testValue = new Object();

        val multiset = MultisetFactory.makeDefaultMultiset();
        multiset.add(testValue);

        Assert.assertTrue("Bad multiset size.", multiset.size() == 1);
        Assert.assertTrue("Multiset is empty.", !multiset.isEmpty());
        Assert.assertTrue("Multiset did not contain added value.", multiset.contains(testValue));

        val iterator = multiset.iterator();
        Assert.assertTrue("Iterator is empty.", iterator.hasNext());
        Assert.assertSame("Iterator did not return expected element.", testValue, iterator.next());
        Assert.assertFalse("Iterator reports more values than was added.", iterator.hasNext());
    }
}
