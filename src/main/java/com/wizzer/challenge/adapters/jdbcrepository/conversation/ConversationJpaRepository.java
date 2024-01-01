package com.wizzer.challenge.adapters.jdbcrepository.conversation;

import com.wizzer.challenge.adapters.jdbcrepository.conversation.model.ConversationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ConversationJpaRepository extends CrudRepository<ConversationEntity, Long> {
    @Query(value = "SELECT (con.id) "+
            " FROM conversation con" +
            " JOIN PERSON_CONVERSATION pc  ON pc.conversation_id = con.id" +
            " JOIN PERSON per ON per.id = pc.person_id" +
            " WHERE per.id = :userId AND con.enabled= true", nativeQuery = true)
    List<Integer> getConversationByUserId(@Param("userId") String userId);
}
