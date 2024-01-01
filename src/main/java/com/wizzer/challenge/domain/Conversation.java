package com.wizzer.challenge.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Conversation {

    String id;

    String subject;

    String createdAt;

    Boolean enabled;

    String type;
}
