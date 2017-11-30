/*
 * Task 03 - PubSub
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/11/30
 */

package org.csc.nsk.java2017.task03;

import org.csc.nsk.java2017.impl.frikadelki.task03.DummyPubSubServer;

final class PubSubServerFactory {
    static PubSubServer makePubSubServer() {
        // TODO (task03): replace this with your pub-sub server instance creation
        return new DummyPubSubServer();
    }

    private PubSubServerFactory() {
    }
}
