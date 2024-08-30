package com.cristiano.cr7gpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristiano.cr7gpt.entities.ChatSession;

public interface ChatSessionRepository extends JpaRepository<ChatSession, Long> {

}