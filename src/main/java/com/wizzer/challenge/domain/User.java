package com.wizzer.challenge.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
public class User {

    String id;

    String email;

    @With
    Boolean isEnabled;
}
