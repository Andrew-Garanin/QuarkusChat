package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/{chatId}")
@ApplicationScoped
public class WebSocket {

    @OnOpen
    public void onOpen(Session session, @PathParam("chatId") String chatId) {
        System.out.println("onOpen> " + chatId);
    }

    @OnClose
    public void onClose(Session session, @PathParam("chatId") String chatId) {
        System.out.println("onClose> " + chatId);
    }

    @OnError
    public void onError(Session session, @PathParam("chatId") String chatId, Throwable throwable) {
        System.out.println("onError> " + chatId + ": " + throwable);
    }

    @OnMessage
    public void onMessage(Session session, @PathParam("chatId") String chatId, String message) {
        System.out.println("onMessage> " + chatId + ": " + message);
    }

}