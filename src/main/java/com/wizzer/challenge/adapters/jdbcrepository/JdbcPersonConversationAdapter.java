package com.wizzer.challenge.adapters.jdbcrepository;

import com.wizzer.challenge.adapters.jdbcrepository.conversation.ConversationJpaRepository;
import com.wizzer.challenge.adapters.jdbcrepository.person.PersonJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Component
public class JdbcPersonConversationAdapter {

    private final PersonConversationJpaRepository personConversationJpaRepository;
    private final ConversationJpaRepository conversationJpaRepository;

    private final PersonJpaRepository personJpaRepository;


    public JdbcPersonConversationAdapter(PersonConversationJpaRepository jpaRepository, ConversationJpaRepository conversationJpaRepository, PersonJpaRepository personJpaRepository) {
        this.personConversationJpaRepository = jpaRepository;
        this.conversationJpaRepository = conversationJpaRepository;
        this.personJpaRepository = personJpaRepository;
    }

    @Transactional
    public PersonConversationEntity joinUserToConversation(String personId, Integer conversationId) {
        return personConversationJpaRepository.save(PersonConversationEntity.builder()
                .conversationFk(conversationId)
                .personFk(personId)
                .build());
    }



}
