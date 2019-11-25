package com.xub.websocket.controller;

import com.xub.websocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-25 18:15
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@RestController
public class TestController {

    @Autowired
    private WebSocketServer webSocketServer;
}
