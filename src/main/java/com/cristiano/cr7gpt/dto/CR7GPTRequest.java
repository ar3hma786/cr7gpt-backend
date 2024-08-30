package com.cristiano.cr7gpt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CR7GPTRequest {

	    private String prompt;
	    private String model;
	    private int maxTokens;
}
