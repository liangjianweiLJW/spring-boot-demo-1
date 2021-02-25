package com.xkcoding.websocket.common;

/**
 * <p>
 * WebSocket常量
 * </p>
 *
 * @package: com.xkcoding.websocket.common
 * @description: WebSocket常量
 * @author: yangkai.shen
 * @date: Created in 2018-12-14 16:01
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface WebSocketConsts {
    String PUSH_SERVER = "/topic/server";

    //前端发送给服务端请求地址
    public static final String FORETOSERVERPATH = "/welcome";

    //webSocket相关配置
    //链接地址
    public static String SOCKJSPATH = "/notification";
    //消息代理路径
    public static String TOPIC = "/topic";
    //客户端点对点消息推送地址前缀
    public static final String P2PPUSHBASEPATH = "/user";
    //服务端接收推送前缀
    public static String WEBSOCKETPATHPERFIX = "/ws-push";

    //服务端生产地址,客户端订阅此地址以接收服务端生产的消息
    public static final String SENDTO = "/topic/getResponse";

    //点对点消息推送地址后缀,最后的地址为/user/用户识别码/msg
    public static final String P2PPUSHPATH = "/msg";

}
