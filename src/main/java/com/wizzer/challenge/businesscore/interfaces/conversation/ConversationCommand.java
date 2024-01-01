package com.wizzer.challenge.businesscore.interfaces.conversation;

import com.wizzer.challenge.domain.Conversation;

public interface ConversationCommand {
    Integer joinUserToConversation(String userId, Long conversationId);

    Conversation create(Conversation conversation);
    Conversation update(Conversation conversation);
    void delete(Long conversationId);
}
