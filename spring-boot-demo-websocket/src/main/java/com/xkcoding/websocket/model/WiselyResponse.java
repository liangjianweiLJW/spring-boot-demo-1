package com.xkcoding.websocket.model;

/**
 * @Description: todo
 * @Author: jianweil
 * @date: 2021/2/23 17:36
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
