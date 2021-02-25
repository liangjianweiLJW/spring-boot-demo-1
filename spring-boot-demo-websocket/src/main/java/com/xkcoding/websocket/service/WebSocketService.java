package com.xkcoding.websocket.service;

import com.xkcoding.websocket.common.WebSocketConsts;
import com.xkcoding.websocket.model.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: todo
 * @Author: jianweil
 * @date: 2021/2/23 17:50
 */
@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 广播
     * 发给所有在线用户
     *
     * @param msg
     */
    public void sendMsg(WiselyResponse msg) {
        template.convertAndSend(WebSocketConsts.SENDTO, msg);
    }

    /**
     * 发送给指定用户
     *
     * @param users
     * @param msg
     */
    public void send2Users(List<String> users, WiselyResponse msg) {
        users.forEach(userName -> {
            template.convertAndSendToUser(userName, WebSocketConsts.P2PPUSHPATH, msg);
        });
    }
}
