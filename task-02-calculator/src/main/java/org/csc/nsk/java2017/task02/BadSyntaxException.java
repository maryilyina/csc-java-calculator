/*
 * Task 02 - Calculator
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/10/12
 */

package org.csc.nsk.java2017.task02;

public final class BadSyntaxException extends RuntimeException {
    public BadSyntaxException() {
    }

    public BadSyntaxException(final String message) {
        super(message);
    }

    public BadSyntaxException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BadSyntaxException(final Throwable cause) {
        super(cause);
    }

    public BadSyntaxException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
