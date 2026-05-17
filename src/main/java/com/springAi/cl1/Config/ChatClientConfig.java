package com.springAi.cl1.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ChatClientConfig {

    @Bean("openAiChatClient")
    ChatClient openAiChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.builder(openAiChatModel)
                .defaultSystem("You are a helpful assistant.")
                .build();
    }

//    @Bean
//    @Primary
//    ChatClient.Builder chatClientBuilder(OpenAiChatModel openAiChatModel) {
//        return ChatClient.builder(openAiChatModel);
//    }
//
//    @Bean
//    @Primary
//    ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
//        return chatClientBuilder.build();
//    }

    @Bean("googleGenAiChatClient")
    ChatClient googleGenAiChatClient(GoogleGenAiChatModel googleGenAiChatModel) {
        return ChatClient.builder(googleGenAiChatModel)
                .defaultSystem("You are a helpful assistant.")
                .build();
    }

    @Bean("ollamaChatClient")
    ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel)
                .defaultSystem("you are email expert\" +\n" +
                        "                       \"Answer dynamically based on query and give email body in short(1-6 lines)")
                .defaultUser("How can you help me ?")
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
}
