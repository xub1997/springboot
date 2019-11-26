package com.xub.websocket.controller;

import com.xub.websocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

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

    @GetMapping("/sendMessage")
    public void sendMessage(@RequestParam("userId") String userId, @RequestParam("msg") String msg) {
        webSocketServer.sendMessage(userId, msg);
    }

    @GetMapping("/sendGroupMessage")
    public void sendGroupMessage(@RequestParam("msg") String msg) {
        webSocketServer.sendMessage(msg);
    }

    @GetMapping("/getOnlineCount")
    public Integer getOnlineCount() {
        return webSocketServer.getOnlineCount();
    }


}
