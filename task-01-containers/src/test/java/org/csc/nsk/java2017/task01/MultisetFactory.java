/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import org.csc.nsk.java2017.impl.frikadelki.task01.DummyMultiset;

import java.lang.reflect.Constructor;
import java.util.Collection;

final class MultisetFactory {
    static Class<? extends Multiset> getMultisetClass() {
        return DummyMultiset.class;
    }

    static <TElement> Multiset<TElement> makeDefaultMultiset() {
        try {
            final Constructor<? extends Multiset> constructor = getMultisetClass().getConstructor();
            constructor.setAccessible(true);
            final Multiset multiset = constructor.newInstance();
            //noinspection unchecked
            return (Multiset<TElement>) multiset;
        } catch (final Throwable t) {
            throw new RuntimeException("Failed to instantiate multiset class.'", t);
        }
    }

    static <TElement> Multiset<TElement> makeMultisetWithCollection(final Collection<? extends TElement> sourceCollection) {
        try {
            final Constructor<? extends Multiset> constructor = getMultisetClass().getConstructor(Collection.class);
            constructor.setAccessible(true);
            final Multiset multiset = constructor.newInstance(sourceCollection);
            //noinspection unchecked
            return (Multiset<TElement>) multiset;
        } catch (final Throwable t) {
            throw new RuntimeException("Failed to instantiate multiset class.'", t);
        }
    }

    private MultisetFactory() {
    }
}
