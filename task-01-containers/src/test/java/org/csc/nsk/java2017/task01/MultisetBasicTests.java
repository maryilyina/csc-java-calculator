/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import org.junit.Assert;
import org.junit.Test;

public final class MultisetBasicTests {
    @Test
    public void testNewDefaultMultisetIsEmpty() {
        final Multiset<Object> multiset = MultisetFactory.makeDefaultMultiset();
        Assert.assertTrue(multiset.isEmpty());
    }
}
