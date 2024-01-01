package com.wizzer.challenge.businesscore.interfaces.conversation;

import com.wizzer.challenge.domain.Conversation;

import java.util.List;

public interface ConversationQuery {
    List<Conversation> getAll();

    List<Conversation> getByUserId(String userId);

    Conversation getById(Long conversationId);

}
