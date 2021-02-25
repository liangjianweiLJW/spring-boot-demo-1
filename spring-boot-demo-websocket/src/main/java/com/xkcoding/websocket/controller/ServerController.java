package com.xkcoding.websocket.controller;

import cn.hutool.core.lang.Dict;
import com.google.common.collect.Lists;
import com.xkcoding.websocket.common.WebSocketConsts;
import com.xkcoding.websocket.model.Server;
import com.xkcoding.websocket.model.WiselyMessage;
import com.xkcoding.websocket.model.WiselyResponse;
import com.xkcoding.websocket.payload.ServerVO;
import com.xkcoding.websocket.service.WebSocketService;
import com.xkcoding.websocket.util.ServerUtil;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务器监控Controller
 * </p>
 *
 * @package: com.xkcoding.websocket.controller
 * @description: 服务器监控Controller
 * @author: yangkai.shen
 * @date: Created in 2018-12-17 10:22
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @Resource
    WebSocketService webSocketService;

    @GetMapping
    public Dict serverInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        ServerVO serverVO = ServerUtil.wrapServerVO(server);
        return ServerUtil.wrapServerDict(serverVO);
    }

    //@MessageMapping即可以用来类级别上也可以用在方法级别上，类似springmvc，
    //@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。但是RequestMapping没有WebSocket连接功能
    //@SendTo可以把消息广播到路径上去，例如上面可以把消息广播到”/topic/greetings”,如果客户端在这个路径订阅消息，则可以接收到消息

    // @MessageMapping注解是前端推送到该端口 因后端配置了前缀  所有路径为 /ws-push/welcome
    @MessageMapping(WebSocketConsts.FORETOSERVERPATH)
    //注解发送信息
    //如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。客户端会接收到
    @SendTo({WebSocketConsts.SENDTO, "/testSentTo/sentTo"})
    public WiselyResponse say(WiselyMessage message) throws Exception {
        List<String> users = Lists.newArrayList();
        //此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
        users.add("d892bf12bf7d11e793b69c5c8e6f60fb");
        //发送信息
        webSocketService.send2Users(users, new WiselyResponse("admin hello"));

        return new WiselyResponse("Welcome, " + message.getName() + "!");
    }

}
