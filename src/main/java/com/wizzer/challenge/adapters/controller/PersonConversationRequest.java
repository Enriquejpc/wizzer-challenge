package com.wizzer.challenge.adapters.controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonConversationRequest {

    @NotEmpty(message = "User Id must be included")
    @NotNull(message = "User Id must be included")
    private String userId;

    @NotEmpty(message = "Conversation Id must be included")
    @NotNull(message = "Conversation Id must be included")
    private Long conversationId;
}
