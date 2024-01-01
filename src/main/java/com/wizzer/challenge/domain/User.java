package com.wizzer.challenge.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

    String id;

    String email;

    Boolean enabled;
}
