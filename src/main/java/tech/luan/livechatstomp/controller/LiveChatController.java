package tech.luan.livechatstomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import tech.luan.livechatstomp.domain.ChatInPut;
import tech.luan.livechatstomp.domain.ChatOutPut;

@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutPut newMessage(ChatInPut input){
        return new ChatOutPut(HtmlUtils.htmlEscape(input.user() + ": " + input.message()));
    }
}
