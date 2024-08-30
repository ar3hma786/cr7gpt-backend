package com.cristiano.cr7gpt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatSessionRequest {

    private Long userId;  
    private String sessionName; 

  
}
