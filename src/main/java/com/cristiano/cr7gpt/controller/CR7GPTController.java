package com.cristiano.cr7gpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristiano.cr7gpt.dto.CR7GPTRequest;
import com.cristiano.cr7gpt.service.CR7GPTService;

@RestController
@RequestMapping("/api/cr7gpt")
public class CR7GPTController {

    @Autowired
    private CR7GPTService cr7GptService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateResponse(@RequestBody CR7GPTRequest request) {
        String responseText = cr7GptService.getResponse(request);
        return new ResponseEntity<>(responseText, HttpStatus.OK);
    }
}
