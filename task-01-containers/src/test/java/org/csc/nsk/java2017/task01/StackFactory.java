/*
 * Task 01 - Containers
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/9/21
 */

package org.csc.nsk.java2017.task01;

import org.csc.nsk.java2017.impl.frikadelki.task01.DummyStack;

final class StackFactory {
    static <T> Stack<T> newStack() {
        // TODO (task01): replace this with your stack instance creation
        return new DummyStack<>();
    }

    private StackFactory() {
    }
}
