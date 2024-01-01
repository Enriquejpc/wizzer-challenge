package com.wizzer.challenge.businesscore.interfaces.user;

import com.wizzer.challenge.domain.User;

public interface UserCommand {

    User create(User user);
    User update(User user);
    void delete(String userId);
    Integer joinToConversation(String userId, Integer conversationId);

}
