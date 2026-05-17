package com.springAi.cl1.Controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multimodal")
public class MultiModalController {

    private final ChatClient openAiChatClient;

    private final ChatClient googleGenAiChatClient;

    private final ChatClient ollamaChatClient;

    public MultiModalController(ChatClient openAiChatClient, ChatClient googleGenAiChatClient, ChatClient ollamaChatClient) {
        this.openAiChatClient = openAiChatClient;
        this.googleGenAiChatClient = googleGenAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    @GetMapping("/openai/chat")
    public String openAiChat(@RequestParam("msg") String msg) {
        return openAiChatClient.prompt(msg).call().content();
    }

    @GetMapping("/googlegenai/chat")
    public String googleGenAiChat(@RequestParam("msg") String msg) {
        return googleGenAiChatClient
                .prompt(msg).call().content();
    }

    @GetMapping("/ollama/chat")
    public String ollamaChat(@RequestParam("msg") String msg) {
        return ollamaChatClient
                .prompt(msg).call().content();
    }
}
