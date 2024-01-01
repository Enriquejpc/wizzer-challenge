package com.wizzer.challenge.adapters.jdbcrepository.conversation;

import com.wizzer.challenge.adapters.jdbcrepository.conversation.model.ConversationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Component
public class JdbcConversationAdapter {

    private final ConversationJpaRepository jpaRepository;

    public JdbcConversationAdapter(ConversationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<ConversationEntity> getAll() {
        List<ConversationEntity> entities = new ArrayList<>();
        jpaRepository.findAll().iterator().forEachRemaining(entities::add);
        return entities;
    }

    public Optional<ConversationEntity> getById(Long id) {
        return jpaRepository.findById(id);
    }

    public List<Integer> getConversationByUser(String userId) {
        return jpaRepository.getConversationByUserId(userId);
    }
}
