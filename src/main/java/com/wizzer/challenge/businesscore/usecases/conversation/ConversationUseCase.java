package com.wizzer.challenge.businesscore.usecases.conversation;

import com.wizzer.challenge.adapters.jdbcrepository.JdbcPersonConversationAdapter;
import com.wizzer.challenge.adapters.jdbcrepository.conversation.JdbcConversationAdapter;
import com.wizzer.challenge.adapters.jdbcrepository.person.JdbcPersonAdapter;
import com.wizzer.challenge.businesscore.interfaces.conversation.ConversationCommand;
import com.wizzer.challenge.businesscore.interfaces.conversation.ConversationQuery;
import com.wizzer.challenge.businesscore.usecases.DomainService;
import com.wizzer.challenge.domain.Conversation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ConversationUseCase implements ConversationQuery, ConversationCommand {
    private final JdbcConversationAdapter jdbcConversationAdapter;
    private final JdbcPersonConversationAdapter jdbcPersonConversationAdapter;
    private final JdbcPersonAdapter jdbcPersonAdapter;

    private final DomainService domainService;

    public ConversationUseCase(JdbcConversationAdapter jdbcConversationAdapter, JdbcPersonConversationAdapter jdbcPersonConversationAdapter, JdbcPersonAdapter jdbcPersonAdapter, DomainService domainService) {
        this.jdbcConversationAdapter = jdbcConversationAdapter;
        this.jdbcPersonConversationAdapter = jdbcPersonConversationAdapter;
        this.jdbcPersonAdapter = jdbcPersonAdapter;
        this.domainService = domainService;
    }


    @Override
    public List<Conversation> getAll() {
        return jdbcConversationAdapter.getAll().stream()
                .map(it -> Conversation.builder()
                        .id(it.getId())
                        .type(Integer.valueOf(it.getConversationCategoryType().getDescription()))
                        .subject(it.getSubject())
                        .createdAt(it.getCreatedAt())
                        .enabled(it.getIsEnabled())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public List<Conversation> getByUserId(String userId) {
        return jdbcConversationAdapter.getConversationByUser(domainService.checkUser(userId).getId()).stream()
                .map(it -> domainService.checkConversation(it.longValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Conversation getById(Long conversationId) {
        return domainService.checkConversation(conversationId);
    }

    @Override
    public Integer joinUserToConversation(String userId, Long conversationId) {
        return jdbcPersonConversationAdapter.joinUserToConversation(domainService.checkUser(userId).getId(), domainService.checkConversation(conversationId).getId()).getId();
    }

    @Override
    public Conversation create(Conversation conversation) {
        return null;
    }

    @Override
    public Conversation update(Conversation conversation) {
        return null;
    }

    @Override
    public void delete(Long conversationId) {

    }

}
