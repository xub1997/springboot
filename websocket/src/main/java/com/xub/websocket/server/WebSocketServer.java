package com.xub.websocket.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@ServerEndpoint("/websocket")
@Component
public class WebSocketServer {

    static Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    private static ConcurrentHashMap<String, Session> sessionHashMap = new ConcurrentHashMap();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        sessionHashMap.put(session.getId(), session);
        addOnlineCount();           //在线数加1
        log.info("有新连接,id:{},当前在线人数为{}", session.getId(), getOnlineCount());
        try {
            session.getBasicRemote().sendText("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        sessionHashMap.remove(this.session.getId());  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为{}", getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自id:{}的信息:{}",session.getId(), message);
        //群发消息
        for (Session item : sessionHashMap.values()) {
            try {
                item.getBasicRemote().sendText(message);
                ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("连接发生错误");
        error.printStackTrace();
        subOnlineCount();           //在线数减1
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String sessionId, String message) {
        if (sessionHashMap.containsKey(sessionId)) {
            Session thisSession = sessionHashMap.get(sessionId);
            try {
                thisSession.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 群发自定义消息
     */
    public void sendMessage(String message) {
        //群发消息
        for (Session item : sessionHashMap.values()) {
            try {
                item.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}

