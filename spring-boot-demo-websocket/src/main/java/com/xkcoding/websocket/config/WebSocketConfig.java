package com.xkcoding.websocket.config;

import com.xkcoding.websocket.common.WebSocketConsts;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * <p>
 * WebSocket配置
 * .@EnableWebSocketMessageBroker：开启使用STOMP协议来传输基于代理(message broker)的消息,
 * 这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样。
 * </p>
 *
 * @package: com.xkcoding.websocket.config
 * @description: WebSocket配置
 * @author: yangkai.shen
 * @date: Created in 2018-12-14 15:58
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个Stomp的节点 /notification 端点，前端通过这个端点进行连接 并指定使用SockJS协议。
        registry.addEndpoint(WebSocketConsts.SOCKJSPATH)
            //解决跨域问题
            .setAllowedOrigins("*")
            .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息,既订阅Broker名称 user点对点 topic广播即群发，多个用逗号隔开
        registry.enableSimpleBroker(WebSocketConsts.TOPIC, WebSocketConsts.P2PPUSHBASEPATH,"/testSentTo");
        //点对点客户端接收的地址前缀 无需配置 默认/user,定义一对一推送的时候前缀
        registry.setUserDestinationPrefix(WebSocketConsts.P2PPUSHBASEPATH);
        //服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀。
        registry.setApplicationDestinationPrefixes(WebSocketConsts.WEBSOCKETPATHPERFIX);


    }

}
