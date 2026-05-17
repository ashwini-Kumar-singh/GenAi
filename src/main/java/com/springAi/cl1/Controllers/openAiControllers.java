package com.springAi.cl1.Controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai")
public class openAiControllers {

    private final ChatClient openAiChatClient;

//    public openAiControllers(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }


    public openAiControllers(ChatClient openAiChatClient) {
        this.openAiChatClient = openAiChatClient;
    }
    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}
