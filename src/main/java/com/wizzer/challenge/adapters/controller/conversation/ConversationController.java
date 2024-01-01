package com.wizzer.challenge.adapters.controller.conversation;

import com.wizzer.challenge.businesscore.interfaces.conversation.ConversationQuery;
import com.wizzer.challenge.domain.Conversation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/challenge/conversations")
public class ConversationController {

    private final ConversationQuery conversationQuery;

    public ConversationController(ConversationQuery conversationQuery) {
        this.conversationQuery = conversationQuery;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Conversation>> getAll() {
        return ResponseEntity.ok().body(conversationQuery.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conversation> getById(@PathVariable("id") Long conversationId) {
        return ResponseEntity.ok().body(conversationQuery.getById(conversationId));
    }

    @GetMapping(value = "/byUser/{userId}")
    public ResponseEntity<List<Conversation>> getByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok().body(conversationQuery.getByUserId(userId));
    }
}
