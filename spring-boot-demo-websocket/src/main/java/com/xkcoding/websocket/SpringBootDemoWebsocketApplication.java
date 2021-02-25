package com.xkcoding.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>
 * 启动器
 * WebSocket是在HTML5基础上单个TCP连接上进行全双工通讯的协议，
 * 只要浏览器和服务器进行一次握手，就可以建立一条快速通道，两者就可以实现数据互传了。
 * 说白了，就是打破了传统的http协议的无状态传输（只能浏览器请求，服务端响应），
 * websocket全双工通讯，就是浏览器和服务器进行一次握手，浏览器可以随时给服务器发送信息，
 * 服务器也可以随时主动发送信息给浏览器了。
 * </p>
 *
 * @package: com.xkcoding.websocket
 * @description: 启动器
 * @author: yangkai.shen
 * @date: Created in 2018-12-14 14:58
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootDemoWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoWebsocketApplication.class, args);
    }

}

