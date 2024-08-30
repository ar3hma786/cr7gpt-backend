package com.cristiano.cr7gpt.service.impl;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

import com.cristiano.cr7gpt.dto.CR7GPTRequest;
import com.cristiano.cr7gpt.service.CR7GPTService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CR7GPTServiceImpl implements CR7GPTService {

    private final ChatModel chatModel;

    @Override
    public String getResponse(CR7GPTRequest request) {
        // Call the chat model to get the response
        String response = chatModel.call(request.getPrompt());
        
        // Concatenate the original response and the SIUUUUUUU in separate lines
        return response;
    }
}
