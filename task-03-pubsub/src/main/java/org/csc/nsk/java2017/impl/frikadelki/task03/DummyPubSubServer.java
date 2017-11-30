/*
 * Task 03 - PubSub
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/11/30
 */

package org.csc.nsk.java2017.impl.frikadelki.task03;

import org.csc.nsk.java2017.task03.PubSubServer;
import org.csc.nsk.java2017.task03.ServerConfig;
import org.csc.nsk.java2017.task03.ServerStartupException;

public final class DummyPubSubServer implements PubSubServer {
    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void start(final ServerConfig config) throws ServerStartupException {
        throw new ServerStartupException();
    }

    @Override
    public void stop() {
    }
}
