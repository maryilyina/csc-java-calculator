/*
 * Task 03 - PubSub
 * CSC Nsk Java 2017
 * Created by frikadelki on 2017/11/30
 */

package org.csc.nsk.java2017.task03;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public final class ServerConfig {
    @Getter
    private final int port;

    @Getter
    private final int workersNumber;
}
