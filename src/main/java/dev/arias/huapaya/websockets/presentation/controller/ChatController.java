package dev.arias.huapaya.websockets.presentation.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import dev.arias.huapaya.websockets.model.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        chatMessage.setContent(HtmlUtils.htmlEscape(chatMessage.getContent()));
        return chatMessage;
    }

}
