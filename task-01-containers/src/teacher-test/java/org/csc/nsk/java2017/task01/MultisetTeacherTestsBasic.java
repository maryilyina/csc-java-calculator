/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/2
 */

package org.csc.nsk.java2017.task01;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public final class MultisetTeacherTestsBasic {
    @Test
    public void testSingleAdd() {
        final Object testValue = new Object();

        final Multiset<Object> multiset = MultisetFactory.makeDefaultMultiset();
        multiset.add(testValue);

        Assert.assertTrue("Bad multiset size.", multiset.size() == 1);
        Assert.assertTrue("Multiset is empty.", !multiset.isEmpty());
        Assert.assertTrue("Multiset did not contain added value.", multiset.contains(testValue));

        final Iterator<Object> iterator = multiset.iterator();
        Assert.assertTrue("Iterator is empty.", iterator.hasNext());
        Assert.assertSame("Iterator did not return expected element.", testValue, iterator.next());
        Assert.assertFalse("Iterator reports more values than was added.", iterator.hasNext());
    }
}
