/*
 * Task 03 - PubSub
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/11/30
 */

package org.csc.nsk.java2017.task03;

public final class ServerStartupException extends Exception {
    public ServerStartupException() {
    }

    public ServerStartupException(final String message) {
        super(message);
    }

    public ServerStartupException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ServerStartupException(final Throwable cause) {
        super(cause);
    }

    public ServerStartupException(final String message,
                                  final Throwable cause,
                                  final boolean enableSuppression,
                                  final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
