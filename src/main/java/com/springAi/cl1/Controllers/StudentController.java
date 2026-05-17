package com.springAi.cl1.Controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final ChatClient ollamaChatClient;

    public StudentController(ChatClient ollamaChatClient) {
        this.ollamaChatClient = ollamaChatClient;
    }

    @Value("classpath:/templates/studentprompt.st")
    Resource studentPromptTemplate;

    @GetMapping("/query")
    public String courseQuery(@RequestParam String query)
    {
        return  ollamaChatClient
                .prompt()
                .user(query)
                .call()
                .content();
    }


    @GetMapping("/doubt")
    public String courseDoubt(@RequestParam String studentName,
                              @RequestParam String query)
    {

       /* String promptTemplate= """
                A student named {studentName} send the following query for java
                full stack batch : {query}

                write a response that:
                - directly answers the student's question
                - sounds human, warm, and professional
                - makes the course look valuable and practical
                - mentions relevant benefits only when suitable, such as:
                  Java fundamentals, Spring Boot, microservices, SQL, real-world projects, interview preparation, and mentorship
                - avoids overpromising
                - encourages the student to take the next step if they seem interested

                Keep the reply short, clear, and easy to understand.
                Respond with message body only.

                """;*/

        return ollamaChatClient.prompt()
                .user(u->u
                        .text(studentPromptTemplate)
                        .param("studentName",studentName)
                        .param("query",query))
                .call()
                .content();


        /*return  chatClient
                .prompt()
                .user(query)
                .call()
                .content();*/
    }
}
