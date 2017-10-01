/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.lang.reflect.Constructor;
import java.util.Collection;

public final class MultisetTests {
    @Rule
    public final Timeout globalTimeout = TestUtils.makeDefaultTimeoutRule();

    @Test
    public void testHasNoArgsConstructor() {
        final Class<? extends Multiset> clazz = MultisetFactory.getMultisetClass();
        try {
            final Constructor<? extends Multiset> constructor = clazz.getDeclaredConstructor();
            if (constructor == null) {
                throw new RuntimeException("This should not happen.");
            }
        } catch (final NoSuchMethodException e) {
            Assert.fail("No default constructor.");
        }
    }

    @Test
    public void testHasCollectionConstructor() {
        final Class<? extends Multiset> clazz = MultisetFactory.getMultisetClass();
        try {
            final Constructor<? extends Multiset> constructor = clazz.getDeclaredConstructor(Collection.class);
            if (constructor == null) {
                throw new RuntimeException("This should not happen.");
            }
        } catch (final NoSuchMethodException e) {
            Assert.fail("No constructor with collection.");
        }
    }

    @Test
    public void testNewDefaultMultisetIsEmpty() {
        final Multiset<Object> multiset = MultisetFactory.makeDefaultMultiset();
        Assert.assertTrue(multiset.isEmpty());
        Assert.assertTrue(multiset.size() == 0);
        Assert.assertTrue(!multiset.contains(0));
        Assert.assertTrue(!multiset.iterator().hasNext());
    }
}
