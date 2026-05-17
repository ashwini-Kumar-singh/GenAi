package com.springAi.cl1.Advisor;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.AdvisorChain;
import org.springframework.ai.chat.client.advisor.api.BaseAdvisor;

public class CustomAdvisor implements BaseAdvisor {


    public static final String START_TIME="start_time";
    public static final String END_TIME="end_time";

    @Override
    public ChatClientRequest before(ChatClientRequest chatClientRequest, AdvisorChain advisorChain) {
        return chatClientRequest.mutate()
                .context(START_TIME, System.currentTimeMillis())
                .build();
    }

    @Override
    public ChatClientResponse after(ChatClientResponse chatClientResponse, AdvisorChain advisorChain) {

        Object startTime = chatClientResponse.context().get(START_TIME);
        if(startTime instanceof Long start_time){
            long duration = System.currentTimeMillis() - start_time;
            System.out.println("Duration: " + duration);
            chatClientResponse.mutate().context(END_TIME, duration).build();
        }
        return chatClientResponse;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
