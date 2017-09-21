/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/22
 */

package org.csc.nsk.java2017.task01;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Collection;

public final class MultisetConstructorTests {
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
    public void testCollectionConstructor() {
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
}

/*

@Test(timeOut = 1000L, sequential = true)
public class MultiSetTest {

    private Class<?> multiSetClass;

    public MultiSetTest() {
    }

    public MultiSetTest(Class<?> multiSetClass) {
        if (multiSetClass == null) {
            throw new IllegalArgumentException("multiSetClass");
        }

        this.multiSetClass = multiSetClass;
    }

    */
/*
     * This is test example
     *//*

    public void newMultiSetMustBeEmpty() throws Exception {
        assertThat(newMultiSet()).isEmpty();
        assertThat(newMultiSet()).hasSize(0);
    }


    */
/*
     * This is constructor without parameters for your MultiSet implementation.
     *//*

    private <E> MultiSet<E> newMultiSet() throws Exception {
        Constructor<?> constructor = getNoArgConstructor();
        constructor.setAccessible(true);
        return (MultiSet<E>) constructor.newInstance();
    }

    */
/*
     * This is constructor with Collection parameter for your MultiSet implementation.
     *//*

    private <E> MultiSet<E> newMultiSet(Collection c) throws Exception {
        Constructor<?> constructor = getCollectionConstructor();
        constructor.setAccessible(true);
        return (MultiSet<E>) constructor.newInstance(c);
    }

    private Constructor<?> getNoArgConstructor() throws Exception {
        return multiSetClass.getDeclaredConstructor();
    }

    private Constructor<?> getCollectionConstructor() throws Exception {
        return multiSetClass.getDeclaredConstructor(Collection.class);
    }

    private static Integer randomInteger() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
*/

