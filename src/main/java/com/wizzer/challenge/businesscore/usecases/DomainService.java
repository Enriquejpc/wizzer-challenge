package com.wizzer.challenge.businesscore.usecases;

import com.wizzer.challenge.adapters.jdbcrepository.JdbcPersonConversationAdapter;
import com.wizzer.challenge.adapters.jdbcrepository.conversation.JdbcConversationAdapter;
import com.wizzer.challenge.adapters.jdbcrepository.person.JdbcPersonAdapter;
import com.wizzer.challenge.businesscore.exceptions.NotFoundException;
import com.wizzer.challenge.config.ErrorCode;
import com.wizzer.challenge.domain.Conversation;
import com.wizzer.challenge.domain.User;
import org.springframework.stereotype.Component;

@Component
public class DomainService {

    private final JdbcConversationAdapter jdbcConversationAdapter;
    private final JdbcPersonConversationAdapter jdbcPersonConversationAdapter;
    private final JdbcPersonAdapter jdbcPersonAdapter;

    public DomainService(JdbcConversationAdapter jdbcConversationAdapter, JdbcPersonConversationAdapter jdbcPersonConversationAdapter, JdbcPersonAdapter jdbcPersonAdapter) {
        this.jdbcConversationAdapter = jdbcConversationAdapter;
        this.jdbcPersonConversationAdapter = jdbcPersonConversationAdapter;
        this.jdbcPersonAdapter = jdbcPersonAdapter;
    }

    public Conversation checkConversation(Long conversationId) {
        return (jdbcConversationAdapter.getById(conversationId))
                .map(it -> Conversation.builder()
                        .id(it.getId())
                        .type(it.getCategoryFk())
                        .createdAt(it.getCreatedAt())
                        .subject(it.getSubject())
                        .build())
                .orElseThrow(() -> new NotFoundException(ErrorCode.RESOURCE_NOT_FOUND_ERROR));
    }

    public User checkUser(String userId) {
        var user = (jdbcPersonAdapter.getById(userId))
                .orElseThrow(() -> new NotFoundException(ErrorCode.RESOURCE_NOT_FOUND_ERROR));
        return User.builder()
                .id(user.getId())
                .email(user.getEmail())
                .isEnabled(user.getIsEnabled())
                .build();
    }
}
