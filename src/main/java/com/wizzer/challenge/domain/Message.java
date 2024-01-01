package com.wizzer.challenge.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {

    String id;

    String content;

    String publicationDate;

    String modificationDate;

    String userId;

    String conversationId;

}
