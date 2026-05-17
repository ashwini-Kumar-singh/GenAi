package com.springAi.cl1.Controllers;

import com.springAi.cl1.Advisor.CustomAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom-advisor")
public class CustomAdvisorController {

    private final ChatClient ollamaChatClient;

    public CustomAdvisorController(ChatClient ollamaChatClient) {
        this.ollamaChatClient = ollamaChatClient;
    }

    public CustomAdvisorResponse query(@RequestParam String msg){
        ChatClientResponse response = ollamaChatClient
                .prompt()
                .advisors(new CustomAdvisor())
                .user(msg)
                .call().chatClientResponse();
        return new CustomAdvisorResponse(response.chatResponse().getResult().getOutput().getText(), "Custom Advisor", response.context().get(CustomAdvisor.END_TIME));
    }


    public record CustomAdvisorResponse(String name, String advisorUsed, Object endTime) {
    }
}
