package com.cristiano.cr7gpt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Messages {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    
    private String content;
    
    private LocalDateTime timestamp;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatsession_id", nullable = false)
    private ChatSession chatSession;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User sender;
}