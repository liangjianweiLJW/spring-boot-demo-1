package com.xkcoding.websocket.socketio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动器
 *  Socket.IO 还有一个非常重要的好处。其不仅支持 WebSocket，
 *  还支持许多种轮询机制以及其他实时通信方式，并封装了通用的接口。
 *  这些方式包含 Adobe Flash Socket、Ajax 长轮询、Ajax multipart streaming 、持久 Iframe、JSONP 轮询等。换句话说，
 *  当 Socket.IO 检测到当前环境不支持 WebSocket 时，能够自动地选择最佳的方式来实现网络的实时通信。
 * </p>
 *
 * @package: com.xkcoding.websocket.socketio
 * @description: 启动器
 * @author: yangkai.shen
 * @date: Created in 2018-12-12 13:59
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
public class SpringBootDemoWebsocketSocketioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoWebsocketSocketioApplication.class, args);
    }
}
