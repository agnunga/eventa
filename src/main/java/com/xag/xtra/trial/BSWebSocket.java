/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.xtra.trial;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author agunga
 */
@ServerEndpoint("/wsmessage")
public class BSWebSocket {

    static Set<Session> chatUsers = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void openConnection(Session session) {
        chatUsers.add(session);
        System.out.println("openConnection Session ID: " + session.getId());
        try {
            session.getBasicRemote().sendText("<p style=\"text-align: center; font: x-small; color: blue;\">"
                    + "Conected</p>");
        } catch (IOException ex) {
            System.err.println("My Error : " + ex.getMessage() + " caused by : ");
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("ID: " + session.getId() + " onMessage \" " + message + " \" ");
        String username = (String) session.getUserProperties().get("username");
        if (username == null || "".equals(username)) {
            session.getUserProperties().put("username", message);
            session.getBasicRemote().sendText("<p style=\"text-align: center; font: x-small; color: green;\">"
                    + "Howdy, " + message + ". Login Success"
                    + "</p>");
            for (Session chatUser : chatUsers) {
                if (chatUser != session) {
                    chatUser.getBasicRemote().sendText("<p style=\"text-align: center; font: x-small; color: green;\">"
                            + message + " joined.</p>");
                }
            }
        } else {

            for (Session chatUser : chatUsers) {
                String right = (chatUser != session) ? "" : " right";
                String alt = (chatUser != session) ? (username.charAt(0) + "").toUpperCase() : " Me";
                String pull = (chatUser == session) ? "pull-right" : "pull-left";
                String startOther = "<div class=\"direct-chat-msg" + right + "\">\n"
                        + " <div class=\"direct-chat-info clearfix\">\n"
                        + " <span class=\"direct-chat-name " + pull + "\">";//username

                String beforeMessage = "</span>\n"
                        + " </div>\n"
                        /*+ " <img class=\"direct-chat-img\" src=\"../dist/img/user1-128x128.jpg\" alt=\""
                        + alt + "\"> "*/
                        + " <div class=\"direct-chat-text\">\n";//message

                String end = " <div class=\"my_message_time\">"
                        + "10:39 pm"
                        + "</div></div> </div>";

                if (chatUser == session) {
                    chatUser.getBasicRemote().sendText(startOther + beforeMessage + message + end);
                } else {
                    chatUser.getBasicRemote().sendText(startOther + username + beforeMessage + message + end);
                }
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println(session.getId() + " clossed ");
    }

    @OnClose
    public void onClose(Session session) {
        String username = (String) session.getUserProperties().get("username");
        chatUsers.forEach((chatUser) -> {
            if (username != null) {
                try {
                    chatUser.getBasicRemote().sendText(""
                            + "<p style=\"text-align: center; font: x-small; color: red;\">"
                            + username + " Left. </p>");
                } catch (IOException ex) {
                    System.out.println("Caught ERROR : " + ex.getMessage());
                }
            }
        });
        chatUsers.remove(session);
        System.out.println(session.getId() + " Removed");
    }
}
